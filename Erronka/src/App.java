
import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws Exception {
         DBkonexioa konex = new DBkonexioa();
        Connection cn = null;

        try {
            // konektatu() metodoak SQLException jaurti dezake
            cn = konex.konektatu();

            // konexioa existitzen dela eta irekita dagoela konprobatzen du
            if (cn != null && !cn.isClosed()) {
                System.out.println("Komunikazio kanala irekita dago.");

                // Konexioa itxi egiten da
                cn.close();
                System.out.println("Konexioa itxi da.");
            }

        } catch (SQLException e) {
            System.out.println("Errorea datu-basera konektatzean");
            e.printStackTrace();
        }
}
}
