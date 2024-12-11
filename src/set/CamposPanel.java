package set;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.sql.Timestamp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.List;

public class CamposPanel extends RoundedPanel {

    ResumenPanel resumenPanel;
    SetjFrame parentFrame;// = (SetjFrame) SwingUtilities.getWindowAncestor(this);
    private final JTextField idField, rfcField, numeroCreditoField, nombreField, domicilioField, codigoPostalField, ImporteDeterminadoField, EstatusField, expedienteProcedenciaFeild;
    private final JTextArea observacionesArea;
    private final JComboBox<String> coloniaComboB, municipioComboB, autoridadComboB, tipoNotificacionComboB, tipoCreditoComboB;
    private final CreditosFiscalesDAO creditosFiscalesDAO;
    private final JLabel labelColonia, labelID, titleLabel, labelrfc, labelNumeroCredito, labelNombre, labelDomicilio, labelCodigoPostal, municipioLabel, autoridadLabel, observacionesLabel, tipoCreditoLabel, tipoNotificacionLabel, fechaRecepcionlabel, DocumentoDeterminantelabel, labelImporteDeterminado, labelEstatus, fechaNotificacionlabel, fechaExigiblelabel, fechaEstatuslabel, expedienteProcedenciaLabel;
    private final DatePicker datePickerFechaRecepcion;
    private final DatePicker datePickerDocumentoDeterminante;
    private final DatePicker datePickerfechaNotificacion;
    private final DatePicker datePickerfechaExigible;
    private final DatePicker datePickerfechaEstatus;
    private final JButton buttonBuscarNumeroControl, buttonBuscarRFC, buttonBuscarCredito;
    private final JCheckBox checkBoxCodigoPostal, checkBoxValidacion;
    boolean esNuevo;

    public CamposPanel() {
        super(20); // Bordes redondeados
        FlatLightLaf.setup();
        creditosFiscalesDAO = new CreditosFiscalesDAO();
// Configuración básica del panel
        setPreferredSize(new Dimension(1000, 600)); // Dimensiones predeterminadas
        setMinimumSize(new Dimension(500, 400));
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // Márgenes internos10,20,10,20
        setBackground(Color.WHITE); // Fondo blanco
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para organizar los componentes

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre elementos
        gbc.fill = GridBagConstraints.HORIZONTAL; // Llenar horizontalmente
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        gbc.weightx = .20; // Expandir horizontalmente
        gbc.weighty = 0.1; // Evitar expansión vertical

// Título
        titleLabel = new JLabel("Captura todos los campos requeridos");
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente del título
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(59, 131, 189)); // Color del título
        gbc.gridwidth = 2; // El título ocupa dos columnas
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        checkBoxValidacion = new JCheckBox("Crédito validado");
        checkBoxValidacion.setSelected(false);
        checkBoxValidacion.setEnabled(false);
        gbc.gridx = 2;
        add(checkBoxValidacion, gbc);

        labelID = new JLabel("ID (Número de control)");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelID, gbc);
        idField = new JTextField(20);
        idField.setEditable(false);
        gbc.gridx = 1;
        add(idField, gbc);
        buttonBuscarNumeroControl = new JButton("Buscar No. control");
        buttonBuscarNumeroControl.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 2;
        add(buttonBuscarNumeroControl, gbc);

        labelrfc = new JLabel("RFC");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelrfc, gbc);
        rfcField = new JTextField(20);
        gbc.gridx = 1;
        add(rfcField, gbc);
        buttonBuscarRFC = new JButton("Buscar RFC");
        buttonBuscarRFC.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 2;
        add(buttonBuscarRFC, gbc);

        labelNumeroCredito = new JLabel("Número de crédito");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelNumeroCredito, gbc);
        numeroCreditoField = new JTextField(20);
        gbc.gridx = 1;
        add(numeroCreditoField, gbc);
        buttonBuscarCredito = new JButton("Buscar No. de crédito");
        buttonBuscarCredito.setPreferredSize(new Dimension(50, 50));
        gbc.gridx = 2;
        add(buttonBuscarCredito, gbc);

        labelNombre = new JLabel("Nombre o razón social");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(labelNombre, gbc);
        nombreField = new JTextField(20);
        gbc.gridx = 1;
        add(nombreField, gbc);

        labelDomicilio = new JLabel("Domicilio");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(labelDomicilio, gbc);
        domicilioField = new JTextField(20);
        gbc.gridx = 1;
        add(domicilioField, gbc);

        labelCodigoPostal = new JLabel("Código postal");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(labelCodigoPostal, gbc);
        codigoPostalField = new JTextField(20);
        gbc.gridx = 1;
        add(codigoPostalField, gbc);
        checkBoxCodigoPostal = new JCheckBox("S/CP");
        checkBoxCodigoPostal.setSelected(false);
        gbc.gridx = 2;
        add(checkBoxCodigoPostal, gbc);

// Municipio (Lista desplegable)
        labelColonia = new JLabel("Colonia");
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(labelColonia, gbc);
        coloniaComboB = new JComboBox<>(new String[]{"Seleccione", "Municipio 1", "Municipio 2"});
        gbc.gridx = 1;
        add(coloniaComboB, gbc);

// Restablecer gridwidth
        gbc.gridwidth = 1;
// Municipio (Lista desplegable)
        municipioLabel = new JLabel("Municipio");
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(municipioLabel, gbc);
        municipioComboB = new JComboBox<>(new String[]{"Seleccione", "Municipio 1", "Municipio 2"});
        gbc.gridx = 1;
        add(municipioComboB, gbc);

// Autoridad Determinante (Lista desplegable)
        autoridadLabel = new JLabel("Autoridad Determinante");
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(autoridadLabel, gbc);
        autoridadComboB = new JComboBox<>(new String[]{"Seleccione", "Autoridad 1", "Autoridad 2"});
        gbc.gridx = 1;
        add(autoridadComboB, gbc);
//-------------
// Fecha de Recepción (DatePicker)

        DatePickerSettings dateSettingsFR = new DatePickerSettings();
        dateSettingsFR.setFormatForDatesCommonEra("dd 'de' MMMM 'de' yyyy");

        fechaRecepcionlabel = new JLabel("Fecha de Recepción");
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(fechaRecepcionlabel, gbc);
        datePickerFechaRecepcion = new DatePicker(dateSettingsFR);
        gbc.gridx = 1;
        add(datePickerFechaRecepcion, gbc);
//addDatePickerWithLabel("Fecha de recepción", gbc, 9);
//--------------------
// Expediente de Procedencia
        expedienteProcedenciaLabel = new JLabel("Expediente de procedencia");
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(expedienteProcedenciaLabel, gbc);
        expedienteProcedenciaFeild = new JTextField(20);
        gbc.gridx = 1;
        add(expedienteProcedenciaFeild, gbc);
//addFieldWithLabel("Expediente de procedencia", gbc, 10);
//-------
// Fecha del Documento Determinante (DatePicker)
        DatePickerSettings dateSettingsDD = new DatePickerSettings();
        dateSettingsFR.setFormatForDatesCommonEra("dd 'de' MMMM 'de' yyyy");
        DocumentoDeterminantelabel = new JLabel("Fecha documento Determinante");
        gbc.gridx = 0;
        gbc.gridy = 12;
        add(DocumentoDeterminantelabel, gbc);
        datePickerDocumentoDeterminante = new DatePicker(dateSettingsDD);
        gbc.gridx = 1;
        add(datePickerDocumentoDeterminante, gbc);
//addDatePickerWithLabel("Fecha del documento determinante", gbc, 11);
//------------------------------
// Importe Determinado
        labelImporteDeterminado = new JLabel("Importe determinado");
        gbc.gridx = 0;
        gbc.gridy = 13;
        add(labelImporteDeterminado, gbc);
        ImporteDeterminadoField = new JTextField(20);
        gbc.gridx = 1;
        add(ImporteDeterminadoField, gbc);
//addFieldWithLabel("Importe determinado", gbc, 12);

//----------------
// Fecha de Notificación (DatePicker)
        DatePickerSettings dateSettingsFN = new DatePickerSettings();
        dateSettingsFR.setFormatForDatesCommonEra("dd 'de' MMMM 'de' yyyy");
        fechaNotificacionlabel = new JLabel("Fecha notificación");
        gbc.gridx = 0;
        gbc.gridy = 14;
        add(fechaNotificacionlabel, gbc);
        datePickerfechaNotificacion = new DatePicker(dateSettingsFN);
        gbc.gridx = 1;
        add(datePickerfechaNotificacion, gbc);

// addDatePickerWithLabel("Fecha de notificación", gbc, 13);
//----------------------
// Fecha Exigible del Crédito (DatePicker)
        DatePickerSettings dateSettingsEC = new DatePickerSettings();
        dateSettingsFR.setFormatForDatesCommonEra("dd 'de' MMMM 'de' yyyy");
        fechaExigiblelabel = new JLabel("Fecha Exigible del crédito");
        gbc.gridx = 0;
        gbc.gridy = 15;
        add(fechaExigiblelabel, gbc);
        datePickerfechaExigible = new DatePicker(dateSettingsEC);
        gbc.gridx = 1;
        add(datePickerfechaExigible, gbc);
//addDatePickerWithLabel("Fecha exigible del crédito", gbc, 14);
//------------------------
// Tipo de Notificación (Lista desplegable)
        tipoNotificacionLabel = new JLabel("Tipo de notificación");
        gbc.gridx = 0;
        gbc.gridy = 16;
        add(tipoNotificacionLabel, gbc);
        tipoNotificacionComboB = new JComboBox<>(new String[]{"Seleccione", "Notificación 1", "Notificación 2"});
        gbc.gridx = 1;
        add(tipoNotificacionComboB, gbc);
//-------------
// Tipo de Crédito (Lista desplegable)
        tipoCreditoLabel = new JLabel("Tipo de crédito");
        gbc.gridx = 0;
        gbc.gridy = 17;
        add(tipoCreditoLabel, gbc);
        tipoCreditoComboB = new JComboBox<>(new String[]{"Seleccione", "Estatal", "Federal"});
        gbc.gridx = 1;
        add(tipoCreditoComboB, gbc);
//----------------------------
// Estatus
        labelEstatus = new JLabel("Estatus");
        gbc.gridx = 0;
        gbc.gridy = 18;
        add(labelEstatus, gbc);
        EstatusField = new JTextField(20);
        gbc.gridx = 1;
        add(EstatusField, gbc);
//addFieldWithLabel("Estatus", gbc, 17);
//------------------------------
// Fecha de Estatus (DatePicker)
        DatePickerSettings dateSettingsFE = new DatePickerSettings();
        dateSettingsFR.setFormatForDatesCommonEra("dd 'de' MMMM 'de' yyyy");
        fechaEstatuslabel = new JLabel("Fecha Estatus");
        gbc.gridx = 0;
        gbc.gridy = 19;
        add(fechaEstatuslabel, gbc);
        datePickerfechaEstatus = new DatePicker(dateSettingsFE);
        gbc.gridx = 1;
        add(datePickerfechaEstatus, gbc);

// addDatePickerWithLabel("Fecha de estatus", gbc, 18);
//----------------
// Observaciones (Campo más grande)
        observacionesLabel = new JLabel("Observaciones");
        gbc.gridx = 0;
        gbc.gridy = 20;
        add(observacionesLabel, gbc);

        observacionesArea = new JTextArea(4, 20);
        observacionesArea.setLineWrap(true);
        observacionesArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(observacionesArea);
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 20; // Fila 20
        gbc.gridwidth = 1; // Ocupa una columna
        gbc.gridheight = 2; // Ocupa dos filas
        gbc.weightx = 1.0; // Permite expansión horizontal
        gbc.weighty = 1.0; // Permite expansión vertical
        gbc.fill = GridBagConstraints.BOTH; // Se expande en ambas direcciones
        add(scrollPane, gbc);

// Añadir el KeyListener a
        ImporteDeterminadoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' || (c == '.' && ImporteDeterminadoField.getText().contains("."))) {
                    e.consume(); // Ignorar la entrada no válida
                }
            }
        });

// Añadir el KeyListener al campo código postal
        codigoPostalField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                actualizarMunicipiosPorCodigoPostal();
                actualizarColoniasPorCodigoPostal();
            }
        });
// Limitar el RFC a un máximo de 13 caracteres keyTyped
        rfcField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (rfcField.getText().length() >= 13) {
                    e.consume(); // Ignorar la entrada adicional
                    Toolkit.getDefaultToolkit().beep(); // Emitir un sonido para indicar el límite
                    JOptionPane.showMessageDialog(null, "El RFC no puede tener más de 13 caracteres.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
//addItemListener
        checkBoxCodigoPostal.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    codigoPostalField.setEditable(false);
                    codigoPostalField.setEnabled(false);
                    codigoPostalField.setText("");
                    actualizarColoniasTodas();
                    actualizarMunicipiosPorColonia((String) coloniaComboB.getSelectedItem());
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    System.out.println("no hola");
                    codigoPostalField.setEditable(true);
                    codigoPostalField.setEnabled(true);
                    municipioComboB.removeAllItems();
                    coloniaComboB.removeAllItems();
                    actualizarColoniasPorCodigoPostal();
                }
            }
        });
//addActionListener
        coloniaComboB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) coloniaComboB.getSelectedItem();
                System.out.println("Item seleccionado: " + selectedItem);
                municipioComboB.removeAllItems();
                actualizarMunicipiosPorColonia((String) coloniaComboB.getSelectedItem());
            }
        });

        inicializarCampos(); // Inicializa los campos cuando se abre el panel

        buttonBuscarNumeroControl.addActionListener(e -> abrirBusqueda("Número de control"));
        System.out.println("buttonBuscarNumeroControl.addActionListener(e -> abrirBusqueda(\"Número de control\"));");
        buttonBuscarRFC.addActionListener(e -> abrirBusqueda("RFC"));
        System.out.println("buttonBuscarRFC.addActionListener(e -> abrirBusqueda(\"RFC\"));");
        buttonBuscarCredito.addActionListener(e -> abrirBusqueda("Número de crédito"));
        System.out.println("buttonBuscarCredito.addActionListener(e -> abrirBusqueda(\"Número de crédito\"));");
    }

    private void actualizarMunicipiosPorCodigoPostal() {
        String codigoPostal = codigoPostalField.getText();
        System.out.println("codigoPostal == " + codigoPostal);
        if (codigoPostal.isEmpty()) {
            municipioComboB.removeAllItems();
            return;
        }
        // Consultar los municipios en la base de datos
        List<String> municipios = creditosFiscalesDAO.obtenerMunicipiosPorCodigoPostal(codigoPostal);
        System.out.println("List cp = " + municipios.toString());
        // Actualizar la lista desplegable
        municipioComboB.removeAllItems();
        if (municipios.isEmpty()) {
            municipioComboB.addItem("No se encontraron municipios");
        } else {
            for (String municipio : municipios) {

                municipioComboB.addItem(municipio);
            }
        }
    }

    private void actualizarMunicipiosPorColonia(String colonia) {
        //String colonia = (String) coloniaComboB.getSelectedItem();
        System.out.println("colonia 1" + colonia);
        municipioComboB.removeAllItems();

        // Consultar los municipios en la base de datos
        List<String> municipios = creditosFiscalesDAO.obtenerMunicipiosPorColonia(colonia);
        System.out.println("List cp = " + municipios.toString());
        // Actualizar la lista desplegable
        municipioComboB.removeAllItems();
        if (municipios.isEmpty()) {
            municipioComboB.addItem("No se encontraron municipios");
        } else {
            for (String municipio : municipios) {

                municipioComboB.addItem(municipio);
            }
        }
    }

    private void actualizarColoniasPorCodigoPostal() {
        String codigoPostal = codigoPostalField.getText();
        System.out.println("codigoPostal == " + codigoPostal);
        if (codigoPostal.isEmpty()) {
            municipioComboB.removeAllItems();
            return;
        }
        // Consultar los municipios en la base de datos
        List<String> colonias = creditosFiscalesDAO.obtenerColoniasPorCodigoPostal(codigoPostal);
        System.out.println("List cp = " + colonias.toString());
        // Actualizar la lista desplegable
        coloniaComboB.removeAllItems();
        if (colonias.isEmpty()) {
            coloniaComboB.addItem("No se encontraron colonias");
        } else {
            for (String municipio : colonias) {
                coloniaComboB.addItem(municipio);
            }
            coloniaComboB.addItem("NO ESPECIFICA");
        }
    }

    private void actualizarColoniasTodas() {
        coloniaComboB.removeAllItems();
        // Consultar los municipios en la base de datos
        List<String> colonias = creditosFiscalesDAO.obtenerColoniasTodas();
        System.out.println("List colonias = " + colonias.toString());
        // Actualizar la lista desplegable
        coloniaComboB.removeAllItems();
        if (colonias.isEmpty()) {
            coloniaComboB.addItem("No se encontraron colonias");
        } else {
            for (String colonia : colonias) {
                coloniaComboB.addItem(colonia);
            }
            coloniaComboB.addItem("NO ESPECIFICA");
        }
    }

    private void actualizarMunicipiosTodos() {
        municipioComboB.removeAllItems();
        // Consultar los municipios en la base de datos
        List<String> municipios = creditosFiscalesDAO.obtenerMunicipiosTodos();
        // Actualizar la lista desplegable
        municipioComboB.removeAllItems();
        if (municipios.isEmpty()) {
            municipioComboB.addItem("No se encontraron municipios");
        } else {
            for (String municipio : municipios) {
                municipioComboB.addItem(municipio);
            }
            municipioComboB.addItem("NO ESPECIFICA");
        }
    }

    private void actualizarAutoridades() {
        autoridadComboB.removeAllItems(); // Limpiar items previos
        // Agregar un item por defecto
        autoridadComboB.addItem("Seleccione una autoridad");

        // Obtener los datos desde la base de datos
        List<String> autoridades = creditosFiscalesDAO.obtenerAutoridades();

        // Verificar si hay resultados
        if (autoridades.isEmpty()) {
            autoridadComboB.addItem("No se encontraron autoridades");
        } else {
            for (String autoridad : autoridades) {
                autoridadComboB.addItem(autoridad);
            }
        }
    }

    private void actualizarTiposNotificacion() {
        tipoNotificacionComboB.removeAllItems(); // Limpiar items previos
        // Agregar un item por defecto
        tipoNotificacionComboB.addItem("Seleccione un tipo de notificación");
        // Obtener los datos desde la base de datos
        List<String> tiposNotificacion = creditosFiscalesDAO.obtenerTiposNotificacion();
        // Verificar si hay resultados
        if (tiposNotificacion.isEmpty()) {
            tipoNotificacionComboB.addItem("No se encontraron tipos de notificación");
        } else {
            for (String tipo : tiposNotificacion) {
                tipoNotificacionComboB.addItem(tipo);
            }
        }
    }

    private void actualizarTiposCredito() {
        tipoCreditoComboB.removeAllItems(); // Limpiar items previos
        // Agregar un item por defecto
        tipoCreditoComboB.addItem("Seleccione un tipo de crédito");
        // Obtener los datos desde la base de datos
        List<String> tiposCredito = creditosFiscalesDAO.obtenerTiposCredito();
        // Verificar si hay resultados
        if (tiposCredito.isEmpty()) {
            tipoCreditoComboB.addItem("No se encontraron tipos de crédito");
        } else {
            for (String tipo : tiposCredito) {
                tipoCreditoComboB.addItem(tipo);
            }
        }
    }

    // Método para inicializar los campos
    public void inicializarCampos() {
        idField.setText(String.valueOf(creditosFiscalesDAO.obtenerSiguienteId()));
        rfcField.setText("");
        numeroCreditoField.setText("");
        nombreField.setText("");
        domicilioField.setText("");
        codigoPostalField.setText("");
        coloniaComboB.removeAllItems();
        municipioComboB.removeAllItems();
        datePickerFechaRecepcion.clear();
        datePickerDocumentoDeterminante.clear();
        datePickerfechaNotificacion.clear();
        datePickerfechaEstatus.clear();
        datePickerfechaExigible.clear();
        actualizarAutoridades();
        actualizarTiposNotificacion();
        actualizarTiposCredito();
        EstatusField.setText("");
        ImporteDeterminadoField.setText("");
        expedienteProcedenciaFeild.setText("");
        observacionesArea.setText("");
        checkBoxValidacion.setSelected(false);
        checkBoxValidacion.setEnabled(false);
        checkBoxCodigoPostal.setSelected(false);
        actualizarColoniasTodas();
        actualizarMunicipiosTodos();
        esNuevo = true;
    }

    public void inicializarCampos_Resumen() {
        idField.setText(String.valueOf(creditosFiscalesDAO.obtenerSiguienteId()));
        rfcField.setText("");
        numeroCreditoField.setText("");
        nombreField.setText("");
        domicilioField.setText("");
        codigoPostalField.setText("");
        coloniaComboB.removeAllItems();
        municipioComboB.removeAllItems();
        datePickerFechaRecepcion.clear();
        datePickerDocumentoDeterminante.clear();
        datePickerfechaNotificacion.clear();
        datePickerfechaEstatus.clear();
        datePickerfechaExigible.clear();
        actualizarAutoridades();
        actualizarTiposNotificacion();
        actualizarTiposCredito();
        EstatusField.setText("");
        ImporteDeterminadoField.setText("");
        expedienteProcedenciaFeild.setText("");
        observacionesArea.setText("");
        checkBoxValidacion.setSelected(false);
        checkBoxValidacion.setEnabled(false);
        checkBoxCodigoPostal.setSelected(false);
        actualizarColoniasTodas();
        actualizarMunicipiosTodos();
        activarCampos();
        activarResumen();
        limpiarResumen();
    }

    public void guardarRegistroInventario() {
        if (esNuevo) {
            nuevoCredito();
        } else {
            actualizarCredito();
        }
    }

    public void actualizarCredito() {
           try {            // Crear una instancia de CreditosFiscales con los datos capturados
            CreditosFiscales credito = new CreditosFiscales();
            credito.setNumeroControl(Integer.parseInt(idField.getText()));
            credito.setRfc(rfcField.getText());
            credito.setNumeroCredito(numeroCreditoField.getText());
            credito.setRazonSocial(nombreField.getText());
            credito.setDomicilio(domicilioField.getText());
            credito.setCodigoPostal(codigoPostalField.getText());
            credito.setColonia((String) coloniaComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setMunicipio((String) municipioComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setIdAutoridadDeterminante((String) autoridadComboB.getSelectedItem());
            LocalDate fechaRecepcion = datePickerFechaRecepcion.getDate();
            if (fechaRecepcion != null) {
                java.sql.Date sqlfechaRecepcion = java.sql.Date.valueOf(fechaRecepcion);
                credito.setFechaRecepcion(sqlfechaRecepcion);
            }
            credito.setExpedienteProcedencia(expedienteProcedenciaFeild.getText());
            LocalDate fechaDocumentoDeterminante = datePickerDocumentoDeterminante.getDate();
            if (fechaDocumentoDeterminante != null) {
                java.sql.Date sqlfechaDocumentoDeterminante = java.sql.Date.valueOf(fechaDocumentoDeterminante);
                credito.setFechaDocumentoDeterminante(sqlfechaDocumentoDeterminante);
            }
            credito.setImporteDeterminado(Double.parseDouble(ImporteDeterminadoField.getText()));
            LocalDate fechaNotificacion = datePickerfechaNotificacion.getDate();
            if (fechaNotificacion != null) {
                java.sql.Date sqlfechaNotificacion = java.sql.Date.valueOf(fechaNotificacion);
                credito.setFechaNotificacion(sqlfechaNotificacion);
            }
            LocalDate fechaExigible = datePickerfechaExigible.getDate();
            if (fechaExigible != null) {
                java.sql.Date sqlfechaExigible = java.sql.Date.valueOf(fechaExigible);
                credito.setFechaExigible(sqlfechaExigible);
            }
            credito.setTipoNotificacion((String) tipoNotificacionComboB.getSelectedItem());
            credito.setTipoCredito((String) tipoCreditoComboB.getSelectedItem());
            credito.setEstatus(EstatusField.getText());
            LocalDate fechaEstatus = datePickerfechaExigible.getDate();
            if (fechaEstatus != null) {
                java.sql.Date sqlfechaEstatus = java.sql.Date.valueOf(fechaEstatus);
                credito.setFechaEstatus(sqlfechaEstatus);
            }
            credito.setObservaciones(observacionesArea.getText());
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setImpresion(false);
            credito.setValidacion(false);
            LocalDate fechaCaptura = DateUtil.getFechaActualLocalDate();
            if (fechaCaptura != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaptura);
                credito.setFechaCaptura(sqlfechaCaptura);
            }
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setIdArea(SessionManager.getInstance().getIdArea());
            credito.setIdUsuarioUltModificacion(SessionManager.getInstance().getUsuarioID());
            credito.setGuardado(true);
            LocalDate fechaCaputaModificacion = DateUtil.getFechaActualLocalDate();
            if (fechaCaputaModificacion != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaputaModificacion);
                credito.setFechaUltModificacion(sqlfechaCaptura);
            }
            actualizarResumen(credito);
            creditosFiscalesDAO.actualizarCreditoInventario(credito);;// Actualizar en la base de datos
            esNuevo = false;
            JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);            // Mostrar mensaje de confirmación
            inicializarCampos(); // Limpiar los campos después de guardar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
   
    }

    public void nuevoCredito() {
        try {            // Crear una instancia de CreditosFiscales con los datos capturados
            CreditosFiscales credito = new CreditosFiscales();
            credito.setNumeroControl(Integer.parseInt(idField.getText()));
            credito.setRfc(rfcField.getText());
            credito.setNumeroCredito(numeroCreditoField.getText());
            credito.setRazonSocial(nombreField.getText());
            credito.setDomicilio(domicilioField.getText());
            credito.setCodigoPostal(codigoPostalField.getText());
            credito.setColonia((String) coloniaComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setMunicipio((String) municipioComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setIdAutoridadDeterminante((String) autoridadComboB.getSelectedItem());
            LocalDate fechaRecepcion = datePickerFechaRecepcion.getDate();
            if (fechaRecepcion != null) {
                java.sql.Date sqlfechaRecepcion = java.sql.Date.valueOf(fechaRecepcion);
                credito.setFechaRecepcion(sqlfechaRecepcion);
            }
            credito.setExpedienteProcedencia(expedienteProcedenciaFeild.getText());
            LocalDate fechaDocumentoDeterminante = datePickerDocumentoDeterminante.getDate();
            if (fechaDocumentoDeterminante != null) {
                java.sql.Date sqlfechaDocumentoDeterminante = java.sql.Date.valueOf(fechaDocumentoDeterminante);
                credito.setFechaDocumentoDeterminante(sqlfechaDocumentoDeterminante);
            }
            credito.setImporteDeterminado(Double.parseDouble(ImporteDeterminadoField.getText()));
            LocalDate fechaNotificacion = datePickerfechaNotificacion.getDate();
            if (fechaNotificacion != null) {
                java.sql.Date sqlfechaNotificacion = java.sql.Date.valueOf(fechaNotificacion);
                credito.setFechaNotificacion(sqlfechaNotificacion);
            }
            LocalDate fechaExigible = datePickerfechaExigible.getDate();
            if (fechaExigible != null) {
                java.sql.Date sqlfechaExigible = java.sql.Date.valueOf(fechaExigible);
                credito.setFechaExigible(sqlfechaExigible);
            }
            credito.setTipoNotificacion((String) tipoNotificacionComboB.getSelectedItem());
            credito.setTipoCredito((String) tipoCreditoComboB.getSelectedItem());
            credito.setEstatus(EstatusField.getText());
            LocalDate fechaEstatus = datePickerfechaExigible.getDate();
            if (fechaEstatus != null) {
                java.sql.Date sqlfechaEstatus = java.sql.Date.valueOf(fechaEstatus);
                credito.setFechaEstatus(sqlfechaEstatus);
            }
            credito.setObservaciones(observacionesArea.getText());
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setImpresion(false);
            credito.setValidacion(false);
            LocalDate fechaCaptura = DateUtil.getFechaActualLocalDate();
            if (fechaCaptura != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaptura);
                credito.setFechaCaptura(sqlfechaCaptura);
            }
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setIdArea(SessionManager.getInstance().getIdArea());
            credito.setIdUsuarioUltModificacion(SessionManager.getInstance().getUsuarioID());
            credito.setGuardado(true);
            LocalDate fechaCaputaModificacion = DateUtil.getFechaActualLocalDate();
            if (fechaCaputaModificacion != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaputaModificacion);
                credito.setFechaUltModificacion(sqlfechaCaptura);
            }
            actualizarResumen(credito);
            creditosFiscalesDAO.guardarCreditoInventario(credito);// Guardar en la base de datos
            esNuevo = false;
            JOptionPane.showMessageDialog(this, "Registro guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);            // Mostrar mensaje de confirmación
            inicializarCampos(); // Limpiar los campos después de guardar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void enviarValidacionRegistroInventario() {
        if (!validarCamposLlenos()) {// Validar que todos los campos estén llenos
            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {            // Crear una instancia de CreditosFiscales con los datos capturados
            CreditosFiscales credito = new CreditosFiscales();
            credito.setNumeroControl(Integer.parseInt(idField.getText()));
            credito.setRfc(rfcField.getText());
            credito.setNumeroCredito(numeroCreditoField.getText());
            credito.setRazonSocial(nombreField.getText());
            credito.setDomicilio(domicilioField.getText());
            credito.setCodigoPostal(codigoPostalField.getText());
            credito.setColonia((String) coloniaComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setMunicipio((String) municipioComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setIdAutoridadDeterminante((String) autoridadComboB.getSelectedItem());
            LocalDate fechaRecepcion = datePickerFechaRecepcion.getDate();
            if (fechaRecepcion != null) {
                java.sql.Date sqlfechaRecepcion = java.sql.Date.valueOf(fechaRecepcion);
                credito.setFechaRecepcion(sqlfechaRecepcion);
            }
            credito.setExpedienteProcedencia(expedienteProcedenciaFeild.getText());
            LocalDate fechaDocumentoDeterminante = datePickerDocumentoDeterminante.getDate();
            if (fechaDocumentoDeterminante != null) {
                java.sql.Date sqlfechaDocumentoDeterminante = java.sql.Date.valueOf(fechaDocumentoDeterminante);
                credito.setFechaDocumentoDeterminante(sqlfechaDocumentoDeterminante);
            }
            credito.setImporteDeterminado(Double.parseDouble(ImporteDeterminadoField.getText()));
            LocalDate fechaNotificacion = datePickerfechaNotificacion.getDate();
            if (fechaNotificacion != null) {
                java.sql.Date sqlfechaNotificacion = java.sql.Date.valueOf(fechaNotificacion);
                credito.setFechaNotificacion(sqlfechaNotificacion);
            }
            LocalDate fechaExigible = datePickerfechaExigible.getDate();
            if (fechaExigible != null) {
                java.sql.Date sqlfechaExigible = java.sql.Date.valueOf(fechaExigible);
                credito.setFechaExigible(sqlfechaExigible);
            }
            credito.setTipoNotificacion((String) tipoNotificacionComboB.getSelectedItem());
            credito.setTipoCredito((String) tipoCreditoComboB.getSelectedItem());
            credito.setEstatus(EstatusField.getText());
            LocalDate fechaEstatus = datePickerfechaExigible.getDate();
            if (fechaEstatus != null) {
                java.sql.Date sqlfechaEstatus = java.sql.Date.valueOf(fechaEstatus);
                credito.setFechaEstatus(sqlfechaEstatus);
            }
            credito.setObservaciones(observacionesArea.getText());
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setImpresion(false);
            credito.setValidacion(false);
            LocalDate fechaCaptura = DateUtil.getFechaActualLocalDate();
            if (fechaCaptura != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaptura);
                credito.setFechaCaptura(sqlfechaCaptura);
            }
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setIdArea(SessionManager.getInstance().getIdArea());
            actualizarResumen(credito);
            creditosFiscalesDAO.guardarCreditoInventario(credito);// Guardar en la base de datos

            JOptionPane.showMessageDialog(this, "Registro guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);            // Mostrar mensaje de confirmación
            inicializarCampos(); // Limpiar los campos después de guardar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void eliminarRegistroInventario() {
        if (checkBoxValidacion.isSelected()) {// Validar que todos los campos estén llenos
            JOptionPane.showMessageDialog(this, "Este registro no se puede eliminar por que ya está validado,\nsolicita a un superior desactivar la validación para proceder.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {            // Crear una instancia de CreditosFiscales con los datos capturados
            CreditosFiscales credito = new CreditosFiscales();
            credito.setNumeroControl(Integer.parseInt(idField.getText()));
            credito.setRfc(rfcField.getText());
            credito.setNumeroCredito(numeroCreditoField.getText());
            credito.setRazonSocial(nombreField.getText());
            credito.setDomicilio(domicilioField.getText());
            credito.setCodigoPostal(codigoPostalField.getText());
            credito.setColonia((String) coloniaComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setMunicipio((String) municipioComboB.getSelectedItem()); // Índice seleccionado del combo
            credito.setIdAutoridadDeterminante((String) autoridadComboB.getSelectedItem());
            LocalDate fechaRecepcion = datePickerFechaRecepcion.getDate();
            if (fechaRecepcion != null) {
                java.sql.Date sqlfechaRecepcion = java.sql.Date.valueOf(fechaRecepcion);
                credito.setFechaRecepcion(sqlfechaRecepcion);
            }
            credito.setExpedienteProcedencia(expedienteProcedenciaFeild.getText());
            LocalDate fechaDocumentoDeterminante = datePickerDocumentoDeterminante.getDate();
            if (fechaDocumentoDeterminante != null) {
                java.sql.Date sqlfechaDocumentoDeterminante = java.sql.Date.valueOf(fechaDocumentoDeterminante);
                credito.setFechaDocumentoDeterminante(sqlfechaDocumentoDeterminante);
            }
            credito.setImporteDeterminado(Double.parseDouble(ImporteDeterminadoField.getText()));
            LocalDate fechaNotificacion = datePickerfechaNotificacion.getDate();
            if (fechaNotificacion != null) {
                java.sql.Date sqlfechaNotificacion = java.sql.Date.valueOf(fechaNotificacion);
                credito.setFechaNotificacion(sqlfechaNotificacion);
            }
            LocalDate fechaExigible = datePickerfechaExigible.getDate();
            if (fechaExigible != null) {
                java.sql.Date sqlfechaExigible = java.sql.Date.valueOf(fechaExigible);
                credito.setFechaExigible(sqlfechaExigible);
            }
            credito.setTipoNotificacion((String) tipoNotificacionComboB.getSelectedItem());
            credito.setTipoCredito((String) tipoCreditoComboB.getSelectedItem());
            credito.setEstatus(EstatusField.getText());
            LocalDate fechaEstatus = datePickerfechaExigible.getDate();
            if (fechaEstatus != null) {
                java.sql.Date sqlfechaEstatus = java.sql.Date.valueOf(fechaEstatus);
                credito.setFechaEstatus(sqlfechaEstatus);
            }
            credito.setObservaciones(observacionesArea.getText());
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setImpresion(false);
            credito.setValidacion(false);
            LocalDate fechaCaptura = DateUtil.getFechaActualLocalDate();
            if (fechaCaptura != null) {
                java.sql.Date sqlfechaCaptura = java.sql.Date.valueOf(fechaCaptura);
                credito.setFechaCaptura(sqlfechaCaptura);
            }
            credito.setIDUsuarioCaptura(SessionManager.getInstance().getUsuarioID());
            credito.setIdArea(SessionManager.getInstance().getIdArea());
            actualizarResumen(credito);
            creditosFiscalesDAO.eliminarCreditoInventario(credito);// Eliminar en la base de datos

            JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);            // Mostrar mensaje de confirmación
            inicializarCampos(); // Limpiar los campos después de guardar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void actualizarResumen(CreditosFiscales credito) {
        parentFrame = (SetjFrame) SwingUtilities.getWindowAncestor(this);
        resumenPanel = parentFrame.getContentPanel().getResumenPanel();
        resumenPanel.mostrarResumen(credito.toString());
    }

    private void bloquearResumen() {
        parentFrame = (SetjFrame) SwingUtilities.getWindowAncestor(this);
        resumenPanel = parentFrame.getContentPanel().getResumenPanel();
        resumenPanel.bloquearResumen();
    }

    private void activarResumen() {
        parentFrame = (SetjFrame) SwingUtilities.getWindowAncestor(this);
        resumenPanel = parentFrame.getContentPanel().getResumenPanel();
        resumenPanel.activarResumen();
    }

    private void limpiarResumen() {
        parentFrame = (SetjFrame) SwingUtilities.getWindowAncestor(this);
        resumenPanel = parentFrame.getContentPanel().getResumenPanel();
        resumenPanel.linpiarResumen();
    }

    private boolean validarCamposLlenos() {

        if (rfcField.getText().isEmpty() || numeroCreditoField.getText().isEmpty()
                || nombreField.getText().isEmpty() || domicilioField.getText().isEmpty()
                || codigoPostalField.getText().isEmpty() || expedienteProcedenciaFeild.getText().isEmpty()
                || ImporteDeterminadoField.getText().isEmpty() || EstatusField.getText().isEmpty()
                || observacionesArea.getText().isEmpty()
                ||// municipioComboB.getSelectedIndex() == 0 ||
                autoridadComboB.getSelectedIndex() == 0 || tipoNotificacionComboB.getSelectedIndex() == 0
                || tipoCreditoComboB.getSelectedIndex() == 0 || datePickerFechaRecepcion.getDate() == null
                || datePickerDocumentoDeterminante.getDate() == null
                || datePickerfechaNotificacion.getDate() == null
                || datePickerfechaExigible.getDate() == null
                || datePickerfechaEstatus.getDate() == null) {
            return false;
        }
        return true;
    }

    private void abrirBusqueda(String tipoBusqueda) {
        System.out.println("private void abrirBusqueda(String tipoBusqueda) {  " + tipoBusqueda);
        JDialog dialogBuscar = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Búsqueda de " + tipoBusqueda, true);
        dialogBuscar.setLayout(new BorderLayout());
        dialogBuscar.setSize(600, 400);
        dialogBuscar.setLocationRelativeTo(this);

        JTextField fieldBuscar = new JTextField(20);
        JButton buttonBuscar = new JButton("Buscar");
        JTable resultadosTable = new JTable(); // Para mostrar resultados

        JPanel topPanelBuscar = new JPanel();
        topPanelBuscar.add(new JLabel("Buscar:"));
        topPanelBuscar.add(fieldBuscar);
        topPanelBuscar.add(buttonBuscar);
        dialogBuscar.add(topPanelBuscar, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(resultadosTable);
        dialogBuscar.add(scrollPane, BorderLayout.CENTER);

        buttonBuscar.addActionListener(e -> {
            String criterio = fieldBuscar.getText().trim();
            System.out.println("String criterio = buttonBuscar.getText().trim();   " + criterio);
            if (!criterio.isEmpty()) {
                System.out.println("List<CreditosFiscales> resultados = buscarPorCriterio(tipoBusqueda, criterio);" + tipoBusqueda + "   " + criterio);
                List<CreditosFiscales> resultados = buscarPorCriterio(tipoBusqueda, criterio);
                for (CreditosFiscales credito : resultados) {
                    System.out.println(credito);
                }
                // Llenar la tabla con los resultados (se requiere un modelo adecuado)
                resultadosTable.setModel(new CreditosTableModel(resultados)); // Implementa este modelo para tu tabla
            }
        });
        fieldBuscar.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "busquedaAction");
        fieldBuscar.getActionMap().put("busquedaAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonBuscar.doClick(); // Ejecuta la acción del botón
            }
        });

        resultadosTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && resultadosTable.getSelectedRow() != -1) {
                CreditosFiscales seleccionado = ((CreditosTableModel) resultadosTable.getModel()).getCreditoAt(resultadosTable.getSelectedRow());
                rellenarCampos(seleccionado);
                esNuevo = false;
                dialogBuscar.dispose();
            }
        });

        dialogBuscar.setVisible(true);
    }

    private List<CreditosFiscales> buscarPorCriterio(String tipoBusqueda, String criterio) {
        switch (tipoBusqueda) {
            case "Número de control":
                return creditosFiscalesDAO.buscarPorNumeroControl(criterio);
            case "RFC":
                return creditosFiscalesDAO.buscarPorRFC(criterio);
            case "Número de crédito":
                return creditosFiscalesDAO.buscarPorNumeroCredito(criterio);
            default:
                return List.of();
        }
    }

    private void rellenarCampos(CreditosFiscales credito) {
        inicializarCampos();
        actualizarColoniasTodas();
        actualizarMunicipiosTodos();
        actualizarAutoridades();
        actualizarTiposNotificacion();
        actualizarTiposCredito();
        checkBoxValidacion.setSelected(credito.isValidacion());
        idField.setText(String.valueOf(credito.getNumeroControl()));
        rfcField.setText(credito.getRfc());
        nombreField.setText(credito.getRazonSocial());
        numeroCreditoField.setText(credito.getNumeroCredito());
        domicilioField.setText(credito.getDomicilio());
        codigoPostalField.setText(credito.getCodigoPostal());
        coloniaComboB.setSelectedItem(credito.getColonia());
        municipioComboB.setSelectedItem(credito.getMunicipio());
        autoridadComboB.setSelectedItem(credito.getIdAutoridadDeterminante());
        if (credito.getFechaRecepcion() != null) {
            datePickerFechaRecepcion.setDate(credito.getFechaRecepcion().toLocalDate());
        }
        expedienteProcedenciaFeild.setText(credito.getExpedienteProcedencia());
        if (credito.getFechaDocumentoDeterminante() != null) {
            datePickerDocumentoDeterminante.setDate(credito.getFechaDocumentoDeterminante().toLocalDate());
        }
        ImporteDeterminadoField.setText(String.valueOf(credito.getImporteDeterminado()));
        if (credito.getFechaNotificacion() != null) {
            datePickerfechaNotificacion.setDate(credito.getFechaNotificacion().toLocalDate());
        }
        if (credito.getFechaExigible() != null) {
            datePickerfechaExigible.setDate(credito.getFechaExigible().toLocalDate());
        }
        tipoNotificacionComboB.setSelectedItem(credito.getTipoNotificacion());
        tipoCreditoComboB.setSelectedItem(credito.getTipoCredito());
        EstatusField.setText(credito.getEstatus());
        if (credito.getFechaEstatus() != null) {
            datePickerfechaEstatus.setDate(credito.getFechaEstatus().toLocalDate());
        }
        observacionesArea.setText(credito.getObsrvacionesCredito());
        actualizarResumen(credito);
        // Rellena más campos si es necesario

        if (checkBoxValidacion.isSelected()) {
            bloquearCampos();
        } else {
            activarCampos();
        }
        System.out.println("guardado = " + credito.isGuardado());
    }

    private void bloquearCampos() {
        idField.setEnabled(false);
        rfcField.setEnabled(false);
        nombreField.setEnabled(false);
        numeroCreditoField.setEnabled(false);
        domicilioField.setEnabled(false);
        codigoPostalField.setEnabled(false);
        coloniaComboB.setEnabled(false);
        municipioComboB.setEnabled(false);
        autoridadComboB.setEnabled(false);
        datePickerFechaRecepcion.setEnabled(false);
        expedienteProcedenciaFeild.setEnabled(false);
        datePickerDocumentoDeterminante.setEnabled(false);
        ImporteDeterminadoField.setEnabled(false);
        datePickerfechaNotificacion.setEnabled(false);
        datePickerfechaExigible.setEnabled(false);
        tipoNotificacionComboB.setEnabled(false);
        tipoCreditoComboB.setEnabled(false);
        EstatusField.setEnabled(false);
        datePickerfechaEstatus.setEnabled(false);
        observacionesArea.setEnabled(false);
        bloquearResumen();
    }

    private void activarCampos() {
        idField.setEnabled(true);
        rfcField.setEnabled(true);
        nombreField.setEnabled(true);
        numeroCreditoField.setEnabled(true);
        domicilioField.setEnabled(true);
        codigoPostalField.setEnabled(true);
        coloniaComboB.setEnabled(true);
        municipioComboB.setEnabled(true);
        autoridadComboB.setEnabled(true);
        datePickerFechaRecepcion.setEnabled(true);
        expedienteProcedenciaFeild.setEnabled(true);
        datePickerDocumentoDeterminante.setEnabled(true);
        ImporteDeterminadoField.setEnabled(true);
        datePickerfechaNotificacion.setEnabled(true);
        datePickerfechaExigible.setEnabled(true);
        tipoNotificacionComboB.setEnabled(true);
        tipoCreditoComboB.setEnabled(true);
        EstatusField.setEnabled(true);
        datePickerfechaEstatus.setEnabled(true);
        observacionesArea.setEnabled(true);
        activarResumen();
    }

    private SetjFrame getParentFrame() {
        if (parentFrame == null) {
            parentFrame = (SetjFrame) SwingUtilities.getAncestorOfClass(SetjFrame.class, this);
        }
        return parentFrame;
    }
}
