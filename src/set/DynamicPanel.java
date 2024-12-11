package set;

import javax.swing.*;
import java.awt.*;

public class DynamicPanel extends RoundedPanel {

    private JLabel tareaLabel;

    public DynamicPanel(String tareaInicial) {
        super(20);
        // Configuración del panel
        setLayout(new BorderLayout());
        setBackground(new Color(205, 205, 205)); // Color suave acorde a FlatLaf
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Márgenes y bordes redondeados
        // Panel de texto alineado a la derecha
        JPanel textPanel = new JPanel(new GridLayout(3, 1));
        textPanel.setOpaque(false); // Sin color de fondo (hereda del contenedor)

        // Líneas del encabezado
        JLabel titulo1 = new JLabel("Servicio Estatal Tributario de Jalisco");
        titulo1.setFont(new Font("SansSerif", Font.BOLD, 18)); // Negritas y grande
        titulo1.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel titulo2 = new JLabel("Dirección General de Orientación y Servicios");
        titulo2.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Sin negritas y grande
        titulo2.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel titulo3 = new JLabel("Dirección de Notificación y Ejecución Fiscal");
        titulo3.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Igual al anterior
        titulo3.setHorizontalAlignment(SwingConstants.RIGHT);

        // Agregar etiquetas al panel de texto
        textPanel.add(titulo1);
        textPanel.add(titulo2);
        textPanel.add(titulo3);

        // Agregar al panel principal
        add(textPanel, BorderLayout.CENTER);

        // Etiqueta para la tarea dinámica
        tareaLabel = new JLabel(tareaInicial);
        tareaLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        tareaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        tareaLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        add(tareaLabel, BorderLayout.SOUTH);
    }

    // Método para actualizar la tarea
    public void actualizarTarea(String nuevaTarea) {
        tareaLabel.setText(nuevaTarea);
    }

}
