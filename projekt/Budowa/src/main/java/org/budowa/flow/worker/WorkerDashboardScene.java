package org.budowa.flow.worker;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.*;
import org.budowa.services.*;

import java.io.IOException;
import java.util.Collection;

public class WorkerDashboardScene extends DashboardBaseController {

    /* Properties */

    private final AuthService authService = AuthService.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private final SceneManager sceneManager = SceneManager.inject();
    private final ErrorService errorService = ErrorService.inject();
    private final SessionManager sessionManager = SessionManager.inject();

    /* Actions */

    public void handleLogout(ActionEvent actionEvent) {
        try {
            this.authService.logout();
        } catch (IOException e) {
            this.errorService.showError("Coś poszło nie tak.");
        }
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.setBuildings(this.loadBuildings());
    }

    /* Methods [protected] */

    @Override
    protected Building[] loadBuildings() {
        var userId = this.sessionManager.getUser().getId();
        return this.buildingsService.getWorkerBuildings(userId);
    }
}
