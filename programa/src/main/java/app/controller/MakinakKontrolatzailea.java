package app.controller;

import java.io.IOException;

import app.App;
import app.model.Makina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MakinakKontrolatzailea {

    @FXML private TextArea idField;
    @FXML private TextArea izenaField;
    @FXML private TextArea deskribapenaField;
    @FXML private TextArea potentziaField;
    @FXML private TextArea dataField;

    @FXML
    public void gehituMakina(ActionEvent event) throws IOException {
        try {
            // 1. Get text from the UI
            int id_makina = Integer.parseInt(idField.getText());
            String izena = izenaField.getText();
            String deskribapena = deskribapenaField.getText();
            int potentzia = Integer.parseInt(potentziaField.getText());
            String instalazio_data = dataField.getText();

            // 2. Create the object
            Makina makina = new Makina(id_makina, izena, deskribapena, potentzia, instalazio_data);

            // 3. Logic (save to database, etc.)
            System.out.println("Makina gehitu da: " + makina.toString());
            
            // 4. Change view
            App.setRoot("secondary");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers for ID and Power.");
        }
    }
}


