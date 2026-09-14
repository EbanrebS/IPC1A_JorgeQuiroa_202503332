
package Frames;
import javax.swing.*;
import java.awt.CardLayout;

public class Principal extends JFrame {
    private boolean esAdmin;
    private CardLayout layout;
    private JPanel panelContenedor;
    
    public Principal(boolean esAdmin){
        //esta chiva solo es para diferenciar el usuario
        this.esAdmin = esAdmin;
        
        //Inicializar la ventana
        super("Centro de Rescate Animal");
        setLayout(null);
        setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Crear el contender de las ventanas de separacion
        layout = new CardLayout();
        panelContenedor = new JPanel(layout);
        panelContenedor.setBounds(0, 0, 900, 600);
        add(panelContenedor);
        
    }  
    
}
