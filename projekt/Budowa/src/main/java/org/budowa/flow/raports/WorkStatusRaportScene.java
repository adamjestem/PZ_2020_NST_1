package org.budowa.flow.raports;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;
import org.budowa.entities.UserRole;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.*;
import org.budowa.texts.Translations;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WorkStatusRaportScene implements Initializable {
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final RaportService raportService = RaportService.inject();
    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();

    public ListView<BuildingStatus> statusList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var statuses = BuildingStatus.values();
        statusList.getItems().setAll(statuses);
        statusList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        statusList.getSelectionModel().selectAll();
    }

    public void generateRaport(ActionEvent actionEvent) {
        Building[] buildings;
        var includedStatuses = this.statusList.getSelectionModel().getSelectedItems();
        var userRole = this.sessionManager.getLoggedInUser().getUserRole();
        switch (userRole) {
            case WORKER:
                buildings = this.buildingsService.getWorkerBuildings(this.sessionManager.getLoggedInUser().getId());
                break;
            case MANAGER:
                buildings = this.buildingsService.getManagerBuildings(this.sessionManager.getLoggedInUser());
                break;
            case OWNER:
                buildings = this.buildingsService.getAllBuildings();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.sessionManager.getLoggedInUser().getUserRole());
        }
        buildings = Arrays.stream(buildings).filter(b -> includedStatuses.contains(b.getStatus())).toArray(Building[]::new);
        this.raportService.print(userRole == UserRole.MANAGER ? Translations.WORK_STATUS : Translations.ASSIGNED_BUILDINGS, buildings);
        try {
            this.router.goTo(Route.DASHBOARD);
        } catch (IOException exception) {
            exception.printStackTrace();
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }
}
