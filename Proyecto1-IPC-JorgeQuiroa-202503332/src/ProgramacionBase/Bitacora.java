
package ProgramacionBase;
import Objetos.EntradaBitacora;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Bitacora {
    private static EntradaBitacora[] acciones = new EntradaBitacora[1000];
    private static int totalAcciones = 0;

    private static EntradaBitacora[] errores = new EntradaBitacora[1000];
    private static int totalErrores = 0;
    
    public static void logExitoso(String usuario, String modulo, String evento, String descripcion) {
        EntradaBitacora nueva = new EntradaBitacora(usuario, modulo, evento, descripcion);
        acciones[totalAcciones] = nueva;
        totalAcciones++;
        escribirEnArchivo("datos/bitacora_acciones.txt", aLinea(nueva));
    }
    public static void logFallido(String usuario, String modulo, String evento, String descripcion) {
        EntradaBitacora nueva = new EntradaBitacora(usuario, modulo, evento, descripcion);
        errores[totalErrores] = nueva;
        totalErrores++;
        escribirEnArchivo("datos/bitacora_errores.txt", aLinea(nueva));
    }
    private static String aLinea(EntradaBitacora entrada) {
        return entrada.getFecha() + "|" +
               entrada.getUsuario() + "|" +
               entrada.getModulo() + "|" +
               entrada.getEvento() + "|" +
               entrada.getDescripcion();
    }
    private static void escribirEnArchivo(String ruta, String linea) {
    try {
        File archivo = new File(ruta);
        File carpeta = archivo.getParentFile();
        if (carpeta != null) {
            carpeta.mkdirs();
        }
        FileWriter escritor = new FileWriter(ruta, true);
        escritor.write(linea + "\n");
        escritor.close();
    } catch (IOException e) {
        System.out.println("Error al guardar en archivo: " + e.getMessage());
    }
}
}
