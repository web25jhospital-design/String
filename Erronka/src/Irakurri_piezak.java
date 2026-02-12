import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Irakurri_piezak {

    public static void main(String[] args) {

        String lerroa;
        Connection cn = null;

        try (BufferedReader br = new BufferedReader(new FileReader("data\\piezak.csv"))) {

            DBkonexioa konex = new DBkonexioa();
            cn = konex.konektatu();

            br.readLine(); // Saltar cabecera

            String sql = "INSERT INTO PIEZA "
                    + "(Id_pieza, Id_pieza_mota, Izena, Deskribapena, Pisua, prezioa, stock) "
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            while ((lerroa = br.readLine()) != null) {

                String[] datuak = lerroa.split(",");

                // Seguridad: comprobar número de columnas
                if (datuak.length != 7) {
                    System.out.println("Errorea: lerro honek ez ditu 7 zutabe -> " + lerroa);
                    continue;
                }

                System.out.println(
                        datuak[0] + "-" +
                        datuak[1] + "-" +
                        datuak[2] + "-" +
                        datuak[3] + "-" +
                        datuak[4] + "-" +
                        datuak[5] + "-" +
                        datuak[6]
                );

                ps.setString(1, datuak[0]); // Id_pieza (VARCHAR)
                ps.setString(2, datuak[1]); // Id_pieza_mota (VARCHAR)
                ps.setString(3, datuak[2]); // Izena
                ps.setString(4, datuak[3]); // Deskribapena
                ps.setString(5, datuak[4]); // Pisua
                ps.setInt(6, Integer.parseInt(datuak[5])); // prezioa
                ps.setInt(7, Integer.parseInt(datuak[6])); // stock

                ps.executeUpdate();
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Errorea datuak sartzean.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean.");
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                    System.out.println("Konexioa itxi da.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}