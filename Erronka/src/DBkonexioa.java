
// Importaciones necesarias para trabajar con JDBC
import java.sql.Connection;      // Datu baserekin lotzeko "komunikazio kanala" da.
import java.sql.DriverManager;   // Konexioa egiteaz arduratzen da.
import java.sql.SQLException;    // SKL egoera bereziak/erroreak kudeatzeko aukera ematen du

public class DBkonexioa {

 
    private static final String URL = "jdbc:mysql://localhost:3306/stringdb";

    // datu-basearen erabiltzailea
    private static final String USER = "Julen";

    // datu-basera konektatzeko pasahitza
    private static final String PASS = "Julen0586";


    public Connection konektatu() throws SQLException {

        return  DriverManager.getConnection(URL, USER, PASS);
    }
}
