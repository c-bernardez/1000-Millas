package com.cami.millas.cartas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="carta_seguridad")
@PrimaryKeyJoinColumn(name="idCarta")
public class CartaSeguridad extends Carta {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSeguridad tipoSeguridad;

    public CartaSeguridad() {}

    public CartaSeguridad(TipoSeguridad tipoSeguridad){
        super(TipoCarta.SEGURIDAD);
        this.tipoSeguridad = tipoSeguridad;
    }
}
