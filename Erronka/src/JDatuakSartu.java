

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class JDatuakSartu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final String user = "root";
        final String password = "12345678";
        final String databaseIzena = "hr";
        final String url = "jdbc:mysql://localhost:3306/" + databaseIzena;
        final String driver = "com.mysql.cj.jdbc.Driver";

        try {
            System.out.println("...Intentando Conectar con la base de datos...");
            Thread.sleep(2 * 1000);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("HEUSTON, Connexion realizada con EXITO!");

            String insertSententzia =
                "INSERT INTO HR.Employees(Employee_id,first_name,last_name,Email,Hire_date,Job_Id) VALUES(?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(insertSententzia);
            pst.setInt(1, 223);
            pst.setString(2, "Iker");
            pst.setString(3, "Coranti");
            pst.setString(4, "icoranti@imaltuna.com");

            /*************************************************************/
            /* FORMATO egokia emateko */
            LocalDate myDate = LocalDate.now();
            String databerria = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            // System.out.println(myDate);
            /*************************************************************/

            pst.setString(5, databerria);
            pst.setString(6, "IT_PROG");
            // pst.setInt(7, 60);

            // Exekutatzeko
            pst.executeUpdate();

            // Konexioa itxi
            conn.close();
            Thread.sleep(2 * 1000);
            System.out.println("HEUSTON, Dato insertado eta GO-GO-GO");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Connexion Cerrada/Tancat BAYBE...");
            System.out.println("Bye-Bye!!!!");
        }
    }
}
