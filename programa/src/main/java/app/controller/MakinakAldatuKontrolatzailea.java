package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.App;
import app.DBKonexioa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class MakinakAldatuKontrolatzailea {

    @FXML private TextArea idField;
    @FXML private TextArea izenaField;
    @FXML private TextArea deskribapenaField;
    @FXML private TextArea potentziaField;
    @FXML private TextArea dataField;

    @FXML
    public void aldatuMakina(ActionEvent event) throws IOException {
        // Obtenemos los datos de los campos
        String idText = idField.getText().trim();
        String izena = izenaField.getText().trim();
        String deskribapena = deskribapenaField.getText().trim();
        String potentziaText = potentziaField.getText().trim();
        String data = dataField.getText().trim();

        if (idText.isEmpty()) {
            mostrarAlerta("Errorea", "Sartu ID bat aldatzeko.");
            return;
        }

        // Sentencia SQL para actualizar (UPDATE)
        String sql = "UPDATE makinak SET izena = ?, deskribapena = ?, potentzia = ?, instalazio_data = ? WHERE id_makina = ?";

        try (Connection cn = DBKonexioa.konektatu();
             PreparedStatement agindua = cn.prepareStatement(sql)) {

            agindua.setString(1, izena);
            agindua.setString(2, deskribapena);
            agindua.setInt(3, Integer.parseInt(potentziaText));
            agindua.setString(4, data);
            agindua.setInt(5, Integer.parseInt(idText));

            int rowsAffected = agindua.executeUpdate();

            if (rowsAffected > 0) {
                mostrarAlerta("Eginda", "Makina ondo aldatu da datu-basean.");
                App.setRoot("Makinak"); // Volver a la pantalla principal
            } else {
                mostrarAlerta("Errorea", "Ez da aurkitu ID hori duen makinarik.");
            }

        } catch (SQLException e) {
            mostrarAlerta("Datu-base errorea", "Ezin izan da makina aldatu.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            mostrarAlerta("Formatu errorea", "ID eta Potentziak zenbakiak izan behar dute.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}