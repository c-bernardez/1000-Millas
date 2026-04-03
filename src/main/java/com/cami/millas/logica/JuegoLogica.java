package com.cami.millas.logica;

import com.cami.millas.cartas.Carta;
import com.cami.millas.modelo.*;
import com.cami.millas.repositorio.*;
import com.cami.millas.servicio.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JuegoLogica {
    private final CartaServicio cartaServicio;
    private final JugadorServicio jugadorServicio;
    private final PartidaServicio partidaServicio;
    private final ManoServicio manoServicio;
    private final CartaEnManoServicio cartaEnManoServicio;

    private final ManoLogica manoLogica;

//    1. Inicializar servicios
    public JuegoLogica(CartaServicio cartaServicio, PartidaServicio partidaServicio, JugadorServicio jugadorServicio, ManoServicio manoServicio, CartaEnManoServicio cartaEnManoServicio, ManoLogica manoLogica) {
        this.cartaServicio = cartaServicio;
        this.jugadorServicio = jugadorServicio;
        this.partidaServicio = partidaServicio;
        this.manoServicio = manoServicio;
        this.cartaEnManoServicio = cartaEnManoServicio;
        this.manoLogica = manoLogica;
    }


    //2. Iniciar partida
    public Partida iniciarPartida (){
        Partida p = new Partida(EstadoPartida.EN_CURSO);
        return partidaServicio.crearPartida(p);
    }

//  3. Orquestar el bucle (mano, jugadores, cartas)
    //a. Iniciar jugadores y definir el orden de turnos
    public List<Jugador> iniciarJugadores(List<String> nombres){
        List<Jugador> jugadores = new ArrayList<>();
        for (String nombre : nombres) {
            Jugador nuevoJugador = new Jugador(nombre);
            Jugador jugadorGuardado = jugadorServicio.crearJugador(nuevoJugador);
            jugadores.add(jugadorGuardado);
        }
        return jugadores;
    }

    //a2. Crear las manos
    public List<Mano> iniciarManos(Partida partida, List<Jugador> jugadores){
        List<Mano> manos = new ArrayList<>();
        for (Jugador j : jugadores){
            Mano nuevaMano = new Mano(partida, j);
            Mano manoGuardada = manoServicio.inicializarMano(nuevaMano);
            manos.add(manoGuardada);
        }
        return manos;
    }

    //b. Iniciar Mano y repartir cartas
    public List<CartaEnMano> iniciarMano (Partida partida, List<Jugador> jugadores){
        cartaServicio.inicializarMazo();
        List<Carta> mazo = cartaServicio.getCartas();
        List<Mano> manos = iniciarManos(partida, jugadores);
        List<CartaEnMano> cartasRepartidas =  manoLogica.repartirCartas(mazo, manos);
        cartaEnManoServicio.guardarCartas(cartasRepartidas);
        return cartasRepartidas;
    }

    //c. Manejar turnos

    //d. En caso de que termine la mano, finalizarla. Validar si terminó la partida

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
