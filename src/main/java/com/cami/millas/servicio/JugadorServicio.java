package com.cami.millas.servicio;

import com.cami.millas.cartas.Carta;
import com.cami.millas.modelo.Jugador;
import com.cami.millas.repositorio.JugadorRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServicio {
    private final JugadorRepositorio jugadorRepositorio;

    public JugadorServicio(JugadorRepositorio jugadorRepositorio) {
        this.jugadorRepositorio = jugadorRepositorio;
    }

    public Jugador crearJugador(Jugador jugador) {
        return jugadorRepositorio.save(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadorRepositorio.findAll();
    }

    public Jugador getJugadorById(int id) {
        Optional<Jugador> jugadorOptional = jugadorRepositorio.findById(id);
        if (jugadorOptional.isEmpty()){
            throw new RuntimeException("Jugador no encontrado " + id);
        }
        return jugadorOptional.get();
    }

    public List<Jugador> getJugadorByName(String nombre) { return jugadorRepositorio.findByNombre(nombre); }
}
