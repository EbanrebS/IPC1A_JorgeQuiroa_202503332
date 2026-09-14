
package Frames;
import javax.swing.*;

public class Principal extends JFrame {
    private JLabel etiqueta1;
    private JTextField Text;
    private JTextField Text2;
    private JButton Boton;
    
    public Principal(){
        //Inicializar la ventana
        super("Centro de Rescate Animal");
        setLayout(null);
        setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    
}
