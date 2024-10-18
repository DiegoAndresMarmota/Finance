package com.finance.orden_servicio.services;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.finance.orden_servicio.model.dtos.BaseResponse;
import com.finance.orden_servicio.model.dtos.OrdenItemRequest;
import com.finance.orden_servicio.model.dtos.OrdenRequest;
import com.finance.orden_servicio.model.dtos.OrderItemsResponse;
import com.finance.orden_servicio.model.dtos.OrderResponse;
import com.finance.orden_servicio.model.entities.Orden;
import com.finance.orden_servicio.model.entities.OrdenItems;
import com.finance.orden_servicio.repositories.OrdenRepository;

import lombok.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrden(OrdenRequest ordenRequest) {
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/api/cartera/{id}")
                .bodyValue(ordenRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();
        if (result != null && !result.hasErrors()) {
            Orden orden = new Orden();
            orden.setOrdenNumber(UUID.randomUUID().toString());
            orden.setOrdenItems(ordenRequest.getOrderItems().stream()
                    .map(orderItemRequest -> mapOrdenItemRequestToOrdenItem(ordenItemRequest, orden))
                    .toList());
            this.ordenRepository.save(orden);
        } else {
            throw new IllegalArgumentException("Inversión no encontrada");
        }
    }

    public List<OrdenResponse> getAllOrdenes() {
        List<Orden> ordenes = this.ordenRepository.findAll();
        return ordenes.stream().map(this::mapToOrdenResponse).toList();

    }

    private OrdenResponse mapToOrdenResponse(Orden orden) {
        return new OrdenResponse(orden.getId(), orden.getOrderNumber(),
                orden.getOrdenItems().stream().map(this::mapToOrdenItemRequest).toList());
    }

    private OrdenItemsResponse mapToOrdenItemRequest(OrdenItems ordenItems) {
        return new OrdenItemsResponse(
            ordenItems.getId(), 
            ordenItems.fechaTransaccion(), 
            ordenItems.getFechaDeposito(),
            ordenItems.getCuentaCargo(), 
            ordenItems.getCuentaAbono(), 
            ordenItems.getPlazo(), 
            ordenItems.getNumeroDocumento()
            )
    }

    private OrdenItems mapOrdenItemRequestToOrdenItem(OrdenItemRequest ordenItemRequest, Orden orden) {
        return OrdenItems.builder()
                .id(ordenItemRequest.getId())
                .fechaTransaccion(ordenItemRequest.getFechaTransaccion())
                .fechaDeposito(ordenItemRequest.getFechaDeposito())
                .cuentaCargo(ordenItemRequest.getCuentaCargo())
                .cuentaAbono(ordenItemRequest.getCuentaAbono())
                .plazo(ordenItemRequest.getPlazo())
                .numeroDocumento(ordenItemRequest.getNumeroDocumento())
                .build();
    }
}