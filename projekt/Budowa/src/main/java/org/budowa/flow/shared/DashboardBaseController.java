package org.budowa.flow.shared;

import entities.Building;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.budowa.entities.BuildingStatus;
import org.budowa.flow.kanban.KanbanController;

import java.util.ArrayList;

public abstract class DashboardBaseController {

    @FXML
    public KanbanController kanbanController;

    public void setBuildings(Building[] buildings){
        this.kanbanController.toDoList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.TODO));
        this.kanbanController.foundationList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.FOUNDATIONS));
        this.kanbanController.wallsList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.WALLS));
        this.kanbanController.ceilingList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.CEILING));
        this.kanbanController.roofList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.ROOF));
        this.kanbanController.doneList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.TODO));

    }

    private Label[] getFilteredLabels(Building[] buildings, BuildingStatus status) {
        var filteredBuildings = new ArrayList<Label>();
        for (var building : buildings) {
            if(building.getStatus() != status) {
                break;
            }
            var label = getBuildingLabel(building);
            filteredBuildings.add(label);
        }
        return filteredBuildings.toArray(Label[]::new);
    }

    private Label getBuildingLabel(Building building) {
        var label = new Label(building.getName());
        label.setCursor(Cursor.HAND);
        label.setOnMouseClicked(mouseEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pokaż detailsy", ButtonType.CLOSE);
            alert.showAndWait();
        });
        return label;
    }
}
