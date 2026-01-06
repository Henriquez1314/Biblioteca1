import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
