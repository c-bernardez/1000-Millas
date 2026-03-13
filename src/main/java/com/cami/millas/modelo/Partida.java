package com.cami.millas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_partida;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPartida estado;

    public Partida() {}

    public Partida(EstadoPartida estado) {
        this.estado = estado;
    }
}
