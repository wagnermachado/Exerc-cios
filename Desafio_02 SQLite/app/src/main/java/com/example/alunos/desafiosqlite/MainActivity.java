package com.example.alunos.desafiosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View v) {
        Intent it = new Intent(this, InsereActivity.class);
        startActivity(it);
    }

    public void consultar(View v) {
        Intent it = new Intent(this, ConsultaActivity.class);
        startActivity(it);
    }

    public void alterar(View v) {
        Intent it = new Intent(this, AlteraActivity.class);
        startActivity(it);
    }
}
