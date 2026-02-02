package mvc_fx.controller;

import model.Pieza;
import model.PiezaModelo;
import view.PiezaBista;
import java.util.ArrayList;

public class PiezaKontrolatzailea {
    private PiezaModelo modelo;
    private PiezaBista bista;


    public PiezaKontrolatzailea(PiezaModelo modelo,PiezaBista bista){

        this.modelo = modelo;
        this.bista = bista;
    }

    public void gehituPieza(int id_pieza,String izena,String deskribapena,int pisua,double prezioa,String stock) {
        PiezaKontrolatzailea pieza = new PiezaKontrolatzailea(id_pieza,izena,deskribapena,prezioa,stock);
        modelo.gehituPieza(pieza);
    }

     public void erakutsiPieza(){
        Arraylist<pieza> piezaZerrenda = modelo.lortuPieza();
        bista.erakutsiPieza(piezaZerrenda);

     }

}
