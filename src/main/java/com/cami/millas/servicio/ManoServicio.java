package com.cami.millas.servicio;

import com.cami.millas.modelo.Jugador;
import com.cami.millas.modelo.Mano;
import com.cami.millas.modelo.Partida;
import com.cami.millas.repositorio.ManoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManoServicio {
    private final ManoRepositorio manoRepositorio;

    public ManoServicio(ManoRepositorio manoRepositorio) {
        this.manoRepositorio = manoRepositorio;
    }

    public Mano inicializarMano(Partida partida, Jugador jugador){
        return manoRepositorio.save(new Mano(partida, jugador));
    }

    public Mano getManoById(int id){
        Optional<Mano> mano = manoRepositorio.findById(id);
        if (mano.isEmpty()){
            throw new RuntimeException("Mano no encontrada " + id);
        }
        return mano.get();
    }

    public List<Mano> getManoByPartidaAndJugador(Partida partida, Jugador jugador){
        return manoRepositorio.findByPartidaAndJugador(partida,jugador);
    }
}
