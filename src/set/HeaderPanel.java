package set;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(String fechaCaptura, String tareaInicial) {
        // Configuración del panel contenedor
        setLayout(new BorderLayout(5,0));
        setPreferredSize(new Dimension(1000, 125)); // Tamaño fijo (ancho se adapta, altura fija)
        // Agregar un margen de 20 píxeles alrededor del HeaderPanel
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(new Color(255, 255, 255)); // fondo transparente
        // Panel fijo (logotipo y fecha)
        FixedPanel fixedPanel = new FixedPanel(fechaCaptura);
        add(fixedPanel, BorderLayout.WEST); // Alineado a la izquierda

        // Panel dinámico (encabezado y tarea)
        DynamicPanel dynamicPanel = new DynamicPanel(tareaInicial);
        add(dynamicPanel, BorderLayout.CENTER); // Ocupa el espacio restante
    }
}
