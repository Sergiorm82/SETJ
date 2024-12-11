package set;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreditosFiscalesDAO {

    public List<CreditosFiscales> obtenerTodos() {
        List<CreditosFiscales> creditos = new ArrayList<>();
        String query = "SELECT * FROM CreditosFiscales";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                CreditosFiscales credito = new CreditosFiscales(
                        resultSet.getInt("IdMovimiento"),
                        resultSet.getString("RFC"),
                        resultSet.getString("NumeroCredito"),
                        resultSet.getString("NombreRazonSocial"),
                        resultSet.getString("Domicilio"),
                        resultSet.getString("CodigoPostal"),
                        resultSet.getString("IdMunicipio"),
                        resultSet.getString("IdAutoridad"),
                        resultSet.getDate("FechaRecepcion"),
                        resultSet.getString("ExpedienteProcedencia"),
                        resultSet.getDate("FechaDocumento"),
                        resultSet.getDouble("ImporteDeterminado"),
                        resultSet.getDate("FechaNotificacion"),
                        resultSet.getDate("FechaExigible"),
                        resultSet.getString("IdTipoNotificacion"),
                        resultSet.getString("IdTipoCredito"),
                        resultSet.getString("Estatus"),
                        resultSet.getDate("FechaEstatus"),
                        resultSet.getString("Observaciones")
                );
                creditos.add(credito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditos;
    }

    // Método para obtener el siguiente consecutivo
    public int obtenerSiguienteId() {
        String query = "SELECT ISNULL(MAX(NumeroControl), 0) + 1 AS SiguienteNC FROM CreditosFiscales";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("SiguienteNC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1; // Si hay un error o no hay registros, devolver 1
    }

    // Método para obtener municipios por código postal
    public List<String> obtenerMunicipiosPorCodigoPostal(String codigoPostal) {
        List<String> municipios = new ArrayList<>();
        String query = "SELECT DISTINCT M.DATO_municipio "
                + "FROM MunicipiosJ M "
                + "INNER JOIN CodigosPostalesJ CP ON M.IdCodigoPostal = CP.IdCodigoPostal "
                + "WHERE CP.Dato_codigoPostal = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, codigoPostal);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                municipios.add(resultSet.getString("DATO_municipio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return municipios;
    }

    // Método para obtener municipios todos
    public List<String> obtenerMunicipiosPorColonia(String colonia) {
        List<String> municipios = new ArrayList<>();
        String query = "SELECT DISTINCT M.DATO_municipio "
                + "FROM AsentamientosJ A "
                + "INNER JOIN MunicipiosJ M ON A.IdMunicipio = M.IdMunicipio "
                + "WHERE  A.DATO_asentamiento = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, colonia);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                municipios.add(resultSet.getString("DATO_municipio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("nnnnnn = " + municipios);
        return municipios;
    }

    // Método para obtener colonias
    public List<String> obtenerColoniasTodas() {
        List<String> colonias = new ArrayList<>();
        String query = "SELECT DISTINCT DATO_asentamiento  FROM SETJ.dbo.AsentamientosJ order by DATO_asentamiento";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                colonias.add(resultSet.getString("DATO_asentamiento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return colonias;
    }

    // Método para obtener municipios
    public List<String> obtenerMunicipiosTodos() {
        List<String> municipios = new ArrayList<>();
        String query = "SELECT DISTINCT DATO_municipio FROM MunicipiosJ ORDER BY DATO_municipio";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                municipios.add(resultSet.getString("DATO_municipio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return municipios;
    }

    // Método para obtener colonias por código postal
    public List<String> obtenerColoniasPorCodigoPostal(String codigoPostal) {
        List<String> colonias = new ArrayList<>();
        String query = "SELECT DISTINCT DATO_asentamiento "
                + "FROM CodigosPostalesJ CP "
                + "JOIN "
                + "MunicipiosJ M ON CP.IdCodigoPostal = M.IdCodigoPostal "
                + "JOIN "
                + "AsentamientosJ A ON M.IdMunicipio = A.IdMunicipio AND CP.IdCodigoPostal = A.IdCodigoPostal "
                + "WHERE CP.Dato_codigoPostal = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, codigoPostal);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                colonias.add(resultSet.getString("DATO_asentamiento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return colonias;
    }

    public List<String> obtenerAutoridades() {
        List<String> autoridades = new ArrayList<>();

        String query = "SELECT DISTINCT DescripcionAutoridadDeterminante FROM AutoridadDeterminante";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                autoridades.add(resultSet.getString("DescripcionAutoridadDeterminante"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoridades;
    }

    public List<String> obtenerTiposNotificacion() {
        List<String> tiposNotificacion = new ArrayList<>();

        String query = "SELECT DISTINCT Descripcion FROM TipoNotificacion";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                tiposNotificacion.add(resultSet.getString("Descripcion"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tiposNotificacion;
    }

    public List<String> obtenerTiposCredito() {
        List<String> tiposCredito = new ArrayList<>();

        String query = "SELECT DISTINCT Descripcion FROM TipoCredito";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                tiposCredito.add(resultSet.getString("Descripcion"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tiposCredito;
    }

    public void actualizarCreditoInventario(CreditosFiscales credito) {
        String query = "UPDATE CreditosFiscales "
                + "SET RFC = ?, NumeroCredito = ?,IdAutoridadDeterminante = ?,  RazonSocial = ?, Domicilio = ?,  Colonia = ?, CodigoPostal = ?, "
                + "Municipio = ?, FechaRecepcion = ?, ExpedienteProcedencia = ?, FechaDocumentoDeterminante = ?, ImporteDeterminado = ?, "
                + "FechaNotificacion = ?, FechaExigible = ?, TipoNotificacion = ?, TipoCredito = ?, Estatus = ?, FechaEstatus = ?, "
                + "ObservacionesCredito = ?, Impresion = ?, Validacion = ?,IdUsuarioUltModificacion = ? ,Guardado = ?, FechaUltModificacion = ? "
                + "WHERE NumeroControl = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            // Asignar parámetros
            //
            statement.setString(1, credito.getRfc());
            statement.setString(2, credito.getNumeroCredito());
            statement.setString(3, credito.getIdAutoridadDeterminante());
            statement.setString(4, credito.getRazonSocial());
            statement.setString(5, credito.getDomicilio());
            statement.setString(6, credito.getColonia());
            statement.setString(7, credito.getCodigoPostal());
            statement.setString(8, credito.getMunicipio());
            statement.setDate(9, credito.getFechaRecepcion());
            statement.setString(10, credito.getExpedienteProcedencia());
            statement.setDate(11, credito.getFechaDocumentoDeterminante());
            statement.setDouble(12, credito.getImporteDeterminado());
            statement.setDate(13, credito.getFechaNotificacion());
            statement.setDate(14, credito.getFechaExigible());
            statement.setString(15, credito.getTipoNotificacion());
            statement.setString(16, credito.getTipoCredito());
            statement.setString(17, credito.getEstatus());
            statement.setDate(18, credito.getFechaEstatus());
            statement.setString(19, credito.getObservaciones());
            statement.setBoolean(20, credito.isImpresion());
            statement.setBoolean(21, credito.isValidacion());
            statement.setInt(22, credito.getIdUsuarioUltModificacion());
            statement.setBoolean(23, credito.isGuardado());
            statement.setDate(24, credito.getFechaUltModificacion());
            statement.setInt(25, credito.getNumeroControl());// Clave primaria para el WHERE
           
                        // Ejecutar la actualización
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Crédito actualizado correctamente: " + credito.toString());
            } else {
                System.out.println("No se encontró el crédito con NumeroControl: " + credito.getNumeroControl());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarCreditoInventario(CreditosFiscales credito) {
        String query = "INSERT INTO CreditosFiscales (NumeroControl, RFC, NumeroCredito,RazonSocial,Domicilio, CodigoPostal,Colonia, Municipio, IdAutoridadDeterminante, "
                + "FechaRecepcion, ExpedienteProcedencia, FechaDocumentoDeterminante, ImporteDeterminado,FechaNotificacion, FechaExigible, "
                + "TipoNotificacion, TipoCredito, Estatus, FechaEstatus, ObservacionesCredito,Impresion, Validacion,fechaCaptura,IdUsuarioCaptura, "
                + "IdArea, IdUsuarioUltModificacion,Guardado,FechaUltModificacion)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, credito.getNumeroControl());
            statement.setString(2, credito.getRfc());
            statement.setString(3, credito.getNumeroCredito());
            statement.setString(4, credito.getRazonSocial());
            statement.setString(5, credito.getDomicilio());
            statement.setString(6, credito.getCodigoPostal());
            statement.setString(7, credito.getColonia());
            statement.setString(8, credito.getMunicipio());
            statement.setString(9, credito.getIdAutoridadDeterminante());
            statement.setDate(10, credito.getFechaRecepcion());
            statement.setString(11, credito.getExpedienteProcedencia());
            statement.setDate(12, credito.getFechaDocumentoDeterminante());
            statement.setDouble(13, credito.getImporteDeterminado());
            statement.setDate(14, credito.getFechaNotificacion());
            statement.setDate(15, credito.getFechaExigible());
            statement.setString(16, credito.getTipoNotificacion());
            statement.setString(17, credito.getTipoCredito());
            statement.setString(18, credito.getEstatus());
            statement.setDate(19, credito.getFechaEstatus());
            statement.setString(20, credito.getObservaciones());
            statement.setBoolean(21, credito.isImpresion());
            statement.setBoolean(22, credito.isValidacion());
            statement.setDate(23, credito.getFechaCaptura());
            statement.setInt(24, credito.getIDUsuarioCaptura());
            statement.setInt(25, credito.getIdArea());
            statement.setInt(26, credito.getIdUsuarioUltModificacion());
            statement.setBoolean(27, credito.isGuardado());
            statement.setDate(28, credito.getFechaUltModificacion());
            System.out.println("" + credito.toString());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCreditoInventario(CreditosFiscales credito) {
        String query = "DELETE FROM CreditosFiscales WHERE NumeroControl = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, credito.getNumeroControl());
            // Ejecuta la actualización en la base de datos
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Crédito con NumeroControl " + credito.getNumeroControl() + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún crédito con el NumeroControl: " + credito.getNumeroControl());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el crédito con NumeroControl: " + credito.getNumeroControl());
        }
    }

    public List<CreditosFiscales> buscarPorNumeroControl(String NumeroControl) {
        List<CreditosFiscales> resultados = new ArrayList<>();
        String query = "SELECT * FROM CreditosFiscales WHERE NumeroControl = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, NumeroControl);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultados.add(crearCreditoDesdeResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<CreditosFiscales> buscarPorRFC(String RFC) {
        List<CreditosFiscales> resultados = new ArrayList<>();
        String query = "SELECT * FROM CreditosFiscales WHERE RFC = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, RFC);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultados.add(crearCreditoDesdeResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<CreditosFiscales> buscarPorNumeroCredito(String NumeroCredito) {
        List<CreditosFiscales> resultados = new ArrayList<>();
        String query = "SELECT * FROM CreditosFiscales WHERE NumeroCredito = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, NumeroCredito);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultados.add(crearCreditoDesdeResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    private CreditosFiscales crearCreditoDesdeResultSet(ResultSet resultSet) throws SQLException {
        return new CreditosFiscales(
                resultSet.getInt("NumeroControl"),
                resultSet.getString("RFC"),
                resultSet.getString("NumeroCredito"),
                resultSet.getInt("IDUsuarioCaptura"),
                resultSet.getInt("IdArea"),
                resultSet.getString("IdAutoridadDeterminante"),
                resultSet.getDate("FechaIngreso"),
                resultSet.getString("RazonSocial"),
                resultSet.getString("Domicilio"),
                resultSet.getString("Colonia"),
                resultSet.getString("CodigoPostal"),
                resultSet.getString("Municipio"),
                resultSet.getDate("FechaRecepcion"),
                resultSet.getString("ExpedienteProcedencia"),
                resultSet.getDate("FechaDocumentoDeterminante"),
                resultSet.getDouble("ImporteDeterminado"),
                resultSet.getDate("FechaNotificacion"),
                resultSet.getDate("FechaExigible"),
                resultSet.getString("TipoNotificacion"),
                resultSet.getString("TipoCredito"),
                resultSet.getString("Estatus"),
                resultSet.getDate("FechaEstatus"),
                resultSet.getString("ObservacionesCredito"),
                resultSet.getBoolean("Impresion"),
                resultSet.getBoolean("Validacion"),
                resultSet.getString("JefeDepartamento"),
                resultSet.getString("Asignacion"),
                resultSet.getString("Notas"),
                resultSet.getDate("FechaCaptura"),
                resultSet.getInt("IdUsuarioUltModificacion"),
                resultSet.getBoolean("Guardado"),
                resultSet.getDate("FechaUltModificacion")
        );
    }

}
