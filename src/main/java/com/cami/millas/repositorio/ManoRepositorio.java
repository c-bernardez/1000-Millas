package com.cami.millas.repositorio;

import com.cami.millas.modelo.Jugador;
import com.cami.millas.modelo.Mano;
import com.cami.millas.modelo.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManoRepositorio extends JpaRepository<Mano, Integer> {
    List<Mano> findByPartidaAndJugador(Partida partida, Jugador jugador);
}
