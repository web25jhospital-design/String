import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Irakurri_erabiltzaileak_eta_makinak {

    public static void main(String[] args) {
        String lerroa;
        Connection cn = null;

        try (BufferedReader br = new BufferedReader(
                new FileReader("data\\erabiltzaileak_eta_makinak.csv"))) {

            DBkonexioa konex = new DBkonexioa();
            cn = konex.konektatu();

            br.readLine(); // saltar cabecera

            String kontsulta =
                    "INSERT INTO ERABILTZAILEAK_ETA_MAKINAK VALUES (?,?,?,?)";
            PreparedStatement agindua = cn.prepareStatement(kontsulta);

            while ((lerroa = br.readLine()) != null) {

                String[] datuak = lerroa.split(",", -1);

                // ✅ COMPROBACIÓN CLAVE
                if (datuak.length < 3) {
                    System.out.println("Lerro okerra (gutxienez 3 datu behar): " + lerroa);
                    continue;
                }

                System.out.println(
                        datuak[0] + "-" + datuak[1] + "-" + datuak[2] +
                        (datuak.length > 3 ? "-" + datuak[3] : "")
                );

                agindua.setInt(1, Integer.parseInt(datuak[0])); // Id_erabiltzailea
                agindua.setInt(2, Integer.parseInt(datuak[1])); // Id_makina
                agindua.setDate(3, java.sql.Date.valueOf(datuak[2])); // Hasiera

                // ✅ Amaiera_data opcional
                if (datuak.length < 4 || datuak[3].trim().isEmpty()) {
                    agindua.setNull(4, Types.DATE);
                } else {
                    agindua.setDate(4, java.sql.Date.valueOf(datuak[3]));
                }

                agindua.executeUpdate();
            }

            agindua.close();

        } catch (SQLException e) {
            System.out.println("Errorea datuak sartzean.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean.");
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