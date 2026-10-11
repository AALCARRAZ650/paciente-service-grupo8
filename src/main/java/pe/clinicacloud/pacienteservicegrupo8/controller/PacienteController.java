package pe.clinicacloud.pacienteservicegrupo8.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.clinicacloud.pacienteservicegrupo8.model.DiagnosticoDTO;
import pe.clinicacloud.pacienteservicegrupo8.model.PacienteHistorialDTO;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    private final List<PacienteHistorialDTO> pacientes = List.of(
            new PacienteHistorialDTO(
                    1L, "12345678", "Juan Pérez", "ESSALUD",
                    List.of(
                            new DiagnosticoDTO(1L, "J10", "Influenza", LocalDateTime.now(), "MODERADO"),
                            new DiagnosticoDTO(2L, "I10", "Hipertensión esencial", LocalDateTime.now(), "LEVE")
                    ),
                    "ACTIVO"
            ),
            new PacienteHistorialDTO(
                    2L, "87654321", "María López", "EPS",
                    List.of(
                            new DiagnosticoDTO(3L, "E11", "Diabetes tipo 2", LocalDateTime.now(), "MODERADO"),
                            new DiagnosticoDTO(4L, "M54", "Dolor lumbar", LocalDateTime.now(), "LEVE"),
                            new DiagnosticoDTO(5L, "N39", "Infección urinaria", LocalDateTime.now(), "MODERADO")
                    ),
                    "ACTIVO"
            ),
            new PacienteHistorialDTO(
                    3L, "45678912", "Carlos Ramírez", "PARTICULAR",
                    List.of(
                            new DiagnosticoDTO(6L, "C34", "Cáncer de pulmón", LocalDateTime.now(), "SEVERO"),
                            new DiagnosticoDTO(7L, "F32", "Depresión mayor", LocalDateTime.now(), "SEVERO")
                    ),
                    "ACTIVO"
            ),
            new PacienteHistorialDTO(
                    4L, "78912345", "Ana Torres", "ESSALUD",
                    List.of(
                            new DiagnosticoDTO(8L, "A00", "Cólera", LocalDateTime.now(), "LEVE"),
                            new DiagnosticoDTO(9L, "B20", "VIH", LocalDateTime.now(), "SEVERO"),
                            new DiagnosticoDTO(10L, "K35", "Apendicitis aguda", LocalDateTime.now(), "SEVERO")
                    ),
                    "ACTIVO"
            )
    );

    @GetMapping("/{pacienteId}")
    public ResponseEntity<PacienteHistorialDTO> obtenerHistorial(@PathVariable Long pacienteId) {
        return pacientes.stream()
                .filter(p -> p.getPacienteId().equals(pacienteId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{pacienteId}/diagnosticos")
    public ResponseEntity<List<DiagnosticoDTO>> obtenerDiagnosticos(@PathVariable Long pacienteId) {
        return pacientes.stream()
                .filter(p -> p.getPacienteId().equals(pacienteId))
                .findFirst()
                .map(p -> ResponseEntity.ok(p.getListaDiagnosticosActivos()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PacienteHistorialDTO>> listarPacientes() {
        return ResponseEntity.ok(pacientes);
    }
}
