package com.example.didact.ejerciciofinal2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DIDACT on 20/02/2018.
 */

public class AdaptadorSerie extends ArrayAdapter<Serie> {

        ArrayList<Serie> Series;
        Context c;

public AdaptadorSerie(Context c, ArrayList<Serie> Series){
        super(c, R.layout.listaseries, Series);
        this.c = c;
        this.Series = Series;



        }


@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listaseries, null);

    if(Series.get(position).getGenero().equals("Acción")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.accion);
    }else if(Series.get(position).getGenero().equals("Terror")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.terror);
    }else if(Series.get(position).getGenero().equals("Humor")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.comedia);
    }else if(Series.get(position).getGenero().equals("Amor")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.amor);
    }else if(Series.get(position).getGenero().equals("Familiar")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.familiar);
    }else if(Series.get(position).getGenero().equals("Aventura")){
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.aventura);
    }else{
        ImageView iv_genero = (ImageView) item.findViewById(R.id.iv_genero);
        iv_genero.setImageResource(R.drawable.defecto);
    }


        TextView tv_nombre=(TextView)item.findViewById(R.id.tvListaNombre);
        tv_nombre.setText(Series.get(position).getNombre());


        TextView tv_genero=(TextView)item.findViewById(R.id.tvListaGenero);
        tv_genero.setText(Series.get(position).getGenero());

        TextView tv_ano=(TextView)item.findViewById(R.id.tvListaAno);
        tv_ano.setText(Series.get(position).getAno());

        return item;
        }
        }
