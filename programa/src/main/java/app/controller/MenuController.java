package app.controller;

import java.io.IOException;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

    /**
     * Navega a la pantalla principal de la tabla de máquinas.
     */
    @FXML
    public void abrirMakinak(ActionEvent event) throws IOException {
        App.setRoot("Makinak");
    }

    /**
     * Navega a la pantalla de gestión de piezas.
     */
    @FXML
    public void abrirPiezak(ActionEvent event) throws IOException {
        App.setRoot("Piezak");
    }

    /**
     * Navega a la pantalla de gestión de usuarios (Erabiltzailea).
     * Este método resuelve el error "Error resolving onAction='#abrirErabiltzailea'".
     */
    @FXML
    public void abrirErabiltzailea(ActionEvent event) throws IOException {
        App.setRoot("Erabiltzailea");
    }

    /**
     * Navega al formulario para añadir una nueva máquina.
     * Corresponde al botón "GEHITU BERRIA" en tu interfaz.
     */
    @FXML
    public void abrirMakinakGehitu(ActionEvent event) throws IOException {
        App.setRoot("Makinak_gehitu");
    }

    /**
     * Navega a la pantalla para eliminar máquinas.
     * Corresponde al botón "EZABATU" en tu interfaz actualizada.
     */
    @FXML
    public void abrirMakinakEzabatu(ActionEvent event) throws IOException {
        App.setRoot("Makinak_ezabatu");
    }

    /**
     * Navega a la pantalla para modificar datos de una máquina existente.
     * Corresponde al nuevo botón "ALDATU" que has añadido.
     */
    @FXML
    public void abrirMakinakAldatu(ActionEvent event) throws IOException {
        App.setRoot("Makinak_aldatu");
    }
}