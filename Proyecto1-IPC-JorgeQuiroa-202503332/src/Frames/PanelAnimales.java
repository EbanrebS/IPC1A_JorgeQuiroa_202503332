package Frames;

import javax.swing.*;

public class PanelAnimales extends JPanel {

    // Componentes visuales
    private JLabel lblCodigo, lblNombre, lblEspecie, lblEdad, lblEstadoClinico, lblEstadoAdopcion;
    private JTextField txtCodigo, txtNombre, txtEdad;
    private JComboBox<String> cbEspecie, cbEstadoClinico, cbEstadoAdopcion;
    private JButton btnRegistrar, btnEditar, btnEliminar;
    private JTextArea areaLista;
    private JScrollPane scrollLista;

    public PanelAnimales() {
        // Desactivar el Layout Manager para usar setBounds
        setLayout(null);

        // --- CÓDIGO ---
        lblCodigo = new JLabel("Codigo (A-...):");
        lblCodigo.setBounds(10, 10, 150, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(170, 10, 150, 25);
        add(txtCodigo);

        // --- NOMBRE ---
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 45, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 45, 150, 25);
        add(txtNombre);

        // --- ESPECIE ---
        lblEspecie = new JLabel("Especie:");
        lblEspecie.setBounds(10, 80, 150, 25);
        add(lblEspecie);

        String[] opcionesEspecie = {"Perro", "Gato"};
        cbEspecie = new JComboBox<>(opcionesEspecie);
        cbEspecie.setBounds(170, 80, 150, 25);
        add(cbEspecie);

        // --- EDAD ---
        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(10, 115, 150, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(170, 115, 150, 25);
        add(txtEdad);

        // --- ESTADO CLÍNICO ---
        lblEstadoClinico = new JLabel("Estado clinico:");
        lblEstadoClinico.setBounds(10, 150, 150, 25);
        add(lblEstadoClinico);

        String[] opcionesClinico = {"EN_OBSERVACION", "EN_TRATAMIENTO", "APTO"};
        cbEstadoClinico = new JComboBox<>(opcionesClinico);
        cbEstadoClinico.setBounds(170, 150, 150, 25);
        add(cbEstadoClinico);

        // --- ESTADO ADOPCIÓN ---
        lblEstadoAdopcion = new JLabel("Estado adopcion:");
        lblEstadoAdopcion.setBounds(10, 185, 150, 25);
        add(lblEstadoAdopcion);

        String[] opcionesAdopcion = {"DISPONIBLE", "ADOPTADO", "ELIMINADO"};
        cbEstadoAdopcion = new JComboBox<>(opcionesAdopcion);
        cbEstadoAdopcion.setBounds(170, 185, 150, 25);
        add(cbEstadoAdopcion);

        // --- BOTONES DE ACCIÓN ---
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10, 225, 140, 30);
        add(btnRegistrar);

        btnEditar = new JButton("Editar Estado");
        btnEditar.setBounds(160, 225, 150, 30);
        add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(320, 225, 140, 30);
        add(btnEliminar);

        // --- ÁREA DE TEXTO / LISTADO ---
        areaLista = new JTextArea();
        areaLista.setEditable(false);
        
        scrollLista = new JScrollPane(areaLista);
        scrollLista.setBounds(10, 270, 450, 150);
        add(scrollLista);
    }
}