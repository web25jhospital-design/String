package app.model;

public class Pieza {

    private final int id_pieza;
    private final String izena;
    private final String deskribapena;
    private final int pisua;
    private final int prezioa;
    private final int stock;

    public Pieza(int id_pieza, String izena, String deskribapena,
                 int pisua, int prezioa, int stock) {

        this.id_pieza = id_pieza;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.pisua = pisua;
        this.prezioa = prezioa;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "id_pieza=" + id_pieza +
                ", izena='" + izena + '\'' +
                ", deskribapena='" + deskribapena + '\'' +
                ", pisua=" + pisua +
                ", prezioa=" + prezioa +
                ", stock=" + stock +
                '}';
    }
}
