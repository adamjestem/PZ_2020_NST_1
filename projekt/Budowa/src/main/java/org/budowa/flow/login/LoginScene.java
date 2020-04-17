package org.budowa.flow.login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginScene {

    /* Views */

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private Text textErrorMessage;

    /* Actions */

    @FXML
    private void loginAction() {
        displayError();
    }

    @FXML
    private void textFieldUsernameAction() {
        hideError();
    }

    @FXML
    private void textFieldPasswordAction() {
        hideError();
    }

    /* Methods [private] */

    private boolean verifyCredentials() {

        return true;
    }

    private void displayError() {
        setErrorFor(textFieldUsername);
        setErrorFor(textFieldPassword);
        textErrorMessage.setVisible(true);
    }

    private void hideError() {
        removeErrorFrom(textFieldUsername);
        removeErrorFrom(textFieldPassword);
        textErrorMessage.setVisible(false);
    }

    private void setErrorFor(TextField textField) {
        textField.setStyle("" +
                "-fx-border-color: red; " +
                "-fx-border-width: 1px; " +
                "-fx-border-radius: 2px; "
        );
    }

    private void removeErrorFrom(TextField textField) {
        textField.setStyle(null);
    }
}