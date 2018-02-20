package com.example.didact.ejerciciofinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.didact.ejerciciofinal2.FormularioSeriesActivity.EXTRA_SERIE;


public class ListaSeriesActivity extends AppCompatActivity {
    static final String EXTRA_SERIE ="SERIE";

    ListView lvSeries;
    ArrayList<Serie> listaSeries = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_series);

        lvSeries = (ListView)findViewById(R.id.lvSeries);
        cargarDatos();


        Bundle b= getIntent().getExtras();

        if (b!=null){
            Serie s = b.getParcelable(FormularioSeriesActivity.EXTRA_SERIE);
            listaSeries.add(s);

        }


        AdaptadorSerie adaptadorSerie=new AdaptadorSerie(this,listaSeries);
        lvSeries.setAdapter(adaptadorSerie);
        lvSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Serie s =((Serie)parent.getItemAtPosition(position));
             /*  String nombre = s.getNombre();
               int temporada = s.getTemporada();
               int capitulo = s.getCapitulo();
               String genero = s.getGenero();
               String ano = s.getAno();
               String sinopsis = s.getSinopsis();

               Serie listaSerieEnviada = new Serie(nombre, temporada, capitulo, genero, ano, sinopsis);*/
                Intent i = new Intent(getApplicationContext(),InfoSeriesActivity.class);

                i.putExtra(EXTRA_SERIE, s);
                startActivity(i);
                finish();
            }
        });

    }

    private void cargarDatos(){
        listaSeries.add(new Serie("SpiderMan", 2, 40, "Accion", "2000", "Tio que lanza telarañas por las muñecas"));
        listaSeries.add(new Serie("Big bang theory", 17, 200, "Humor", "2005", "Frikis y sus frikadas"));
        listaSeries.add(new Serie("Simpsons", 22, 500, "Familiar", "1994", "Muñecos amarillos que hacen trastadas"));
    }


}
