package set;

import javax.swing.JFrame;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author sruiz
 */
public class SetjFrame extends javax.swing.JFrame {

    private ContentPanel contentPanel;
    private CamposPanel camposPanel;
    private BotonesAccionPanel botonesAccionPanel;

    public SetjFrame() {
        this("Inventario");
    }

    public SetjFrame(String action) {

        FlatLightLaf.setup();
        initComponents();
        setLayout(new BorderLayout());
        setTitle("SETJ - " + action);
        setBackground(new Color(255, 255, 255));
        // Maximizar al tamaño completo de la pantalla
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setFavicon("src/resources/favicon.png");

        // Crear el panel superior (HeaderPanel)
        HeaderPanel headerPanel = new HeaderPanel(DateUtil.getFechaActual(), action);
        add(headerPanel, BorderLayout.NORTH);
        // **ContentPanel**: Panel principal debajo del HeaderPanel
        contentPanel = new ContentPanel(this, action);
        add(contentPanel, BorderLayout.CENTER);
        // Panel de contenido (centro)
        contentPanel.setBackground(Color.LIGHT_GRAY);
        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public ContentPanel getContentPanel() {
        return contentPanel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
