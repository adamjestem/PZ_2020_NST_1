package org.budowa.flow.users;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.budowa.entities.User;
import org.budowa.router.Router;
import org.budowa.services.DialogService;
import org.budowa.services.UsersService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersListScene implements Initializable {

    private final UsersService usersService = UsersService.inject();
    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();

    public TableView<User> userTable;
    public TableColumn<User, Integer> idColumn;
    public TableColumn<User, String> loginColumn;
    public TableColumn<User, String> fullNameColumn;
    public TableColumn<User, String> actionsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("fullName"));
        actionsColumn.setCellFactory((user) -> new TableCell<User, String>() {
            final Button editButton = new Button("Edytuj");
            final Button deleteButton = new Button("Usuń");

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    editButton.setCursor(Cursor.HAND);
                    editButton.setOnAction(event -> {
                        User user = getTableView().getItems().get(getIndex());
                        try {
                            router.goToEditUser(user.getId());
                        } catch (IOException ex) {
                            dialogService.showErrorDialog("Coś poszło nie tak");
                        }

                    });

                    deleteButton.setStyle("-fx-text-fill: white; -fx-background-color: indianred;");
                    deleteButton.setCursor(Cursor.HAND);
                    deleteButton.setOnAction(event -> {
                        User user = getTableView().getItems().get(getIndex());
                        var decision = dialogService.showConfirmDialog("Czy na pewno chcesz usunąć użytkownika " + user.getFullName());
                        if (decision.isPresent() && decision.get() == ButtonType.OK) {
                            usersService.removeUser(user.getId());
                            dialogService.showInfoDialog("Użytkownik usunięty");
                        }
                    });

                    var hBox = new HBox(5);
                    hBox.getChildren().addAll(editButton, deleteButton);
                    setGraphic(hBox);
                }
                setText(null);
            }

        });
        var users = this.usersService.getAll();
        userTable.getItems().setAll(users);

    }
}
