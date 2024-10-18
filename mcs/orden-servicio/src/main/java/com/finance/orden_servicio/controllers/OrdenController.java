package com.finance.orden_servicio.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.finance.orden_servicio.model.dtos.OrdenRequest;
import com.finance.orden_servicio.model.dtos.OrderItemsResponse;
import com.finance.orden_servicio.services.OrdenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orden")
@RequiredArgsConstructor
public class OrdenController {

    private final OrdenService ordenService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrden(@RequestBody OrdenRequest ordenRequest) {
        this.ordenService.placeOrden(ordenRequest);
        return "La orden de compra se ha creado exitosamente.";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemsResponse> getOrdenes() {
        return this.ordenService.getAllOrdenes();
    }
}
