package org.budowa.flow.kanban;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class KanbanController implements Initializable {

    @FXML
    public ListView<Label> toDoList;
    public ListView<Label> foundationList;
    public ListView<Label> wallsList;
    public ListView<Label> ceilingList;
    public ListView<Label> roofList;
    public ListView<Label> doneList;
    public Label doneLabel;
    public Label roofLabel;
    public Label ceilingLabel;
    public Label wallsLabel;
    public Label foundationsLabel;
    public Label todoLabel;

    public void addBuildings(Building[] building) {
        System.out.printf(building.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setLabels();
    }

    private void setLabels() {
        this.doneLabel.setText(BuildingStatus.DONE.toString());
        this.roofLabel.setText(BuildingStatus.ROOF.toString());
        this.ceilingLabel.setText(BuildingStatus.CEILING.toString());
        this.wallsLabel.setText(BuildingStatus.WALLS.toString());
        this.foundationsLabel.setText(BuildingStatus.FOUNDATIONS.toString());
        this.todoLabel.setText(BuildingStatus.TODO.toString());
    }
}
