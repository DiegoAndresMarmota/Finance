import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DapRequest {

    private Long serie;
    private String cliente;
    private String moneda;
    private Double tipo;
    private String plazo;
    private Double tasaPeriodo;
    private Double montoInicial;
    private Double fechaVencimiento;
    private Boolean estado;
    private Double montoFinal;
    private Double fechaInicial;

}