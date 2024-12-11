package set;

import javax.swing.*;
import java.awt.*;

public class BotonesAccionPanel extends RoundedPanel {

    private CamposPanel camposPanel;
    JButton nuevoRegistroButton, buscarCreditosButton, guardarButton, enviarButton, modificarButton, eliminarRegistroButton;

    public BotonesAccionPanel(CamposPanel camposPanel) {
        super(20); // Bordes redondeados
        this.camposPanel = camposPanel;

        setBackground(new Color(220, 220, 220)); // Fondo claro

        setLayout(new GridBagLayout()); // Usar GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre botones
        gbc.fill = GridBagConstraints.BOTH; // Llenar horizontalmente

        nuevoRegistroButton = new JButton("Nuevo registro");
        nuevoRegistroButton.setPreferredSize(new Dimension(120, 40)); // Tamaño preferido
        nuevoRegistroButton.addActionListener(e -> camposPanel.inicializarCampos_Resumen());
        add(nuevoRegistroButton);

        guardarButton = new JButton("Guardar");
        guardarButton.setPreferredSize(new Dimension(120, 40)); // Tamaño preferido       
        guardarButton.addActionListener(e -> camposPanel.guardarRegistroInventario()); // Llama al método guardarRegistro en CamposPanel

        enviarButton = new JButton("Enviar a Validar");
        enviarButton.setPreferredSize(new Dimension(120, 40)); // Tamaño preferido

        eliminarRegistroButton = new JButton("Eliminar");
        eliminarRegistroButton.setSize(50, 50);
        eliminarRegistroButton.setPreferredSize(new Dimension(120, 40)); // Tamaño preferido
        eliminarRegistroButton.addActionListener(e -> camposPanel.eliminarRegistroInventario());

        //Posicionar botones
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nuevoRegistroButton, gbc);
        gbc.gridx = 1;
        add(eliminarRegistroButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(guardarButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(enviarButton, gbc);

    }
}
