package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carta_distancia")
public class Carta_Distancia extends Carta {
    //'extends' makes 'Carta_Distancia' a specialization of 'Carta'

    @Enumerated(EnumType.STRING)
    @Column(name="distancia", nullable=false) //logica del juego va a ser c.getDistancia.getValor()
    private Distancia distancia;

    public Carta_Distancia() {}

    public Carta_Distancia(int id, Distancia distancia){
        super(id,TipoCarta.DISTANCIA);
        this.distancia = distancia;
    }
}
