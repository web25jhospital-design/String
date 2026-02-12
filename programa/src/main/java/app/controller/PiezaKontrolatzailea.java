package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.App;
import app.DBKonexioa;
import app.model.Pieza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PiezaKontrolatzailea {

    @FXML
    private TextArea idPieza;
    @FXML
    private TextArea izenaPieza;
    @FXML
    private TextArea deskribapenaPieza;
    @FXML
    private TextArea pisuaPieza;
    @FXML
    private TextArea prezioaPieza;
    @FXML
    private TextArea stockPieza;

    @FXML
    public void gehituPieza(ActionEvent event) throws IOException {

        try {
            // 1. Get text from the UI
            int id_pieza = Integer.parseInt(idPieza.getText());
            String izena = izenaPieza.getText();
            String deskribapena = deskribapenaPieza.getText();
            int pisua = Integer.parseInt(pisuaPieza.getText());
            int prezioa = Integer.parseInt(prezioaPieza.getText());
            int stock = Integer.parseInt(stockPieza.getText());
       

            // 2. Create the object (coincide con Pieza.java)
            Pieza p1 = new Pieza(id_pieza, izena, deskribapena, pisua, prezioa, stock);

            // 3. Console check
            System.out.println("Pieza gehitu da: " + p1);

            // 4. INSERT into DB
            String insert = "INSERT INTO piezak (id_pieza, izena, deskribapena, Pisua_gr, prezioa, stock) VALUES (?, ?, ?, ?, ?, ?)";

            Connection cn = DBKonexioa.konektatu();
            PreparedStatement agindua = cn.prepareStatement(insert);

            agindua.setInt(1, id_pieza);
            agindua.setString(2, izena);
            agindua.setString(3, deskribapena);
            agindua.setInt(4, pisua);
            agindua.setInt(5, prezioa);
            agindua.setInt(6, stock);

            agindua.executeUpdate();

            agindua.close();
            cn.close();

            // 5. Change view
            App.setRoot("secondary");

        } catch (NumberFormatException e) {
            System.out.println("Errorea: sartu zenbaki zuzenak");
        } catch (SQLException e) {
            System.out.println("Errorea piezaren datuak sartzean");
            e.printStackTrace();
        }
    }
}
