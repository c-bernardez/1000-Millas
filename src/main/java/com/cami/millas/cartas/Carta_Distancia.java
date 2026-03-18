package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carta_distancia")
@PrimaryKeyJoinColumn(name="idCarta")
public class Carta_Distancia extends Carta {
    //'extends' makes 'Carta_Distancia' a specialization of 'Carta'

    @Enumerated(EnumType.STRING)
    @Column(nullable=false) //logica del juego va a ser c.getDistancia.getValor()
    private Distancia distancia;

    public Carta_Distancia() {}

    public Carta_Distancia(Distancia distancia){
        super(TipoCarta.DISTANCIA);
        this.distancia = distancia;
    }
}
