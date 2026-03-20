package com.cami.millas.servicio;

import com.cami.millas.modelo.Jugador;
import com.cami.millas.modelo.EstadoPartida;
import com.cami.millas.modelo.Partida;
import com.cami.millas.repositorio.PartidaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaServicio {
    private final PartidaRepositorio partidaRepositorio;

    public PartidaServicio(PartidaRepositorio partidaRepositorio){
        this.partidaRepositorio = partidaRepositorio;
    }

    public Partida crearPartida(Partida partida) {
        return partidaRepositorio.save(partida);
    }

    public List<Partida> getPartidas(){
        return partidaRepositorio.findAll();
    }

    private Partida buscarPartida(int id){
        //método privado para no repetir el mismo bloque de código en getPartidaById y actualizarEstado
        Optional<Partida> partidaOptional = partidaRepositorio.findById(id);
        if (partidaOptional.isEmpty()){
            throw new RuntimeException("Partida no encontrada " + id);
        }
        return partidaOptional.get();
    }

    public Partida getPartidaById(int id){
        return buscarPartida(id);
    }

    public Partida actualizarEstado(int id, EstadoPartida estado) {
        Partida partida = buscarPartida(id);
        partida.setEstado(estado);
        return partidaRepositorio.save(partida);
    }
}
