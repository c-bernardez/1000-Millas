package com.cami.millas.modelo;

import com.cami.millas.cartas.Carta;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@EqualsAndHashCode
public class CartaEnManoId implements Serializable {
    private final Mano mano;
    private final Carta carta;

    public CartaEnManoId(Mano mano, Carta carta) {
        this.mano = mano;
        this.carta = carta;
    }
}
