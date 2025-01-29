package com.example.examen.GestionLibros.repositorios;

import com.example.examen.GestionLibros.modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {


    List<Reserva> findByUsuarioId(Long usuarioId);

    List<Reserva> findByEvento(String evento);

    List<Reserva> findByFecha(String fecha);
}
