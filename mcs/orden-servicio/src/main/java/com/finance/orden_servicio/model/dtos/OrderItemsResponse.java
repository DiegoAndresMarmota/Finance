package com.finance.orden_servicio.model.dtos;

public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {
}