package ProgramacionBase;

public class Autenticacion {

    private static int intentosFallidos = 0;

    public static String validarLogin(String usuario, String contrasena) {

        if (intentosFallidos >= 3) {
            return "BLOQUEADO";
        }

        if (usuario.equals("admin1") && contrasena.equals("Refugio2026")) {
            intentosFallidos = 0;
            Bitacora.logExitoso(usuario, "AUTENTICACION", "LOGIN_OK", "Inicio de sesion correcto");
            return "OK_ADMIN";
        }

        if (usuario.equals("auxiliar1") && contrasena.equals("Refugio2026")) {
            intentosFallidos = 0;
            Bitacora.logExitoso(usuario, "AUTENTICACION", "LOGIN_OK", "Inicio de sesion correcto");
            return "OK_AUXILIAR";
        }

        intentosFallidos++;
        Bitacora.logFallido(usuario, "AUTENTICACION", "LOGIN_FALLIDO", "Usuario o contraseña incorrectos (intento " + intentosFallidos + " de 3)");

        if (intentosFallidos >= 3) {
            return "BLOQUEADO";
        }

        return "FALLO";
    }

}