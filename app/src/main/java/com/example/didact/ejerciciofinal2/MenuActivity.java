package com.example.didact.ejerciciofinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
    }

    public void nuevaSerie(View view){
        Intent i =new Intent(getApplicationContext(),FormularioSeriesActivity.class);
        startActivity(i);
        finish();
    }

    public void verSerie(View view){
        Intent i= new Intent(getApplicationContext(),ListaSeriesActivity.class);
        startActivity(i);
        finish();
    }


}
