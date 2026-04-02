package com.cami.millas.logica;

import com.cami.millas.cartas.Carta;
import com.cami.millas.modelo.*;
import com.cami.millas.repositorio.*;
import com.cami.millas.servicio.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JuegoLogica {
    private final CartaServicio cartaServicio;
    private final JugadorServicio jugadorServicio;
    private final PartidaServicio partidaServicio;
    private final ManoServicio manoServicio;
    private final CartaEnManoServicio cartaEnManoServicio;

//    1. Inicializar servicios
    public JuegoLogica(CartaServicio cartaServicio, PartidaServicio partidaServicio, JugadorServicio jugadorServicio, ManoServicio manoServicio, CartaEnManoServicio cartaEnManoServicio) {
        this.cartaServicio = cartaServicio;
        this.jugadorServicio = jugadorServicio;
        this.partidaServicio = partidaServicio;
        this.manoServicio = manoServicio;
        this.cartaEnManoServicio = cartaEnManoServicio;
    }


    //    2. Iniciar partida
    public Partida iniciarPartida (){
        Partida p = new Partida(EstadoPartida.EN_CURSO);
        return partidaServicio.crearPartida(p);
    }

//    3. Orquestar el bucle (mano, jugadores, cartas)

//  4. Finalizar la partida en los 5000 puntos
    public Jugador finalizarPartida(Partida p, List<Jugador> jugadores){
        for (Jugador j : jugadores){
            List<Mano> ms = manoServicio.getManoByPartidaAndJugador(p, j);
            int puntajeTotal = 0;
            for (Mano m : ms) {
                puntajeTotal += m.getPuntaje();
            }
            if (puntajeTotal >= 5000){
                partidaServicio.actualizarEstado(p.getIdPartida(), EstadoPartida.FINALIZADA);
                return j;
            }
        }
        return null;
    }
}
