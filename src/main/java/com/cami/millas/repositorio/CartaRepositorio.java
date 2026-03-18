package com.cami.millas.repositorio;

import com.cami.millas.cartas.Carta;
import com.cami.millas.cartas.TipoCarta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaRepositorio extends JpaRepository<Carta, Integer>{
    List<Carta> findByTipo(TipoCarta tipo);
}
