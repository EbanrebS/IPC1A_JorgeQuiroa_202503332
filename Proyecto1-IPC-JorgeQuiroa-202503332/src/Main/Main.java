package Main;

import Frames.Logueo;
import ProgramacionBase.Bitacora;

public class Main {

    public static void main(String[] args) {
       Logueo ventana = new Logueo();
       ventana.setVisible(true);
       Bitacora.logFallido("admin1", "TEST", "PRUEBA", "esto es una prueba");    
    }
    
}
