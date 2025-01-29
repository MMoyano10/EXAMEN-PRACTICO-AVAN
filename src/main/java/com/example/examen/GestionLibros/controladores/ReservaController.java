package com.example.examen.GestionLibros.controladores;

import com.example.examen.GestionLibros.modelos.Reserva;
import com.example.examen.GestionLibros.servicios.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> modificarReserva(@PathVariable Long id, @RequestBody Reserva nuevaReserva) {
        Reserva reservaModificada = reservaService.modificarReserva(id, nuevaReserva);
        if (reservaModificada != null) {
            return new ResponseEntity<>(reservaModificada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Reserva>> obtenerTodasLasReservas() {
        Iterable<Reserva> reservas = reservaService.obtenerTodasLasReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> obtenerReservasPorUsuario(@PathVariable Long usuarioId) {
        return reservaService.obtenerReservasPorUsuario(usuarioId);
    }

    @GetMapping("/evento/{evento}")
    public List<Reserva> obtenerReservasPorEvento(@PathVariable String evento) {
        return reservaService.obtenerReservasPorEvento(evento);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Reserva> obtenerReservasPorFecha(@PathVariable String fecha) {
        return reservaService.obtenerReservasPorFecha(fecha);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
    }
}
