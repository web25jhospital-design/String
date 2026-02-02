package mvc_fx.model;

public class Erabiltzaile {

    private final int id_erabiltzaileak;
    private final String izena;
    private final String abizena;
    private final String nan;
    private final String helbidea;
    private final String email;
    private final String alta_data;
    private final int posta_kodea;
    private final String jaiotze_data;

    public Erabiltzaile(int id_erabiltzaileak, String izena, String abizena, String nan, String helbidea, int posta_kodea, String email, String alta_data, String jaiotze_data) {
        this.id_erabiltzaileak = id_erabiltzaileak;
        this.izena = izena;
        this.abizena = abizena;
        this.nan = nan;
        this.helbidea = helbidea;
        this.posta_kodea = posta_kodea;
        this.email = email;
        this.alta_data = alta_data;
        this.jaiotze_data = jaiotze_data;
    }

}
