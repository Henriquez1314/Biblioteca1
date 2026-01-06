public class Usuario {
    private String nombreUsuario;
    private byte[] passwordHash;

    public Usuario(String nombreUsuario, byte[] passwordHash) {
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean iniciarSesion(String usuario, byte[] claveHash) {
        if (this.nombreUsuario.equals(usuario)) {
            if (this.passwordHash.length != claveHash.length) return false;

            for (int i = 0; i < this.passwordHash.length; i++) {
                if (this.passwordHash[i] != claveHash[i]) return false;
            }

            System.out.println("Bienvenido al sistema de cursos");
            return true;
        } else {
            System.out.println("Credenciales incorrectas");
            return false;
        }
    }
}