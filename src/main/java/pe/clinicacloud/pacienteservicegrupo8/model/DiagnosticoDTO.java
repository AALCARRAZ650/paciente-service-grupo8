package pe.clinicacloud.pacienteservicegrupo8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoDTO {
    private Long idDiagnostico;
    private String codigoCIE10;
    private String descripcion;
    private LocalDateTime fechaDiagnostico;
    private String gravedad;

}
