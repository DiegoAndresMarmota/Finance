package com.finance.orden_servicio.model.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequest {
    private List<OrdenItemRequest> orderItems;
}
