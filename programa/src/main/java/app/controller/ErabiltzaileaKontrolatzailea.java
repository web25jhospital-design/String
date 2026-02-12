package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import app.App;
import app.DBKonexioa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ErabiltzaileaKontrolatzailea {

    @FXML private TextArea idErab;
    @FXML private TextArea izenaErab;
    @FXML private TextArea abizenaErab;
    @FXML private TextArea nanErab;
    @FXML private TextArea helbideaErab;
    @FXML private TextArea postaKodeaErab;
    @FXML private TextArea emailErab;
    @FXML private TextArea altaDataErab;
    @FXML private TextArea jaiotzeDataErab;

    @FXML
    public void gehituErabiltzailea(ActionEvent event) throws IOException {

        try {
            int id = Integer.parseInt(idErab.getText());
            String izena = izenaErab.getText();
            String abizena = abizenaErab.getText();
            String nan = nanErab.getText();
            String helbidea = helbideaErab.getText();
            int postaKodea = Integer.parseInt(postaKodeaErab.getText());
            String email = emailErab.getText();

            LocalDate altaData = LocalDate.parse(altaDataErab.getText());      // YYYY-MM-DD
            LocalDate jaiotzeData = LocalDate.parse(jaiotzeDataErab.getText());

            String sql =
                "INSERT INTO ERABILTZAILEA " +
                "(Id_erabiltzaileak, Izena, Abizena1, Nan, Helbidea, " +
                "Posta_Kodea, Email, Alta_data, Jaiotze_data) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection cn = DBKonexioa.konektatu();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, izena);
            ps.setString(3, abizena);
            ps.setString(4, nan);
            ps.setString(5, helbidea);
            ps.setInt(6, postaKodea);
            ps.setString(7, email);
            ps.setDate(8, Date.valueOf(altaData));
            ps.setDate(9, Date.valueOf(jaiotzeData));

            ps.executeUpdate();

            ps.close();
            cn.close();

            App.setRoot("secondary");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
