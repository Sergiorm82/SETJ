package set;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int cornerRadius; // Radio de las esquinas

    public RoundedPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false); // Permitir el dibujo personalizado sin superposición del fondo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Habilitar antialiasing para bordes suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Configurar color de fondo
        g2.setColor(getBackground());

        // Dibujar el rectángulo con esquinas redondeadas
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.dispose();
    }
}
