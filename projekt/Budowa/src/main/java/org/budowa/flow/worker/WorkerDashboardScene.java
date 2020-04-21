package org.budowa.flow.worker;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.*;
import org.budowa.services.BuildingsService;
import org.budowa.services.SceneManager;
import org.budowa.services.SessionManager;

import java.util.Collection;

public class WorkerDashboardScene extends DashboardBaseController {

    /* Properties */

    private final SessionManager sessionManager = SessionManager.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SceneManager sceneManager = SceneManager.inject();

    /* Actions */

    public void handleLogout(ActionEvent actionEvent) {
        this.sessionManager.logout();
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.setBuildings(this.loadBuildings());
    }

    /* Methods [protected] */

    @Override
    protected Collection<Building> loadBuildings() {
        // todo: get user id from session manager
        return this.buildingsService.getWorkerBuildings(0);
    }
}
