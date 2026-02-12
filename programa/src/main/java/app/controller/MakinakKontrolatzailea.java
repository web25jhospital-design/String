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

public class MakinakKontrolatzailea {

    @FXML private TextArea idField;
    @FXML private TextArea izenaField;
    @FXML private TextArea deskribapenaField;
    @FXML private TextArea potentziaField;
    @FXML private TextArea dataField;

    @FXML
    public void gehituMakina(ActionEvent event) {
        String sql = "INSERT INTO makinak (id_makina, izena, deskribapena, potentzia, instalazio_data) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection cn = DBKonexioa.konektatu();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(idField.getText().trim()));
            ps.setString(2, izenaField.getText().trim());
            ps.setString(3, deskribapenaField.getText().trim());
            ps.setInt(4, Integer.parseInt(potentziaField.getText().trim()));
            ps.setString(5, dataField.getText().trim());

            ps.executeUpdate();
            
            mostrarAlerta("Ondo", "Makina ondo gehitu da.");
            App.setRoot("Makinak"); // Vuelve a la tabla principal

        } catch (SQLException | IOException | NumberFormatException e) {
            mostrarAlerta("Errorea", "Ezin izan da gehitu: " + e.getMessage());
            e.printStackTrace();
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