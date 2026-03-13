package com.cami.millas.cartas;

public class Carta_Seguridad extends Carta {
    private String subtipo; //[PRIORIDAD DE PASO, COMBUSTIBLE EXTRA, AS DEL VOLANTE, A PRUBEA DE PINCHADURAS]

    public Carta_Seguridad() {}

    public Carta_Seguridad(String subtipo){
        super(TipoCarta.SEGURIDAD);
        this.subtipo = subtipo;
    }
}
