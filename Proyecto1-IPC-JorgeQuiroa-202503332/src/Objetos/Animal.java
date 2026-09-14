package Objetos;

public class Animal {

    private String codigo;
    private String nombre;
    private String especie;
    private int edad;
    private String estadoClinico;
    private String estadoAdopcion;

    public Animal(String codigo, String nombre, String especie, int edad, String estadoClinico, String estadoAdopcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.estadoClinico = estadoClinico;
        this.estadoAdopcion = estadoAdopcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstadoClinico() {
        return estadoClinico;
    }

    public String getEstadoAdopcion() {
        return estadoAdopcion;
    }

    public void setEstadoClinico(String estadoClinico) {
        this.estadoClinico = estadoClinico;
    }

    public void setEstadoAdopcion(String estadoAdopcion) {
        this.estadoAdopcion = estadoAdopcion;
    }

}