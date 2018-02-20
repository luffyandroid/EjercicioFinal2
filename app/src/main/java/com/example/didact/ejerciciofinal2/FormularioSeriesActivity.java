package com.example.didact.ejerciciofinal2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FormularioSeriesActivity extends AppCompatActivity {
    static final String EXTRA_SERIE = "SERIE";

    EditText etNombre, etTemporada, etCapitulo, etAno, etSinopsis;
    RadioGroup rgGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_series);

        etNombre = (EditText)findViewById(R.id.etForNombre);
        etTemporada = (EditText)findViewById(R.id.etForTemporadas);
        etCapitulo = (EditText)findViewById(R.id.etForCapitulo);
        etAno = (EditText)findViewById(R.id.etForAno);
        etSinopsis = (EditText)findViewById(R.id.etForSinopsis);

        rgGenero = (RadioGroup)findViewById(R.id.rgForGenero);

    }

    public void clickBorrar(View view){

        etNombre.setText("");
        etTemporada.setText("");
        etCapitulo.setText("");
        etAno.setText("");
        etSinopsis.setText("");
        rgGenero.clearCheck();

    }

    public void clickEnviar(View view){

        String nombre = etNombre.getText().toString();
        String temporada = etTemporada.getText().toString();
        String capitulo = etCapitulo.getText().toString();
        String ano = etAno.getText().toString();
        String sinopsis = etSinopsis.getText().toString();
        int idGenero = rgGenero.getCheckedRadioButtonId();

        if (nombre.equals("") || temporada.equals("") || capitulo.equals("") || ano.equals("") || idGenero==-1){

            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogComprobacion dialogo = new DialogComprobacion();
            dialogo.show(fragmentManager, "dialogAlerta");

        }else{

            int temporadaInt = Integer.parseInt(temporada);
            int capituloInt = Integer.parseInt(capitulo);
            RadioButton rbSeleccionado = (RadioButton)findViewById(idGenero);
            String genero = rbSeleccionado.getText().toString();

            Serie serieenviada = new Serie(nombre, temporadaInt, capituloInt, genero, ano, sinopsis);

            Intent i=new Intent(getApplicationContext(),ListaSeriesActivity.class);

            i.putExtra(EXTRA_SERIE, serieenviada);

            startActivity(i);
            finish();

        }


    }

}
