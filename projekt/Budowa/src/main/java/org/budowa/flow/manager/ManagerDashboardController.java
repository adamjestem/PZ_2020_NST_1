package org.budowa.flow.manager;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.services.BuildingsService;
import org.budowa.services.SceneManager;
import org.budowa.services.SessionManager;

import java.util.Collection;

public class ManagerDashboardController extends DashboardBaseController {
    private final SessionManager sessionManager = SessionManager.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SceneManager sceneManager = SceneManager.inject();

    public void handleLogout(ActionEvent actionEvent) {
        this.sessionManager.logout();
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    protected Collection<Building> loadBuildings() {
        // todo: get user id from session manager
        return this.buildingsService.getManagerBuildings(0);
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.setBuildings(this.loadBuildings());
    }
}
