package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.App;
import app.DBKonexioa;
import app.model.Makina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MakinakKontrolatzailea_aldatu {

    @FXML
    private TextArea idField;
    @FXML
    private TextArea izenaField;
    @FXML
    private TextArea deskribapenaField;
    @FXML
    private TextArea potentziaField;
    @FXML
    private TextArea dataField;

    @FXML
    public void aldatuMakina(ActionEvent event) throws IOException {

        try {
            // 1. Get text from UI
            int id_makina = Integer.parseInt(idField.getText());
            String izena = izenaField.getText();
            String deskribapena = deskribapenaField.getText();
            int potentzia = Integer.parseInt(potentziaField.getText());
            String instalazio_data = dataField.getText();

            // 2. Create object (optional, but same structure as gehitu)
            Makina makina = new Makina(id_makina, izena, deskribapena, potentzia, instalazio_data);

            System.out.println("Makina aldatu da: " + makina.toString());

            // 3. UPDATE in DB
            String update = "UPDATE makinak SET izena = ?, deskribapena = ?, potentzia = ?, instalazio_data = ? "
                    + "WHERE id_makina = ?";

            Connection cn = DBKonexioa.konektatu();
            PreparedStatement agindua = cn.prepareStatement(update);

            agindua.setString(1, izena);
            agindua.setString(2, deskribapena);
            agindua.setFloat(3, potentzia);
            agindua.setString(4, instalazio_data);
            agindua.setInt(5, id_makina);

            agindua.executeUpdate();

            agindua.close();
            cn.close();

            // 4. Change view
            App.setRoot("secondary");

        } catch (NumberFormatException e) {
            System.out.println("Errorea: Sartu balio egokia duten zenbakiak");
        } catch (SQLException e) {
            System.out.println("Errorea makina datuak aldatzean.");
            e.printStackTrace();
        }
    }
}
