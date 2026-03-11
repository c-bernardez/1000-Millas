package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carta_Problema extends Carta {
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_problema", nullable = false)
    private TipoProblema tipo_problema;

    public Carta_Problema() {}

    public Carta_Problema(int id, TipoProblema tipo_problema){
        super(id, "PROBLEMA");
        this.tipo_problema = tipo_problema;
    }
}
