package Objetos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntradaBitacora {
    private String fecha;
    private String usuario;
    private String modulo;
    private String evento;
    private String descripcion;

    // Constructor para inicializar todos los campos de un solo golpe
    public EntradaBitacora(String usuario, String modulo, String evento, String descripcion) {
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.usuario = usuario;
        this.modulo = modulo;
        this.evento = evento;
        this.descripcion = descripcion;
    }

    // Getters para poder leer la información después
    public String getFecha() {
        return fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getModulo() {
        return modulo;
    }

    public String getEvento() {
        return evento;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
