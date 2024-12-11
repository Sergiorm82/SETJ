package set;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

public class FixedPanel extends RoundedPanel {

    public FixedPanel(String fechaCaptura) {
        super(20);
        FlatLightLaf.setup();
        // Configuración del panel
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350, 110));
        setBackground(new Color(205, 205, 205)); // Color claro acorde a FlatLaf

        // Logotipo
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/resources/SETJ_LOGO_FRAME.png")); // Ruta relativa al logotipo
        Image scaledLogo = logoIcon.getImage().getScaledInstance(320, 90, Image.SCALE_SMOOTH); // Ajustar tamaño del logotipo
        logoLabel.setIcon(new ImageIcon(scaledLogo));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar horizontalmente
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);   // Centrar verticalmente
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes internos
        add(logoLabel, BorderLayout.CENTER);

        // Fecha de captura
        JLabel fechaLabel = new JLabel("Fecha de trabajo - " + fechaCaptura);
        fechaLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); // Fuente moderna
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(fechaLabel, BorderLayout.SOUTH);
    }
}
