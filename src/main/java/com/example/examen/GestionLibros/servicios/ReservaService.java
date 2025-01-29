package com.example.examen.GestionLibros.servicios;

import com.example.examen.GestionLibros.modelos.Reserva;
import com.example.examen.GestionLibros.repositorios.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva modificarReserva(Long id, Reserva nuevaReserva) {
        Optional<Reserva> reservaExistente = reservaRepository.findById(id);
        if (reservaExistente.isPresent()) {
            Reserva reserva = reservaExistente.get();
            reserva.setEvento(nuevaReserva.getEvento());
            reserva.setFecha(nuevaReserva.getFecha());
            reserva.setCantidadBoletos(nuevaReserva.getCantidadBoletos());
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public Iterable<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
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
