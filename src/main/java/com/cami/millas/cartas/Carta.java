package com.cami.millas.cartas;

public abstract class Carta {
    //abstract means this class can be accessed directly, save for its child classes. It makes sense since we won't have a type-less card.
    private int id;
    private String tipo; //[DISTANCIA, SEGURIDAD, PROBLEMA, SOLUCION]

    public Carta(int id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }
}

