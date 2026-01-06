import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static byte[] hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    public static void main(String[] args) {

        byte[] adminHash = hashPassword("1234");
        Usuario admin = new Usuario("admin", adminHash);

        Console console = System.console();
        String usuarioInput;
        String passwordInput;

        if (console != null) {
            usuarioInput = console.readLine("Ingrese usuario: ");
            char[] pwd = console.readPassword("Ingrese contraseña: ");
            passwordInput = new String(pwd);
            java.util.Arrays.fill(pwd, ' ');
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese usuario: ");
            usuarioInput = scanner.nextLine();
            System.out.print("Ingrese contraseña: ");
            passwordInput = scanner.nextLine();
        }

        byte[] inputHash = hashPassword(passwordInput);
        boolean loginOk = admin.iniciarSesion(usuarioInput, inputHash);

        if (!loginOk) return;

        Curso[] cursos = new Curso[2];
        cursos[0] = new CursoProgramacion("Java Básico", 40, "Java");
        cursos[1] = new CursoDiseno("Desarrollo java", 30, "Visual Code");

        for (Curso c : cursos) {
            c.mostrarInfo();
        }

        cursos[0].extenderDuracion();
        cursos[1].extenderDuracion(10);

        Reporte reporte = new Reporte(LocalDate.now(), "Finalizado");
        System.out.println(reporte.generarReporte(cursos[0]));

        for (Curso c : cursos) {
            if (c instanceof Certificable) {
                ((Certificable) c).emitirCertificado();
            }
        }

        if (cursos[0] instanceof CursoProgramacion) {
            ((CursoProgramacion) cursos[0]).compilarCodigo();
        }
        if (cursos[1] instanceof CursoDiseno) {
            ((CursoDiseno) cursos[1]).exportarProyecto();
        }
    }
}