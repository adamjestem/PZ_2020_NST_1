package org.budowa.flow.manager;

import javafx.event.ActionEvent;
import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.services.BuildingsService;

public class ManagerDashboardController extends DashboardBaseController {

    private BuildingsService buildingsService = BuildingsService.create();

    public void handleLogout(ActionEvent actionEvent) {
        System.out.println("logout");
    }

    public void handleClose(ActionEvent actionEvent) {
        System.out.println("close");
    }

    protected Building[] loadBuildings() {
        // todo: get user id from session manager
        return this.buildingsService.getManagerBuildings(0);
    }

    public void handleRefresh(ActionEvent actionEvent) {
        this.setBuildings(this.loadBuildings());
    }
}
