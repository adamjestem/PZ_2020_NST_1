package org.budowa.flow.raports;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import org.budowa.entities.Building;
import org.budowa.entities.UserRole;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.BuildingsService;
import org.budowa.services.DialogService;
import org.budowa.services.RaportService;
import org.budowa.services.SessionManager;
import org.budowa.texts.Translations;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class BuildingDetailsRaportScene implements Initializable {
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final RaportService raportService = RaportService.inject();
    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();

    public ListView<String> buildingsList;

    private Building[] buildings;

    public BuildingDetailsRaportScene() {
        this.buildings = this.loadBuildings();
    }

    private Building[] loadBuildings() {
        var user = sessionManager.getLoggedInUser();
        switch (user.getUserRole()) {
            case OWNER:
                return this.buildingsService.getAllBuildings();
            case MANAGER:
                return this.buildingsService.getManagerBuildings(user);
            case WORKER:
                return this.buildingsService.getWorkerBuildings(user.getId());
            default:
                throw new IllegalStateException("Unexpected value: " + this.sessionManager.getLoggedInUser().getUserRole());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buildingsList.getItems().setAll(Arrays.stream(this.buildings).map(Building::getName).toArray(String[]::new));
        this.buildingsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void generateRaport(ActionEvent actionEvent) {
        var selectedBuildings = this.buildingsList.getSelectionModel().getSelectedItems();
        var buildings = Arrays.stream(this.buildings).filter(b -> selectedBuildings.contains(b.getName())).toArray(Building[]::new);
        this.raportService.printDetailedList(Translations.BUILDINGS_DETAILS, buildings);
        try {
            this.router.goTo(Route.DASHBOARD);
        } catch (IOException exception) {
            exception.printStackTrace();
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void cancel(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.DASHBOARD);
        } catch (IOException ex) {
            ex.printStackTrace();
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }
}
