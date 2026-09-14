package ProgramacionBase;

import Frames.Logueo;
import Frames.Principal;

public class Autenticacion {
    
    private static int intentosFallidos = 0;
    

    public static String validarLogin(String usuario, String contrasena) {
        
       

        if (usuario == null || usuario.trim().isEmpty() || contrasena == null || contrasena.trim().isEmpty()) {
            Bitacora.logFallido(usuario, "AUTENTICACION", "VALIDACION", "Usuario o contraseña vacíos");
            return "CAMPOS_VACIOS";
        }

        if (usuario.length() < 4 || usuario.length() > 15) {
            Bitacora.logFallido(usuario, "AUTENTICACION", "VALIDACION", "Usuario fuera de longitud permitida (4-15 caracteres)");
            return "FORMATO_INVALIDO";
        }

        if (contrasena.length() < 6) {
            Bitacora.logFallido(usuario, "AUTENTICACION", "VALIDACION", "Contraseña con menos de 6 caracteres");
            return "FORMATO_INVALIDO";
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