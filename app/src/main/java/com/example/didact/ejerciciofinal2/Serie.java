package com.example.didact.ejerciciofinal2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 20/02/2018.
 */

public class Serie implements Parcelable{

    String nombre;
    int temporada;
    int capitulo;
    String genero;
    String ano;
    String sinopsis;

    public static final Parcelable.Creator<Serie> CREATOR = new
            Parcelable.Creator<Serie>(){
                public Serie createFromParcel(Parcel in){
                    return new Serie(in);
                }

                public Serie[] newArray(int size){
                    return new Serie[size];
                }
            };

    public Serie(String nombre, int temporada, int capitulo, String genero, String ano, String sinopsis) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.capitulo = capitulo;
        this.genero = genero;
        this.ano = ano;
        this.sinopsis = sinopsis;
    }

    public Serie(Parcel p){
        readFromParcel(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.temporada);
        dest.writeInt(this.capitulo);
        dest.writeString(this.genero);
        dest.writeString(this.ano);
        dest.writeString(this.sinopsis);
    }

    private void readFromParcel(Parcel p){
        this.nombre = p.readString();
        this.temporada = p.readInt();
        this.capitulo = p.readInt();
        this.genero = p.readString();
        this.ano = p.readString();
        this.sinopsis = p.readString();
    }

}
