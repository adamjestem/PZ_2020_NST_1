package org.budowa.flow.login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.budowa.router.Route;
import org.budowa.router.Router;

import java.io.IOException;
import java.util.Random;

public class LoginScene {

    private final Router router = Router.inject();

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
        // todo: check if valid data if so then login
        var random = new Random().nextFloat();
        if (random > 0.5) {
            displayError();
        } else {
            try {
                this.router.goTo(Route.DASHBOARD);
            } catch (IOException exception) {
                // todo show some alert with an error
                exception.printStackTrace();
            }
        }
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
