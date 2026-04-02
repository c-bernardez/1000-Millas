package com.cami.millas.logica;

import com.cami.millas.cartas.Carta;
import com.cami.millas.modelo.Mano;
import com.cami.millas.modelo.CartaEnMano;
import com.cami.millas.modelo.EstadoMano;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ManoLogica {

//    1. Repartir cartas
    public List<CartaEnMano> repartirCartas(List<Carta> mazo, List<Mano> manos){
        //los argumentos vienen de JuegoLogica
        Collections.shuffle(mazo);
        List<CartaEnMano> cartasRepartidas = new ArrayList<>();
        int cartaIndex = 0;

        for (Mano mano : manos){
            for (int i = 0; i < 7; i++) {
                CartaEnMano cartaEnMano = new CartaEnMano(mano, mazo.get(cartaIndex), EstadoMano.EN_MANO);
                cartasRepartidas.add(cartaEnMano);
                cartaIndex++;
            }
        }
        return cartasRepartidas; // luego JuegoLogica debe inyectarlo al servicio de CartaEnMano
    }

//    2. Verificar que cada jugador tenga 7 cartas
    public boolean hasSevenCards(List<CartaEnMano> cartasEM){
        //JuegoLogica pasa las CEM asociadas a la mano del jugador+partida actual luego del turno y antes del proximo, validamos que n=7
        int cantidadCartas = 0;
        for (CartaEnMano cEM : cartasEM){
            if(cEM.getEstado() == EstadoMano.EN_MANO){
                cantidadCartas++;
            }
        }
        return cantidadCartas == 7;
    }

//  3. Validar que la mano haya finalizado
    public boolean isFinished(List<Integer> millas_recorridas){
        //los argumentos vienen de JuegoLogica
        for (int m :  millas_recorridas){
            if (m == 1000){ return true; }
        }
        return false;
    }

//   4. Calcular el puntaje final de la mano

}
