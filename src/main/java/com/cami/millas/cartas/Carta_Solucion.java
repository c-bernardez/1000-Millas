package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carta_Solucion extends Carta {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSolucion tipo_solucion;

    public Carta_Solucion() {}

    public Carta_Solucion(int id, TipoSolucion tipo_solucion){
        super(id, TipoCarta.SOLUCION);
        this.tipo_solucion = tipo_solucion;
    }
}