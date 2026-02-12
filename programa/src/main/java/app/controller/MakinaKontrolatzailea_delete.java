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

public class MakinaKontrolatzailea_delete {

    @FXML private TextArea idField;
    @FXML private TextArea izenaField;
    @FXML private TextArea deskribapenaField;
    @FXML private TextArea potentziaField;
    @FXML private TextArea dataField;

    @FXML
    private void ezabatuMakina(ActionEvent event) throws IOException {

        String idText = idField.getText().trim();

        if (idText.isEmpty()) {
            mostrarAlerta("Kontuz!", "Ezabatzeko makina baten ID-a sartu behar duzu.");
            return;
        }

        String sql = "DELETE FROM makinak WHERE id_makina = ?";

        try (Connection cn = DBKonexioa.konektatu();
             PreparedStatement agindua = cn.prepareStatement(sql)) {

            int id_makina = Integer.parseInt(idText);
            agindua.setInt(1, id_makina);

            int filasBorradas = agindua.executeUpdate();

            if (filasBorradas > 0) {
                mostrarAlerta("Ondo", "ID " + id_makina + " duen makina zuzen ezabatu da.");

                idField.clear();
                izenaField.clear();
                deskribapenaField.clear();
                potentziaField.clear();
                dataField.clear();

                App.setRoot("secondary");
            } else {
                mostrarAlerta("Kontuz", "Ez da existitzen ID " + id_makina + " duen makina.");
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Errorea", "ID-a zenbaki oso bat izan behar da.");
        } catch (SQLException e) {
            mostrarAlerta("Datu basearen errorea", e.getMessage());
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