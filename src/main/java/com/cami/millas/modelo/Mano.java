package com.cami.millas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMano;
 
    @ManyToOne
    @JoinColumn(nullable = false)
    private Partida partida;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Jugador jugador;

    private int millas_recorridas;
    private int puntaje; //millas + bonus

    public Mano() {}

    public Mano(Partida partida, Jugador jugador) {
        this.partida = partida;
        this.jugador = jugador;
    }
}
