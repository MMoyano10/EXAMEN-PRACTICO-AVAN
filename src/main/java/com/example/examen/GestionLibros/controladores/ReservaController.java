package com.example.examen.GestionLibros.controladores;

import com.example.examen.GestionLibros.modelos.Reserva;
import com.example.examen.GestionLibros.servicios.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // CREAR UNA RESERVA (evento)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    // CONSULTA DE RESERVAS: Buscar todas las reservas de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> obtenerReservasPorUsuario(@PathVariable Long usuarioId) {
        return reservaService.obtenerReservasPorUsuario(usuarioId);
    }

    // CONSULTA DE RESERVAS: Filtrar por evento
    @GetMapping("/evento/{evento}")
    public List<Reserva> obtenerReservasPorEvento(@PathVariable String evento) {
        return reservaService.obtenerReservasPorEvento(evento);
    }

    // CONSULTA DE RESERVAS: Filtrar por fecha
    @GetMapping("/fecha/{fecha}")
    public List<Reserva> obtenerReservasPorFecha(@PathVariable String fecha) {
        return reservaService.obtenerReservasPorFecha(fecha);
    }

    // ELIMINAR UNA RESERVA (evento)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
    }
}
