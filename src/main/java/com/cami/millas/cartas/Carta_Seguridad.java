package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carta_seguridad")
public class Carta_Seguridad extends Carta {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSeguridad subtipo;

    public Carta_Seguridad() {}

    public Carta_Seguridad(TipoSeguridad subtipo){
        super(TipoCarta.SEGURIDAD);
        this.subtipo = subtipo;
    }
}
