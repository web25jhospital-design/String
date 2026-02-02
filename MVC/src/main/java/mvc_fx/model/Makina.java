/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mvc_fx.model;


public class Makina {

    private final int id_makina;
    private final String deskribapena;
    private final String izena;
    private final int potentzia;
    private final String instalazio_data;

    public Makina(int id_makina, String izena, String deskribapena, int potentzia, String instalazio_data) {
        this.id_makina = id_makina;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.potentzia = potentzia;
        this.instalazio_data = instalazio_data;
    }

}
