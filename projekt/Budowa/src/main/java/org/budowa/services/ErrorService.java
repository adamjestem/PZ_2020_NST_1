package org.budowa.services;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ErrorService {

    public static ErrorService inject() {
        return new ErrorService();
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.CLOSE);
        alert.showAndWait();
    }
}
