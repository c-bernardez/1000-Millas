package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "carta_problema")
@PrimaryKeyJoinColumn(name="idCarta")
public class Carta_Problema extends Carta {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProblema tipo_problema;

    public Carta_Problema() {}

    public Carta_Problema(TipoProblema tipo_problema){
        super(TipoCarta.PROBLEMA);
        this.tipo_problema = tipo_problema;
    }
}
