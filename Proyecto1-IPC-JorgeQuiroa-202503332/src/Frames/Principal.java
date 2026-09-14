package Frames;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Font;

public class Principal extends JFrame {

    private boolean esAdmin;
    private CardLayout layout;
    private JPanel panelContenedor;
    private JLabel titulo;

    public Principal(boolean esAdmin) {
        this.esAdmin = esAdmin;

        //Inicializar la ventana
        super.setTitle("Centro de Rescate Animal");
        setLayout(null);
        setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Panel lateral izquierdo (fijo, siempre visible)
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(null);
        panelLateral.setBounds(0, 0, 220, 600);
        panelLateral.setBackground(new java.awt.Color(230, 230, 230));
        add(panelLateral);

        JButton btnAnimales = new JButton("Animales");
        btnAnimales.setBounds(15, 30, 190, 40);
        panelLateral.add(btnAnimales);

        JButton btnAdoptantes = new JButton("Adoptantes");
        btnAdoptantes.setBounds(15, 80, 190, 40);
        panelLateral.add(btnAdoptantes);

        JButton btnUbicaciones = new JButton("Ubicaciones");
        btnUbicaciones.setBounds(15, 130, 190, 40);
        panelLateral.add(btnUbicaciones);

        JButton btnSolicitudes = new JButton("Solicitudes");
        btnSolicitudes.setBounds(15, 180, 190, 40);
        panelLateral.add(btnSolicitudes);

        JButton btnRescates = new JButton("Rescates");
        btnRescates.setBounds(15, 230, 190, 40);
        panelLateral.add(btnRescates);

        JButton btnReportes = new JButton("Reportes");
        btnReportes.setBounds(15, 280, 190, 40);
        panelLateral.add(btnReportes);

        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBounds(15, 490, 190, 40);
        panelLateral.add(btnCerrarSesion);

        //Titulo superior (cambia segun el modulo activo)
        titulo = new JLabel("Menu");
        titulo.setBounds(240, 15, 600, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(titulo);

        //Contenedor de modulos (CardLayout)
        layout = new CardLayout();
        panelContenedor = new JPanel(layout);
        panelContenedor.setBounds(220, 60, 680, 540);
        add(panelContenedor);
        
        JPanel panelInicio = new JPanel();
        panelContenedor.add(panelInicio, "INICIO");
        PanelAnimales panelAnimales = new PanelAnimales();
        panelContenedor.add(panelAnimales, "ANIMALES");
        layout.show(panelContenedor, "INICIO");
        btnAnimales.addActionListener(e -> {
            titulo.setText("Gestión de Animales");
            layout.show(panelContenedor, "ANIMALES");
        });
    }

}