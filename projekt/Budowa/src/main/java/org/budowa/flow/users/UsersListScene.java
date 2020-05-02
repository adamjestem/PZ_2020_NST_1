package org.budowa.flow.users;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.DialogService;
import org.budowa.services.SessionManager;
import org.budowa.services.UsersService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    public TableColumn<User, UserRole> userRoleColumn;
    public TableColumn<User, String> assignedBuildingsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        userRoleColumn.setCellValueFactory(new PropertyValueFactory<>("userRole"));

        assignedBuildingsColumn.setCellFactory((user) -> new TableCell<>() {
            final Button showButton = new Button("Pokaż");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    return;
                }
                User user = getTableView().getItems().get(getIndex());
                if (user.getUserRole() == UserRole.OWNER) {
                    setText("Nie obowiązuje");
                    return;
                }
                var assignedBuildings = user.getUserRole() == UserRole.MANAGER ? user.getManagedBuildings() : user.getBuildings();
                String buildingNames;
                if(assignedBuildings.size() > 0) {
                    buildingNames = String.join(", ", assignedBuildings.stream().map(Building::getName).toArray(String[]::new));
                } else {
                    buildingNames = "Brak";
                }

                showButton.setOnAction(event -> {
                    dialogService.showInfoDialog("Przypisane budowy:", buildingNames);
                });
                setGraphic(showButton);
            }
        });

        actionsColumn.setCellFactory((user) -> new TableCell<>() {
            final Button editButton = new Button("Edytuj");
            final Button deleteButton = new Button("Usuń");

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    User user = getTableView().getItems().get(getIndex());
                    editButton.setCursor(Cursor.HAND);
                    editButton.setOnAction(event -> {
                        try {
                            router.goToEditUser(user.getId());
                        } catch (IOException ex) {
                            dialogService.showErrorDialog("Coś poszło nie tak");
                        }

                    });

                    deleteButton.setStyle("-fx-text-fill: white; -fx-background-color: indianred;");
                    deleteButton.setCursor(Cursor.HAND);
                    deleteButton.setOnAction(event -> {
                        var decision = dialogService.showConfirmDialog("Czy na pewno chcesz usunąć użytkownika " + user.getFullName());
                        if (decision.isPresent() && decision.get() == ButtonType.OK) {
                            usersService.removeUser(user.getId());
                            dialogService.showInfoDialog("Użytkownik usunięty");
                            loadUsers();
                        }
                    });

                    if (user.getUserRole().equals(UserRole.OWNER)) {
                        deleteButton.setVisible(false);
                    }

                    var hBox = new HBox(5);
                    hBox.getChildren().addAll(editButton, deleteButton);
                    setGraphic(hBox);
                }
                setText(null);
            }

        });
        this.loadUsers();
    }

    private void loadUsers() {
        var users = this.usersService.getAll();
        userTable.getItems().setAll(users);
    }

    public void onBackButton(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.DASHBOARD);
        } catch (IOException ex) {
            ex.printStackTrace();
            dialogService.showErrorDialog("Coś poszło nie tak");
        }
    }

    public void onAddUser(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.ADD_USER);
        } catch (IOException ex) {
            ex.printStackTrace();
            dialogService.showErrorDialog("Coś poszło nie tak");
        }
    }
}
