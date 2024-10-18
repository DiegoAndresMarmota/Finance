package com.finance.orden_servicio.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenItemRequest {
    private Long id;
    private Double fechaTransaccion;
    private Double fechaDeposito;
    private Double cuentaCargo;
    private Double cuentaAbono;
    private String plazo;
    private String numeroDocumento;
}
