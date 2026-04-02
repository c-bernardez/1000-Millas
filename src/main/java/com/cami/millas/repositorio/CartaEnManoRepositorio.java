package com.cami.millas.repositorio;

import com.cami.millas.modelo.CartaEnManoId;
import com.cami.millas.modelo.CartaEnMano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaEnManoRepositorio extends JpaRepository<CartaEnMano, CartaEnManoId> {
}
