package org.budowa.flow.kanban;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class KanbanController implements Initializable {

    @FXML
    public ListView<Node> toDoList;
    public ListView<Node> foundationList;
    public ListView<Node> wallsList;
    public ListView<Node> ceilingList;
    public ListView<Node> roofList;
    public ListView<Node> doneList;
    public Label doneLabel;
    public Label roofLabel;
    public Label ceilingLabel;
    public Label wallsLabel;
    public Label foundationsLabel;
    public Label todoLabel;

    public void addBuildings(Building[] building) {
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
