import java.time.LocalDate;

public class Reporte {
    private LocalDate fecha;
    private String estadoCurso;

    public Reporte(LocalDate fecha, String estadoCurso) {
        this.fecha = fecha;
        this.estadoCurso = estadoCurso;
    }

    public String generarReporte(Curso curso) {
        return "Reporte: Estado del curso -> " + estadoCurso + " - Fecha: " + fecha.toString();
    }
}