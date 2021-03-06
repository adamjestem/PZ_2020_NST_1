package org.budowa.flow.owner;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.router.Route;
import org.budowa.services.*;
import org.budowa.texts.Translations;

import java.io.IOException;

public class OwnerDashboardController extends DashboardBaseController {
    private final AuthService authService = AuthService.inject();
    private final SceneManager sceneManager = SceneManager.inject();

    @Override
    protected Building[] loadBuildings() {
        return this.buildingsService.getAllBuildings();
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.loadBuildings();
    }

    public void handleLogout(ActionEvent actionEvent) {
        try {
            this.authService.logout();
        } catch (IOException ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    public void handleAddBuilding(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.ADD_CONSTRUCTION);
        } catch (IOException exception) {
            dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void handleAddUser(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.ADD_USER);
        } catch (IOException exception) {
            exception.printStackTrace();
            dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void handleShowAllUsers(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.USERS_LIST);
        } catch (IOException exception) {
            dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void handleRaportStatus(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.WORK_RAPORT_STATUS);
        } catch (IOException exception) {
            exception.printStackTrace();
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void handleBuildingDetailsRaport(ActionEvent actionEvent) {
        try {
            this.router.goTo(Route.BUILDINGS_DETAILS_RAPORT);
        } catch (IOException exception) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }
}
