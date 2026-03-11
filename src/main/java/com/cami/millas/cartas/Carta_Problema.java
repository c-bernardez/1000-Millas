package com.cami.millas.cartas;

public class Carta_Problema extends Carta {
    private String tipo_problema; //[STOP, VELOCIDAD MAXIMA, FALTA DE COMBUSTIBLE, CHOQUE, PINCHADURA]

    public Carta_Problema() {}

    public Carta_Problema(int id, String tipo_problema){
        super(id, "PROBLEMA");
        this.tipo_problema = tipo_problema;
    }
}
