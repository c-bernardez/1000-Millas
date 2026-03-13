package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carta")
public abstract class Carta {
    //abstract means this class can be accessed directly, save for its child classes. It makes sense since we won't have a type-less card.
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_carta")
    private int idCarta;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_carta", nullable=false)
    private TipoCarta tipo;

    public Carta(){}

    public Carta(TipoCarta tipo){
        this.tipo = tipo;
    }
}

