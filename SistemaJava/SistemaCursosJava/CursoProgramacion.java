public class CursoProgramacion extends Curso implements Certificable {
    private String lenguaje;

    public CursoProgramacion(String titulo, int duracionHoras, String lenguaje) {
        super(titulo, duracionHoras);
        this.lenguaje = lenguaje;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Curso: " + titulo + " - Duración: " + duracionHoras + " horas - Lenguaje: " + lenguaje);
    }

    public void compilarCodigo() {
        System.out.println("Compilando código en " + lenguaje + "...");
    }

    @Override
    public void emitirCertificado() {
        System.out.println("Certificado emitido para el curso de programación: " + titulo);
    }
}