package set;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private ResumenPanel resumenPanel = null;
    private CamposPanel camposPanel = null;
    private BotonesAccionPanel botonesAccionPanel = null;
    private EjecutivosValidacionPanel ejecutivosValidacionPanel = null;
    private ListaCreditosPanel listaCreditosPanel = null;

    public ContentPanel() {
        /*this(this);*/
    }

    public ContentPanel(SetjFrame inventarioFrame, String action) {
        if (action == "Inventario") {
            inventario();
        }
        if (action == "Validación") {
            validacion();
        }
        if (action == "Asignación") {
            asignación();
        }
        if (action == "Afectación") {
            afectación();
        }
        if (action == "Consulta y reporte ejecutivo") {
            consultaReporteEjecutivo();
        }
        if (action == "Consulta y reporte supervisor") {
            consultaReporteSupervisor();
        }

    }

    public void inventario() {
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

    public void validacion() {
        System.out.println("Validacion");
         // Configuración del panel contenedor
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setPreferredSize(new Dimension(1000, 525)); // Tamaño fijo
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(new Color(255, 255, 255)); // Fondo blanco
        // ejecutivosValidacionPanel
        ejecutivosValidacionPanel = new EjecutivosValidacionPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2; // Ocupa la mitad del espacio horizontal
        gbc.weighty = 1.0; // Ocupa todo el espacio vertical
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 5, 5); // Espaciado externo (arriba, izquierda, abajo, derecha)    
        add(ejecutivosValidacionPanel, gbc);

// listaCreditosPanel
        listaCreditosPanel = new ListaCreditosPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6; // Ocupa la mitad del espacio horizontal
        gbc.insets = new Insets(5, 5, 5, 10); // Espaciado externo (arriba, izquierda, abajo, derecha
        add(listaCreditosPanel, gbc);
        
// ResumenPanel
        resumenPanel = new ResumenPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.3; // Ocupa la mitad del espacio horizontal
        gbc.insets = new Insets(5, 5, 5, 10); // Espaciado externo (arriba, izquierda, abajo, derecha
        add(resumenPanel, gbc);

        // BotonesAccionPanel
      /*  botonesAccionPanel = new BotonesAccionPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Ocupa ambas columnas
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // No ocupa espacio vertical
        gbc.insets = new Insets(5, 10, 10, 10); // Espaciado externo (arriba, izquierda, abajo, derecha)   
        add(botonesAccionPanel, gbc);*/
    }

    public void asignación() {System.out.println("asignación");
    }

    public void afectación() {System.out.println("afectación");
    }

    public void consultaReporteEjecutivo() {System.out.println("consultaReporteEjecutivo");
    }

    public void consultaReporteSupervisor() {System.out.println("consultaReporteSupervisor");
    }

    public ResumenPanel getResumenPanel() {
        return resumenPanel;
    }
}
