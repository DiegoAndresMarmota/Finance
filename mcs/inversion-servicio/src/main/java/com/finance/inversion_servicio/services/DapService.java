import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DapService {

    private final DapReposity DapReposity;

    public void agregarDap(DapRequest dapRequest) {
        var dap = Dap.builder()
                .serie(dapRequest.getSerie())
                .cliente(dapRequest.getCliente())
                .moneda(dapRequest.getMoneda())
                .tipo(dapRequest.getTipo())
                .plazo(dapRequest.getPlazo())
                .tasaPeriodo(dapRequest.getTasaPeriodo())
                .montoInicial(dapRequest.getMontoInicial())
                .fechaVencimiento(dapRequest.getFechaVencimiento())
                .estado(dapRequest.getEstado())
                .montoFinal(dapRequest.getMontoFinal())
                .fechaInicial(dapRequest.getFechaInicial())
                .build();

        DapReposity.save(dap);
        DapReposity.save(dap.serie);

        log.info("El Deposito a plazo ha sido generado: {}", dap.serie);
    }

    public List<DapResponse> getAllDaps() {
        var daps = DapReposity.findAll();
        return daps.stream().map(this::mapToDapResponse).toList();
    }

    private DapResponse mapToDapResponse(Dap dap) {
        return dapResponse.builder()
                .id(dap.getId())
                .serie(dap.getSerie())
                .cliente(dap.getCliente())
                .moneda(dap.getMoneda())
                .tipo(dap.getTipo())
                .plazo(dap.getPlazo())
                .tasaPeriodo(dap.getTasaPeriodo())
                .montoInicial(dap.getMontoInicial())
                .fechaVencimiento(dap.getFechaVencimiento())
                .estado(dap.getEstado())
                .montoFinal(dap.getMontoFinal())
                .fechaInicial(dap.getFechaInicial())
                .build();
    }

}
