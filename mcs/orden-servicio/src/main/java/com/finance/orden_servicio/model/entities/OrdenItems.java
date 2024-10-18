package com.finance.orden_servicio.model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrdenItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double fechaTransaccion;
    private Double fechaDeposito;
    private Double cuentaCargo;
    private Double cuentaAbono;
    private String plazo;
    private String numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}
