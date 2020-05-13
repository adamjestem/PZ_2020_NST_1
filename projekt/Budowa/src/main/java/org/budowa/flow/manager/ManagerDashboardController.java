package org.budowa.flow.manager;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.services.AuthService;
import org.budowa.services.BuildingsService;
import org.budowa.services.SceneManager;
import org.budowa.services.SessionManager;
import org.budowa.texts.Translations;

import java.io.IOException;

public class ManagerDashboardController extends DashboardBaseController {
    private final AuthService authService = AuthService.inject();
    private final SceneManager sceneManager = SceneManager.inject();
    private final SessionManager sessionManager = SessionManager.inject();

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        this.authService.logout();
    }

    public void handleClose(ActionEvent actionEvent) {
        this.sceneManager.closeWindow();
    }

    protected Building[] loadBuildings() {
        var manager = this.sessionManager.getLoggedInUser();
        return this.buildingsService.getManagerBuildings(manager);
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.setBuildings(this.loadBuildings());
    }

    public void handleRaportStatus(ActionEvent actionEvent) {
        super.printRaport(Translations.ASSIGNED_BUILDINGS);
    }
}
