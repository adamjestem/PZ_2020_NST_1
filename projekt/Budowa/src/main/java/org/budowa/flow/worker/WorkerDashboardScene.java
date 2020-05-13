package org.budowa.flow.worker;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.*;
import org.budowa.services.*;
import org.budowa.texts.Translations;

import java.io.IOException;

public class WorkerDashboardScene extends DashboardBaseController {

    /* Properties */

    private final AuthService authService = AuthService.inject();
    private final SceneManager sceneManager = SceneManager.inject();
    private final DialogService dialogService = DialogService.inject();
    private final SessionManager sessionManager = SessionManager.inject();

    /* Actions */

    public void handleLogout(ActionEvent actionEvent) {
        try {
            this.authService.logout();
        } catch (IOException e) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
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
        var userId = this.sessionManager.getLoggedInUser().getId();
        return this.buildingsService.getWorkerBuildings(userId);
    }

    public void handleRaportStatus(ActionEvent actionEvent) {
        super.printRaport(Translations.ASSIGNED_BUILDINGS);
    }
}
