package app.model;

public class Erabiltzailea {

    private final int id_erabiltzailea;
    private final String izena;
    private final String abizena1;
    private final String nan;
    private final String helbidea;
    private final int posta_kodea;
    private final String email;
    private final String alta_data;
    private final String jaiotze_data;

    // ✅ Constructor que coincide con el controller
    public Erabiltzailea(int id_erabiltzailea, String izena, String abizena1,
                         String nan, String helbidea, int posta_kodea,
                         String email, String alta_data, String jaiotze_data) {

        this.id_erabiltzailea = id_erabiltzailea;
        this.izena = izena;
        this.abizena1 = abizena1;
        this.nan = nan;
        this.helbidea = helbidea;
        this.posta_kodea = posta_kodea;
        this.email = email;
        this.alta_data = alta_data;
        this.jaiotze_data = jaiotze_data;
    }

    @Override
    public String toString() {
        return "Erabiltzailea{" +
                "id_erabiltzailea=" + id_erabiltzailea +
                ", izena='" + izena + '\'' +
                ", abizena1='" + abizena1 + '\'' +
                ", nan='" + nan + '\'' +
                ", helbidea='" + helbidea + '\'' +
                ", posta_kodea=" + posta_kodea +
                ", email='" + email + '\'' +
                ", alta_data='" + alta_data + '\'' +
                ", jaiotze_data='" + jaiotze_data + '\'' +
                '}';
    }
}
