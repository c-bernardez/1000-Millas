package com.cami.millas.modelo;

public class CartaEnMano {
    private int id_mano;
    private int id_carta;
    private String estado; //[EN MANO, JUGADA, DESCARTADA]

    public CartaEnMano() {}

    public CartaEnMano(int id_mano, int id_carta, String estado) {
        this.id_mano = id_mano;
        this.id_carta = id_carta;
        this.estado = estado;
    }
}
