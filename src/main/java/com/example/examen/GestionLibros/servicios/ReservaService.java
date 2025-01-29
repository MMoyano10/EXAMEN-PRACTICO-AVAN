package com.example.examen.GestionLibros.servicios;

import com.example.examen.GestionLibros.modelos.Reserva;
import com.example.examen.GestionLibros.repositorios.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    public List<Reserva> obtenerReservasPorEvento(String evento) {
        return reservaRepository.findByEvento(evento);
    }

    public List<Reserva> obtenerReservasPorFecha(String fecha) {
        return reservaRepository.findByFecha(fecha);
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
