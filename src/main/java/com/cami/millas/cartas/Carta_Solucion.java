package com.cami.millas.cartas;

public class Carta_Solucion extends Carta {
    private String tipo_solucion; //[SIGA, FIN VELOCIDAD MAXIMA, COMBUSTIBLE, TALLER, RUEDA DE AUXILIO]

    public Carta_Solucion(int id, String tipo_solucion){
        super(id, "SOLUCION");
        this.tipo_solucion = tipo_solucion;
    }
}