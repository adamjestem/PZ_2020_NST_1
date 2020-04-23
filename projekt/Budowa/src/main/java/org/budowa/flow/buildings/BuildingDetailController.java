package org.budowa.flow.buildings;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.services.BuildingsService;
import org.budowa.services.UsersService;

import javax.persistence.Basic;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildingDetailController implements Initializable {

    //region injectables
    private final BuildingsService buildingsService = BuildingsService.inject();

    private final UsersService usersService = UsersService.inject();
    //endregion

    // region template controls

    //endregion
    public static int selectedBuildingId;
    public Label title;
    public Label description;
    public VBox workers;
    public Label managerName;
    public Label priority;
    public Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var building = this.buildingsService.getById(BuildingDetailController.selectedBuildingId);
        this.setTitle(building);
        this.setDescription(building);
        this.setStatus(building);
        this.setPriority(building);
        this.setManagerName(building);
        this.setWorkers(building);
    }

    private void setTitle(Building building) {
        title.setText(building.getName());
    }

    private void setDescription(Building building) {
        description.setText(building.getDescription());
    }

    private void setStatus(Building building) {
        this.status.setText(building.getStatus().toString());
    }

    private void setPriority(Building building) {
        this.priority.setText(building.getPriority().toString());
    }

    private void setManagerName(Building building) {
        var managerId = building.getManagerId();
        if (managerId == null) {
            this.managerName.setText("Nieprzypisany");
        }
        var manager = this.usersService.getById(managerId);
        this.managerName.setText(manager.getFullName());
    }

    private void setWorkers(Building building) {
        var workers = building.getWorkers().toArray(new User[0]);
        for (var worker : workers) {
            var label = new Label(worker.getFullName());
            label.setFont(Font.font("System", FontWeight.BOLD, 14));
            this.workers.getChildren().add(label);
        }
    }
}
