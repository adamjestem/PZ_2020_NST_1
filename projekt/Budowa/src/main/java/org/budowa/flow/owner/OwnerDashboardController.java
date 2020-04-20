package org.budowa.flow.owner;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.services.BuildingsService;
import org.budowa.services.SceneManager;
import org.budowa.services.SessionManager;

public class OwnerDashboardController extends DashboardBaseController {
    private final SessionManager sessionManager = SessionManager.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SceneManager sceneManager = SceneManager.inject();

    @Override
    protected Building[] loadBuildings() {
        return this.buildingsService.getAllBuildings();
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.loadBuildings();
    }

    public void handleLogout(ActionEvent actionEvent) {
        sessionManager.logout();
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    public void handleAddBuilding(ActionEvent actionEvent) {
        // todo: redirect to add building scene
    }

    public void handleEditBuilding(ActionEvent actionEvent) {
        // todo: redirect to edit building scene
    }

    public void handleDeleteBuilding(ActionEvent actionEvent) {
        // todo: redirect to delete building
    }

    public void handleAddUser(ActionEvent actionEvent) {
        // todo: redirect to add user
    }

    public void handleEditUser(ActionEvent actionEvent) {
        // todo: redirect to edit user
    }

    public void handleDeleteUser(ActionEvent actionEvent) {
        // todo: redirect to delete user
    }

    public void handleShowAllUsers(ActionEvent actionEvent) {
        // todo: redirect to show all users
    }
}
