import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    biblioteca.agregarLibro(titulo, autor);
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;

                case 3:
                    System.out.print("Título a buscar: ");
                    titulo = sc.nextLine();
                    Libro libro = biblioteca.buscarLibro(titulo);
                    System.out.println(libro != null ? libro : "Libro no encontrado.");
                    break;

                case 4:
                    System.out.print("Título a prestar: ");
                    titulo = sc.nextLine();
                    libro = biblioteca.buscarLibro(titulo);
                    if (libro != null && libro.isDisponible()) {
                        libro.prestar();
                        System.out.println("Libro prestado.");
                    } else {
                        System.out.println("No disponible.");
                    }
                    break;

                case 5:
                    System.out.print("Título a devolver: ");
                    titulo = sc.nextLine();
                    libro = biblioteca.buscarLibro(titulo);
                    if (libro != null && !libro.isDisponible()) {
                        libro.devolver();
                        System.out.println("Libro devuelto.");
                    } else {
                        System.out.println("No se puede devolver.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }
}
