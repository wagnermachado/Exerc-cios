package com.example.alunos.mapmarker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnShowLocation;
    Button btnShowOnMap;
    TextView latitudeField;
    TextView longitudeField;
    private static final int REQUEST_CODE_PERSMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            if(ActivityCompat.checkSelfPermission(this, mPermission)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERSMISSION);
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
        btnShowLocation = (Button) findViewById(R.id.butShowLocation);
        latitudeField = (TextView) findViewById(R.id.latField);
        longitudeField = (TextView) findViewById(R.id.longField);

        btnShowLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if (gps.canGetLocation() ) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    latitudeField.setText(String.valueOf(latitude));
                    longitudeField.setText(String.valueOf(longitude));
                }else {

                    latitudeField.setText("Não disponivel...");
                    longitudeField.setText("Não disponivel...");
                    gps.showSettingsAlert();
                }
            }
        });
        btnShowOnMap = (Button) findViewById(R.id.butShowMap);
        btnShowOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(it);
            }
        });
    }

}
