package Frames;
import javax.swing.*;
import java.util.Random;

public class Logueo extends JFrame{
    
    private JLabel etiqueta1;
    private JTextField Text;
    private JTextField Text2;
    private JButton Boton;
    
    public Logueo(){
        //Inicializar la ventana
        super("Refugio de Animales - Control de Acceso");
        setLayout(null);
        setSize(450, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Agregar etiquetas
        etiqueta1 = new JLabel(obtenerFrase(), SwingConstants.LEFT);
        etiqueta1.setBounds(130, 15, 300, 30);
        add(etiqueta1);
        
        //Agregar Bloque de Texto
        Text = new JTextField();
        Text.setBounds(25, 55, 180, 30);
        add(Text);
        
        //Agregar Bloque de Texto
        Text2 = new JTextField();
        Text2.setBounds(235, 55, 180, 30);
        add(Text2);
        
         //Agregar boton
        Boton = new JButton("Verificar");
        Boton.setBounds(125, 100, 200, 30);
        add(Boton);
        
    }
    private String obtenerFrase() {
        String[] frases = new String[5];
        frases[0] = "Bienvenido de nuevo al Refugio";
        frases[1] = "Ingrese sus credenciales";
        frases[2] = "¡Los peluditos te estaban esperando!";
        frases[3] = "Acceso al Sistema del Refugio";
        frases[4] = "Hola de nuevo, ingresa tus datos";
        
        Random rand = new Random();
        int pos = rand.nextInt(5);
        
        return frases[pos];
    }
    
}
