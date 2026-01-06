public class Curso {
    protected String titulo;
    protected int duracionHoras;

    public Curso(String titulo, int duracionHoras) {
        this.titulo = titulo;
        this.duracionHoras = duracionHoras;
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + titulo + " - Duración: " + duracionHoras + " horas");
    }

    public void iniciarCurso() {
        System.out.println("Curso iniciado");
    }

    public void finalizarCurso() {
        System.out.println("Curso finalizado");
    }

    public void extenderDuracion() {
        System.out.println("Duración extendida");
    }

    public void extenderDuracion(int horas) {
        this.duracionHoras += horas;
        System.out.println("Duración extendida en " + horas + " horas");
    }
}