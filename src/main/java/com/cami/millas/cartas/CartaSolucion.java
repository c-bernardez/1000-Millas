package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "carta_solucion")
@PrimaryKeyJoinColumn(name="idCarta")
public class CartaSolucion extends Carta {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSolucion tipoSolucion;

    public CartaSolucion() {}

    public CartaSolucion(TipoSolucion tipoSolucion){
        super(TipoCarta.SOLUCION);
        this.tipoSolucion = tipoSolucion;
    }
}