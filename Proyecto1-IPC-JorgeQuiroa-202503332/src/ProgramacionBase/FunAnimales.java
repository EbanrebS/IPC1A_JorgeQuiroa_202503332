package ProgramacionBase;

import Objetos.Animal;

public class FunAnimales {

    private static Animal[] animales = new Animal[500];
    private static int total = 0;

    public static String registrar(String codigo, String nombre, String especie, int edad, String estadoClinico, String estadoAdopcion, String usuario) {

        if (codigo == null || codigo.trim().isEmpty() || !codigo.startsWith("A-")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Codigo invalido o vacio: " + codigo);
            return "CODIGO_INVALIDO";
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Nombre vacio");
            return "NOMBRE_INVALIDO";
        }

        if (!especie.equals("Perro") && !especie.equals("Gato")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Especie \"" + especie + "\" no permitida");
            return "ESPECIE_INVALIDA";
        }

        if (edad < 0 || edad > 25) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Edad fuera de rango: " + edad);
            return "EDAD_INVALIDA";
        }

        if (!estadoClinico.equals("EN_OBSERVACION") && !estadoClinico.equals("EN_TRATAMIENTO") && !estadoClinico.equals("APTO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Estado clinico invalido: " + estadoClinico);
            return "ESTADO_CLINICO_INVALIDO";
        }

        if (!estadoAdopcion.equals("DISPONIBLE") && !estadoAdopcion.equals("ADOPTADO") && !estadoAdopcion.equals("ELIMINADO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Estado adopcion invalido: " + estadoAdopcion);
            return "ESTADO_ADOPCION_INVALIDO";
        }

        if (buscarPorCodigo(codigo) != null) {
            Bitacora.logFallido(usuario, "ANIMALES", "DUPLICADO", "Codigo ya existe: " + codigo);
            return "CODIGO_DUPLICADO";
        }

        Animal nuevo = new Animal(codigo, nombre, especie, edad, estadoClinico, estadoAdopcion);
        animales[total] = nuevo;
        total++;

        Bitacora.logExitoso(usuario, "ANIMALES", "ALTA", "Animal " + codigo + " registrado");
        return "OK";
    }

    public static Animal buscarPorCodigo(String codigo) {
        for (int i = 0; i < total; i++) {
            if (animales[i].getCodigo().equalsIgnoreCase(codigo)) {
                return animales[i];
            }
        }
        return null;
    }

    public static String editarEstado(String codigo, String nuevoEstadoClinico, String nuevoEstadoAdopcion, String usuario) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Codigo no encontrado: " + codigo);
            return "NO_ENCONTRADO";
        }

        if (animal.getEstadoAdopcion().equals("ELIMINADO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "No se puede editar un animal eliminado: " + codigo);
            return "ELIMINADO_NO_EDITABLE";
        }

        if (!nuevoEstadoClinico.equals("EN_OBSERVACION") && !nuevoEstadoClinico.equals("EN_TRATAMIENTO") && !nuevoEstadoClinico.equals("APTO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Estado clinico invalido: " + nuevoEstadoClinico);
            return "ESTADO_CLINICO_INVALIDO";
        }

        if (!nuevoEstadoAdopcion.equals("DISPONIBLE") && !nuevoEstadoAdopcion.equals("ADOPTADO") && !nuevoEstadoAdopcion.equals("ELIMINADO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Estado adopcion invalido: " + nuevoEstadoAdopcion);
            return "ESTADO_ADOPCION_INVALIDO";
        }

        animal.setEstadoClinico(nuevoEstadoClinico);
        animal.setEstadoAdopcion(nuevoEstadoAdopcion);

        Bitacora.logExitoso(usuario, "ANIMALES", "EDITAR", "Animal " + codigo + " actualizado a " + nuevoEstadoClinico + " / " + nuevoEstadoAdopcion);
        return "OK";
    }

    public static String eliminarLogico(String codigo, String usuario) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Codigo no encontrado: " + codigo);
            return "NO_ENCONTRADO";
        }

        if (animal.getEstadoAdopcion().equals("ELIMINADO")) {
            Bitacora.logFallido(usuario, "ANIMALES", "VALIDACION", "Animal ya estaba eliminado: " + codigo);
            return "YA_ELIMINADO";
        }

        animal.setEstadoAdopcion("ELIMINADO");

        Bitacora.logExitoso(usuario, "ANIMALES", "BAJA", "Animal " + codigo + " dado de baja logicamente");
        return "OK";
    }

    public static Animal[] listarActivos() {
        Animal[] activos = new Animal[total];
        int contador = 0;

        for (int i = 0; i < total; i++) {
            if (!animales[i].getEstadoAdopcion().equals("ELIMINADO")) {
                activos[contador] = animales[i];
                contador++;
            }
        }

        Animal[] resultado = new Animal[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = activos[i];
        }

        return resultado;
    }

    public static int getTotal() {
        return total;
    }

}