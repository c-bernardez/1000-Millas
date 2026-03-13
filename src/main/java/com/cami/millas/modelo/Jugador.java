package com.cami.millas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_jugador;

    @Column(nullable = false, unique = false)
    private String nombre;

    public Jugador() {}

    public Jugador (String nombre) {
        this.nombre = nombre;
    }
}
