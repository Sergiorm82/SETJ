package set;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlserver://10.10.1.37:1433;databaseName=SETJ;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "Dell-2024";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}