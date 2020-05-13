package org.budowa.flow.login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.codec.digest.DigestUtils;
import org.budowa.entities.User;
import org.budowa.repositories.UsersRepository;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.AuthService;
import org.budowa.services.SessionManager;
import org.budowa.texts.Translations;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.Random;

public class LoginScene {

    private final AuthService authService = AuthService.inject();

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
        try {
            authService.login(
                textFieldUsername.getText(),
                textFieldPassword.getText()
            );
        } catch (NoResultException noResultException) {
            displayError("Użytkownik nie insteje lub podano złe dane.");
        } catch (Exception e) {
            displayError(Translations.SOMETHING_WENT_WRONG);
            e.printStackTrace();
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

    private void displayError(String msg) {
        setErrorFor(textFieldUsername);
        setErrorFor(textFieldPassword);
        textErrorMessage.setText(msg);
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
