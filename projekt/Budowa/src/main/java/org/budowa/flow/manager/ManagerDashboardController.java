package org.budowa.flow.manager;

import entities.Building;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.budowa.entities.BuildingStatus;
import org.budowa.flow.shared.DashboardBaseController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManagerDashboardController extends DashboardBaseController implements Initializable {

    public void handleLogout(ActionEvent actionEvent) {
        System.out.println("logout");
    }

    public void handleClose(ActionEvent actionEvent) {
        System.out.println("close");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.setBuildings(this.loadBuildings());
    }

    private Building[] loadBuildings() {
        // todo: select from repository
        var buildings = new ArrayList<Building>();
        var b = new Building();
        b.setName("Budowa u Staszka");
        b.setStatus(BuildingStatus.CEILING);
        buildings.add(b);
        return buildings.toArray(Building[]::new);
    }
}
