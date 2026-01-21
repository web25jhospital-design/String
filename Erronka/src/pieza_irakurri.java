import java.io.BufferedReader;
import java.io.FileReader;

public class pieza_irakurri {
public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/piezak.csv"));
            String lerroa;

            br.readLine(); // hau salto egiteko lehengo lerroa
            while ((lerroa = br.readLine()) != null) {
                String[] datuak = lerroa.split(",");

                System.out.println(datuak[0]+"-"+datuak[1]+"-"+datuak[2]+"-"+datuak[3]);

            
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Errorea fitxategia irakurtzean");
        }
    }

}