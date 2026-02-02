package mvc_fx.controller;

import mvc_fx.model.Erabiltzaile;
import mvc_fx.view.ErabiltzaileBista;
import model.Pieza;

import java.util.ArrayList;

public class ErabiltzaileKontrolatzailea {

    private ErabiltzaileModelo modelo;
    private ErabiltzaileBista bista;

    public ErabiltzaileKontrolatzailea(ErabiltzaileModelo modelo, ErabiltzaileBista bista) {
        this.modelo = modelo;
        this.bista = bista;
    }


    public void gehituErabiltzaile(int id_erabiltzaileak,String izena,String abizena,String nan,String helbidea,int posta_kodea,String email,String alta_data,String jaiotze_data) {

        Erabiltzaile erabiltzaile = new Erabiltzaile(id_erabiltzaileak,izena,abizena,nan,helbidea,posta_kodea,email,alta_data,jaiotze_data);

        modelo.gehituErabiltzaile(erabiltzaile);
    }

    public void erakutsiErabiltzaile() {
        ArrayList<Erabiltzaile> ErabiltzaileZerrenda = modelo.lortuErabiltzaile();
        bista.erakutsiErabiltzaile(ErabiltzaileZerrenda);
    }
}

