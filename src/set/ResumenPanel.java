package set;

import javax.swing.*;
import java.awt.*;

public class ResumenPanel extends RoundedPanel {
JTextArea resumenArea;
    public ResumenPanel() {
        super(20);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Márgenes y bordes redondeados
        setPreferredSize(new Dimension(700, 600)); // Dimensiones predeterminadas
        setMinimumSize(new Dimension(300, 400));
        // Crear el JTextArea
         resumenArea = new JTextArea(10, 20);
        resumenArea.setEditable(true);
        resumenArea.setOpaque(false); // Hacer que el fondo sea transparente
        resumenArea.setLineWrap(true);
        resumenArea.setWrapStyleWord(true);

        // Crear un JScrollPane
        JScrollPane scrollPane = new JScrollPane(resumenArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 255, 255), 2), // Borde exterior redondeado
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Espaciado interior
        ));

        // Agregar el JScrollPane al panel
        add(scrollPane, BorderLayout.CENTER);
        
    }
    
     public void mostrarResumen(String resumen) {
        resumenArea.setText(resumen);
    }
     
      public void bloquearResumen() {
        resumenArea.setEnabled(false);
    }
      
      public void activarResumen() {
        resumenArea.setEnabled(true);
    }
      
      public void linpiarResumen() {
        resumenArea.setText("");
    }
}
/*package set;

import javax.swing.*;
import java.awt.*;

public class ResumenPanel extends RoundedPanel {

    public ResumenPanel() {
        super(20); // Bordes redondeados
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Márgenes y bordes redondeados
        
        // Ejemplo de resumen
        JTextArea resumenArea = new JTextArea(10, 20);
        resumenArea.setEditable(true);
        resumenArea.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(new JScrollPane(resumenArea));
    }
}
*/
