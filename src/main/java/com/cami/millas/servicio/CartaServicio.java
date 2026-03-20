package com.cami.millas.servicio;

import com.cami.millas.cartas.*;
import com.cami.millas.repositorio.CartaRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaServicio {
    private final CartaRepositorio cartaRepositorio;

    public CartaServicio(CartaRepositorio cartaRepositorio){
        this.cartaRepositorio = cartaRepositorio;
    }

    public void inicializarMazo() {
        if (cartaRepositorio.count() > 0) return;

        //CartaDistancia
        for (int i = 0; i <9; i++) {
            cartaRepositorio.save(new CartaDistancia(Distancia.VEINTICINCO));
        }
        for (int i = 0; i < 10; i++) {
            cartaRepositorio.save(new CartaDistancia(Distancia.CINCUENTA));
            cartaRepositorio.save(new CartaDistancia(Distancia.SETENTAYCINCO));
        }
        for (int i = 0; i < 12; i++) {
            cartaRepositorio.save(new CartaDistancia(Distancia.CIEN));
        }
        for (int i = 0; i < 4; i++) {
            cartaRepositorio.save(new CartaDistancia(Distancia.DOSCIENTOS));
        }

        //CartaProblema
        for (int i = 0; i <3; i++) {
            cartaRepositorio.save(new CartaProblema(TipoProblema.CHOQUE));
            cartaRepositorio.save(new CartaProblema(TipoProblema.FALTA_COMBUSTIBLE));
            cartaRepositorio.save(new CartaProblema(TipoProblema.PINCHADURA));
        }
        for (int i = 0; i <5; i++) {
            cartaRepositorio.save(new CartaProblema(TipoProblema.STOP));
        }
        for (int i = 0; i <4; i++) {
            cartaRepositorio.save(new CartaProblema(TipoProblema.VELOCIDAD_MAX));
        }

        //CartaSolucion
        for (int i = 0; i < 6; i++) {
            cartaRepositorio.save(new CartaSolucion(TipoSolucion.TALLER));
            cartaRepositorio.save(new CartaSolucion(TipoSolucion.COMBUSTIBLE));
            cartaRepositorio.save(new CartaSolucion(TipoSolucion.RUEDA_AUXILIO));
            cartaRepositorio.save(new CartaSolucion(TipoSolucion.FIN_VELOCIDAD_MAXIMA));
        }
        for (int i = 0; i <14; i++) {
            cartaRepositorio.save(new CartaSolucion(TipoSolucion.SIGA));
        }

        //CartaSeguridad
        cartaRepositorio.save(new CartaSeguridad(TipoSeguridad.PRIORIDAD_DE_PASO));
        cartaRepositorio.save(new CartaSeguridad(TipoSeguridad.AS_DEL_VOLANTE));
        cartaRepositorio.save(new CartaSeguridad(TipoSeguridad.COMBUSTIBLE_EXTRA));
        cartaRepositorio.save(new CartaSeguridad(TipoSeguridad.A_PRUEBA_DE_PINCHADURAS));
    }

    public List<Carta> getCartas(){
        return cartaRepositorio.findAll();
    }

    public Carta getCartaById(int id){
        Optional<Carta> cartaOptional = cartaRepositorio.findById(id);
        if (cartaOptional.isEmpty()){
            throw new RuntimeException("Carta no encontrada " + id);
        }
        return cartaOptional.get();
    }

    public List<Carta> getCartasByTipo(TipoCarta tipo){
        return cartaRepositorio.findByTipo(tipo);
    }
}
