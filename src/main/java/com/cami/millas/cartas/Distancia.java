package com.cami.millas.cartas;

public enum Distancia {
    VEINTICINCO(25), CINCUENTA(50), SETENTAYCINCO(75), CIEN(100), DOSCIENTOS(200);

    private final int valor;

    Distancia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
