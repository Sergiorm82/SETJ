package set;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu(Permisos permisos) {
        System.out.println("" + SessionManager.getInstance().toString());

        //System.out.println("clase MainMenu Permisos permisos = " + permisos);
        FlatLightLaf.setup();
        setTitle("SETJ - Menú Principal");
        setSize(400, 500); // Tamaño del frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // No permitir redimensionar
        setFavicon("src/resources/favicon.png");
        // Crear el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);
        // Agregar el logotipo
        JLabel logoLabel = new JLabel();
        logoLabel.setAlignmentX(CENTER_ALIGNMENT);
        // Ruta al logotipo
        ImageIcon logoIcon = new ImageIcon("src/resources/SETJ_LOGO_LOGIN.png");
        Image scaledImage = logoIcon.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(scaledImage));
        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado

        // Crear botones
        JButton inventarioButton = new JButton("Inventario");
        inventarioButton.setFocusPainted(false);
        inventarioButton.setPreferredSize(new Dimension(300, 40));
        inventarioButton.setMaximumSize(new Dimension(300, 40));
        inventarioButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton validacionButton = new JButton("Validación");
        validacionButton.setFocusPainted(false);
        validacionButton.setPreferredSize(new Dimension(300, 40));
        validacionButton.setMaximumSize(new Dimension(300, 40));
        validacionButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton asignacionButton = new JButton("Asignación");
        asignacionButton.setFocusPainted(false);
        asignacionButton.setPreferredSize(new Dimension(300, 40));
        asignacionButton.setMaximumSize(new Dimension(300, 40));
        asignacionButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton afectacionButton = new JButton("Afectación");
        afectacionButton.setFocusPainted(false);
        afectacionButton.setPreferredSize(new Dimension(300, 40));
        afectacionButton.setMaximumSize(new Dimension(300, 40));
        afectacionButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton consultaEjecutivoButton = new JButton("Consulta y reporte ejecutivo");
        consultaEjecutivoButton.setFocusPainted(false);
        consultaEjecutivoButton.setPreferredSize(new Dimension(300, 40));
        consultaEjecutivoButton.setMaximumSize(new Dimension(300, 40));
        consultaEjecutivoButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton consultaSupervisorButton = new JButton("Consulta y reporte supervisor");
        consultaSupervisorButton.setFocusPainted(false);
        consultaSupervisorButton.setPreferredSize(new Dimension(300, 40));
        consultaSupervisorButton.setMaximumSize(new Dimension(300, 40));
        consultaSupervisorButton.setAlignmentX(CENTER_ALIGNMENT);

        // Habilitar botones según permisos
        inventarioButton.setEnabled(permisos.getBotones().contains("Inventario"));
        validacionButton.setEnabled(permisos.getBotones().contains("Validación"));
        asignacionButton.setEnabled(permisos.getBotones().contains("Asignación"));
        afectacionButton.setEnabled(permisos.getBotones().contains("Afectación"));
        consultaEjecutivoButton.setEnabled(permisos.getBotones().contains("ConsultaUsuario"));
        consultaSupervisorButton.setEnabled(permisos.getBotones().contains("ConsultaSupervisor"));

        // Acciones para los botones
        inventarioButton.addActionListener(e -> abrirFrame("Inventario"));
        validacionButton.addActionListener(e -> abrirFrame("Validación"));
        asignacionButton.addActionListener(e -> abrirFrame("Asignación"));
        afectacionButton.addActionListener(e -> abrirFrame("Afectación"));
        consultaEjecutivoButton.addActionListener(e -> abrirFrame("Consulta y reporte ejecutivo"));
        consultaSupervisorButton.addActionListener(e -> abrirFrame("Consulta y reporte supervisor"));

        // Agregar botones al panel principal
        mainPanel.add(inventarioButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado entre botones
        mainPanel.add(validacionButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado entre botones
        mainPanel.add(asignacionButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(afectacionButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(consultaEjecutivoButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(consultaSupervisorButton);

        // Mostrar la ventana
        setVisible(true);
    }

    private void abrirFrame(String modulo) {
        new SetjFrame(modulo);
        dispose(); // Opcional: Cierra el menú principal si no debe permanecer abierto
    }

    private void setFavicon(String path) {
        try {
            // Cargar la imagen del favicon
            ImageIcon icon = new ImageIcon(path);
            Image image = icon.getImage();
            setIconImage(image); // Asignar la imagen como ícono
        } catch (Exception e) {
            System.err.println("Error al cargar el favicon: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
/*
public static void main(String[] args) {
        // JSON de ejemplo para permisos
        //String permisosJson = "{\"botones\": [\"Validación\", \"Afectación\", \"Consulta y reporte ejecutivo\"]}";
        //Permisos permisos = PermisosManager.cargarPermisos(permisosJson);

        // Iniciar el menú principal con los permisos cargados
       // new MainMenu(permisos);
    }*/
}
