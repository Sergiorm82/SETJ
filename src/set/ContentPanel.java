package set;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private ResumenPanel resumenPanel = null;
    private CamposPanel camposPanel = null;
    private BotonesAccionPanel botonesAccionPanel = null;

    public ContentPanel() {
        /*this(this);*/
    }

    public ContentPanel(SetjFrame inventarioFrame, String action) {
        if (action == "Inventario") {
            
        } else{
        }
        // Configuración del panel contenedor
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setPreferredSize(new Dimension(1000, 525)); // Tamaño fijo
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(new Color(255, 255, 255)); // Fondo blanco

        // CamposPanel
        camposPanel = new CamposPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Ocupa la mitad del espacio horizontal
        gbc.weighty = 1.0; // Ocupa todo el espacio vertical
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 5); // Espaciado externo (arriba, izquierda, abajo, derecha)    
        add(camposPanel, gbc);

        // ResumenPanel
        resumenPanel = new ResumenPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Ocupa la mitad del espacio horizontal
        gbc.insets = new Insets(5, 5, 5, 10); // Espaciado externo (arriba, izquierda, abajo, derecha
        add(resumenPanel, gbc);

        // BotonesAccionPanel
        botonesAccionPanel = new BotonesAccionPanel(camposPanel);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Ocupa ambas columnas
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // No ocupa espacio vertical
        gbc.insets = new Insets(5, 10, 10, 10); // Espaciado externo (arriba, izquierda, abajo, derecha)   
        add(botonesAccionPanel, gbc);
    }

    public ResumenPanel getResumenPanel() {
        return resumenPanel;
    }
}
