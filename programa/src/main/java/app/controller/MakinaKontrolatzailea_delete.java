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

    @FXML
    public void ezabatuMakina(ActionEvent event) {
        String idText = idField.getText().trim();

        if (idText.isEmpty()) {
            mostrarAlerta("Kontuz", "Sartu ID bat ezabatzeko.");
            return;
        }

        String sql = "DELETE FROM makinak WHERE id_makina = ?";

        try (Connection cn = DBKonexioa.konektatu();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(idText));
            int filas = ps.executeUpdate();

            if (filas > 0) {
                mostrarAlerta("Ondo", "Makina ezabatu da.");
                App.setRoot("Makinak");
            } else {
                mostrarAlerta("Errorea", "Ez da aurkitu ID hori.");
            }

        } catch (SQLException | IOException | NumberFormatException e) {
            mostrarAlerta("Errorea", e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void itzuli(ActionEvent event) throws IOException {
        App.setRoot("Makinak");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}