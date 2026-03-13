package com.cami.millas.modelo;

import com.cami.millas.cartas.Carta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(CartaEnManoId.class)
public class CartaEnMano {
    //separamos el @Id del @ManyToOne porque Hibernate necesita que los campos del IdClass sean tipos simples, pero para nuestra BD necesitamos usar un objeto tipo Mano.
    @Id
    @Column(name="id_mano")
    private int idMano;

    @ManyToOne //Muchas CartasEnMano pueden pertenecer a la misma mano (ya que varia la carta)
    @JoinColumn(name="id_mano", updatable = false, insertable = false) //@JoinColumn para relaciones entre entidades
    private Mano mano;

    @Id
    @Column(name="id_carta")
    private int idCarta;

    @ManyToOne
    @JoinColumn(name="id_carta", updatable = false, insertable = false)
    private Carta carta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMano estado;

    public CartaEnMano() {}

    public CartaEnMano(Mano mano, Carta carta, EstadoMano estado) {
        this.mano = mano;
        this.idMano = mano.getIdMano();

        this.carta = carta;
        this.idCarta = carta.getIdCarta();

        this.estado = estado;
    }
}
