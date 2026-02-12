package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBKonexioa {

    private static final String URL  = "jdbc:mysql://localhost:3306/stringdb";
    private static final String USER = "Julen";
    private static final String PASS = "Julen0586";

    public static Connection konektatu() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

