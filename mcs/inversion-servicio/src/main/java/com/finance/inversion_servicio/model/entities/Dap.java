import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "depositos_plazo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public String toString() {
        return "Dap [id=" + id + ", serie=" + serie + ", cliente=" + cliente + ", moneda=" + moneda + ", tipo=" + tipo
                + ", plazo=" + plazo + ", tasaPeriodo=" + tasaPeriodo + ", montoInicial=" + montoInicial
                + ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + ", montoFinal=" + montoFinal
                + ", fechaInicial=" + fechaInicial + "]";
    }
}
