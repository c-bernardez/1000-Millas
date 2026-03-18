package com.cami.millas.repositorio;

import com.cami.millas.cartas.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepositorio extends JpaRepository<Carta, Integer>{
}
