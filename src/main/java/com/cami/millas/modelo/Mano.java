package com.cami.millas.modelo;

public class Mano {
    private int id_mano;
    private int id_partida;
    private int id_jugador;
    private int millas_recorridas;
    private int puntaje; //millas + bonus

    public Mano() {}

    public Mano(int id_mano, int id_partida, int id_jugador) {
        this.id_mano = id_mano;
        this.id_partida = id_partida;
        this.id_jugador = id_jugador;
    }
}
