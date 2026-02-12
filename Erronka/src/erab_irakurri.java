import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class erab_irakurri {
    public static void main(String[] args) {

        Connection cn = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/erabiltzaileak.csv"));
            String lerroa;

            DBkonexioa konex = new DBkonexioa();
            cn = konex.konektatu();

            // ID AUTO_INCREMENT → NULL y SOLO 8 parámetros
            String sql = "INSERT INTO ERABILTZAILEA VALUES (NULL,?,?,?,?,?,?,?,?)";
            PreparedStatement agindua = cn.prepareStatement(sql);

            br.readLine(); // saltar cabecera
            while ((lerroa = br.readLine()) != null) {
                String[] datuak = lerroa.split(",");

                System.out.println(
                        datuak[0] + "-" + datuak[1] + "-" + datuak[2] + "-" + datuak[3] + "-" +
                        datuak[4] + "-" + datuak[5] + "-" + datuak[6] + "-" + datuak[7] + "-" + datuak[8]
                );

               
                agindua.setString(1, datuak[1]); // Izena
                agindua.setString(2, datuak[2]); // Abizena1
                agindua.setString(3, datuak[3]); // Nan
                agindua.setString(4, datuak[4]); // Helbidea
                agindua.setInt(5, Integer.parseInt(datuak[5])); // Posta_Kodea
                agindua.setString(6, datuak[6]); // Email
                agindua.setDate(7, Date.valueOf(datuak[7])); // Alta_data
                agindua.setDate(8, Date.valueOf(datuak[8])); // Jaiotze_data

                agindua.executeUpdate();
            }

            agindua.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Errorea fitxategia irakurtzean edo datuak sartzean");
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
