package com.cami.millas.cartas;

public class Carta_Seguridad extends Carta {
    private String subtipo; //[PRIORIDAD DE PASO, COMBUSTIBLE EXTRA, AS DEL VOLANTE, A PRUBEA DE PINCHADURAS]

    public Carta_Seguridad(int id, String subtipo){
        super(id, "SEGURIDAD");
        this.subtipo = subtipo;
    }
}
