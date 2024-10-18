package com.finance.orden_servicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.orden_servicio.model.entities.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
