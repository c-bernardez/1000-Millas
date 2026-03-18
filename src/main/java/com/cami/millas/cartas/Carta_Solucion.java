package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "carta_solucion")
@PrimaryKeyJoinColumn(name="idCarta")
public class Carta_Solucion extends Carta {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSolucion tipoSolucion;

    public Carta_Solucion() {}

    public Carta_Solucion(TipoSolucion tipoSolucion){
        super(TipoCarta.SOLUCION);
        this.tipoSolucion = tipoSolucion;
    }
}