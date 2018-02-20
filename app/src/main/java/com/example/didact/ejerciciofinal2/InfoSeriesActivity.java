package com.example.didact.ejerciciofinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoSeriesActivity extends AppCompatActivity {

    TextView tvNombre, tvTemporada, tvCapitulo, tvGenero, tvAno, tvSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_series);

        tvNombre = (TextView)findViewById(R.id.tvInfoNombre);
        tvTemporada = (TextView)findViewById(R.id.tvInfoTemporadas);
        tvCapitulo = (TextView)findViewById(R.id.tvInfoCapitulos);
        tvGenero = (TextView)findViewById(R.id.tvInfoGenero);
        tvAno = (TextView)findViewById(R.id.tvInfoAno);
        tvSinopsis = (TextView)findViewById(R.id.tvInfoSinopsis);

        Bundle b= getIntent().getExtras();

        if (b!=null){

            Serie s =b.getParcelable(ListaSeriesActivity.EXTRA_SERIE);

            tvNombre.setText(s.nombre);
            tvTemporada.setText("-Temporadas: "+s.temporada);
            tvCapitulo.setText("-Capitulos: "+s.capitulo);
            tvGenero.setText("-Género: "+s.genero);
            tvAno.setText("-Año: "+s.ano);
            tvSinopsis.setText("-Sinopsis: "+s.sinopsis);
        }

    }

    public void clickInicio (View view){
        Intent i=new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(i);
        finish();
    }

}
