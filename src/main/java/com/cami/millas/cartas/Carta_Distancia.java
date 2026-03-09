package com.cami.millas.cartas;

public class Carta_Distancia extends Carta {
    //'extends' makes 'Carta_Distancia' a specialization of 'Carta'
    private int distancia; //[25, 50, 75, 100, 200]

    public Carta_Distancia(int id, int distancia){
        super(id,"DISTANCIA");
        this.distancia = distancia;
    }
}
