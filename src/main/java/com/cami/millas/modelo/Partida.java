package com.cami.millas.modelo;

public class Partida {
    private int id_partida;
    private String estado; // [EN CURSO, FINALIZADA]

    public Partida() {}

    public Partida(int id_partida, String estado) {
        this.id_partida = id_partida;
        this.estado = estado;
    }
}
