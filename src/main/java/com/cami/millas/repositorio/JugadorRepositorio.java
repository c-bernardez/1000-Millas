package com.cami.millas.repositorio;

import com.cami.millas.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByNombre(String nombre);
}
