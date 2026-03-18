package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "carta_problema")
@PrimaryKeyJoinColumn(name="idCarta")
public class CartaProblema extends Carta {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProblema tipoProblema;

    public CartaProblema() {}

    public CartaProblema(TipoProblema tipoProblema){
        super(TipoCarta.PROBLEMA);
        this.tipoProblema = tipoProblema;
    }
}
