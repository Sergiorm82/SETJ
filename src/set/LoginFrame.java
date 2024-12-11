package set;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        FlatLightLaf.setup();
        setTitle("SETJ - Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setFavicon("src/resources/favicon.png");
        // Crear panel principal
        RoundedPanel mainPanel = new RoundedPanel(30);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        mainPanel.setBackground(new Color(245, 245, 245));
        add(mainPanel);

        // Agregar logotipo
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/resources/SETJ_LOGO_LOGIN.png"));
        Image scaledImage = logoIcon.getImage().getScaledInstance(350, 120, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(scaledImage));
        logoLabel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Campo Código de Usuario
        JTextField codigoUsuarioField = new JTextField();
        codigoUsuarioField.setPreferredSize(new Dimension(400, 50));
        codigoUsuarioField.setMaximumSize(new Dimension(400, 50));
        codigoUsuarioField.setFont(new Font("Arial", Font.PLAIN, 16));
        codigoUsuarioField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2), "Código de Usuario", 0, 0, new Font("Arial", Font.BOLD, 14)));
        mainPanel.add(codigoUsuarioField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Campo Contraseña
        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setPreferredSize(new Dimension(400, 50));
        contrasenaField.setMaximumSize(new Dimension(400, 50));
        contrasenaField.setFont(new Font("Arial", Font.PLAIN, 16));
        contrasenaField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2), "Contraseña", 0, 0, new Font("Arial", Font.BOLD, 14)));
        mainPanel.add(contrasenaField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        // Botón de Login
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(51, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(CENTER_ALIGNMENT);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> autenticarUsuario(codigoUsuarioField.getText(), new String(contrasenaField.getPassword())));
        mainPanel.add(loginButton);
        // Acción del botón Iniciar Sesión

        contrasenaField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "loginAction");
        contrasenaField.getActionMap().put("loginAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick(); // Ejecuta la acción del botón
            }
        });

        setVisible(true);
    }

    private void autenticarUsuario(String codigoUsuario, String contrasena) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Modificación de la consulta SQL
            String query = "SELECT U.UsuarioID, U.CodigoUsuario, U.NombreUsuario,U.TipoUsuario, U.Nivel,U.Email, U.Contraseña, "
                    + "U.FechaCreacion, U.UltimoLogin, U.Estado, U.Telefono, U.IdRol, U.IdArea,U.Cargo, R.NombreRol, R.Permisos "
                    + "FROM Usuarios U "
                    + "INNER JOIN Roles R ON U.IdRol = R.IdRol "
                    + "WHERE U.CodigoUsuario = ? AND U.Contraseña = ?";
               
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, codigoUsuario);
            statement.setString(2, contrasena);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SessionManager session = SessionManager.getInstance();
                session.setUsuarioID(resultSet.getInt("UsuarioID"));
                session.setCodigoUsuario(resultSet.getString("CodigoUsuario"));
                session.setNombreUsuario(resultSet.getString("NombreUsuario"));
                session.setTipoUsuario(resultSet.getString("TipoUsuario"));
                session.setNivel(resultSet.getInt("Nivel"));
                session.setEmail(resultSet.getString("Email"));
                session.setContraseña(resultSet.getString("Contraseña"));
                session.setFechaCreacion(resultSet.getString("FechaCreacion"));
                session.setUltimoLogin(resultSet.getString("UltimoLogin"));
                session.setEstado(resultSet.getString("Estado"));
                session.setTelefono(resultSet.getString("Telefono"));
                session.setIdRol(resultSet.getInt("IdRol"));
                session.setIdArea(resultSet.getInt("IdArea"));
                session.setCargo(resultSet.getString("Cargo"));
                session.setPermisos(PermisosManager.cargarPermisos(resultSet.getString("Permisos")));

                // Obtener datos del usuario
                String nombreUsuario = resultSet.getString("NombreUsuario");

                String permisosJson = resultSet.getString("Permisos");
                System.out.println("clase LoginFrame permisos = " + permisosJson);//borrar

                // Cargar permisos
                Permisos permisos = PermisosManager.cargarPermisos(permisosJson);

                // Mostrar mensaje de bienvenida con el nombre del usuario
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + nombreUsuario + "!");

                // Iniciar el menú principal con los permisos
                new MainMenu(permisos);
                dispose(); // Cerrar la ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
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
}
