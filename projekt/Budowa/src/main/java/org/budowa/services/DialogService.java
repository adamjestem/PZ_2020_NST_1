package org.budowa.services;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogService {

    public static DialogService inject() {
        return new DialogService();
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.CLOSE);
        alert.showAndWait();
    }

    public void showInfoDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.CLOSE);
        alert.showAndWait();
    }

    public void showInfoDialog(String title, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(description);
        alert.showAndWait();
    }

    public Optional<ButtonType> showConfirmDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(message);
        alert.setHeaderText(message);
        return alert.showAndWait();
    }
}
