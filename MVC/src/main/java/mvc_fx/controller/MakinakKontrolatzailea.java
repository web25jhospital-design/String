package mvc_fx.controller;

import mvc_fx.model.Makina;

import java.io.IOException;
import mvc_fx.javafx.fxml.FXML;

import java.util.ArrayList;

public class MakinakKontrolatzailea {

    public void gehituMakina(int id_makina, String izena, String deskribapena, int potentzia, String instalazio_data) {

        Makina makina = new Makina(id_makina, izena, deskribapena, potentzia, instalazio_data);

        //gehitu makina datubasera

    }

    public void erakutsiErabiltzaile() {
        ArrayList<Erabiltzaile> ErabiltzaileZerrenda = modelo.lortuErabiltzaile();
        bista.erakutsiErabiltzaile(ErabiltzaileZerrenda);
    }
}


