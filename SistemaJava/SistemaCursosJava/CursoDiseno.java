public class CursoDiseno extends Curso implements Certificable {
    private String herramienta;

    public CursoDiseno(String titulo, int duracionHoras, String herramienta) {
        super(titulo, duracionHoras);
        this.herramienta = herramienta;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Curso: " + titulo + " - Duración: " + duracionHoras + " horas - Herramienta: " + herramienta);
    }

    public void exportarProyecto() {
        System.out.println("Exportando proyecto usando " + herramienta + "...");
    }

    @Override
    public void emitirCertificado() {
        System.out.println("Certificado emitido para el curso de diseño: " + titulo);
    }
}