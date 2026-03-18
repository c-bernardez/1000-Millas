package com.cami.millas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPartida;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPartida estado;

    @Column(nullable = false)
    private LocalDate fecha;

    public Partida() {}

    public Partida(EstadoPartida estado) {
        this.estado = estado;
        this.fecha = LocalDate.now();
    }
}
