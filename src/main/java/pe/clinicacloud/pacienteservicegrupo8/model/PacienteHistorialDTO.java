package pe.clinicacloud.pacienteservicegrupo8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteHistorialDTO {
    private Long pacienteId;
    private String numeroDocumento;
    private String nombreCompleto;
    private String tipoSeguro;
    private List<DiagnosticoDTO> listaDiagnosticosActivos;
    private String estadoPaciente;
}
