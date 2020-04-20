package org.budowa.flow.kanban;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.budowa.entities.Building;

public class KanbanController {

    @FXML
    public ListView<Label> toDoList;
    public ListView<Label> foundationList;
    public ListView<Label> wallsList;
    public ListView<Label> ceilingList;
    public ListView<Label> roofList;
    public ListView<Label> doneList;

    public void addBuildings(Building[] building) {
        System.out.printf(building.toString());
    }
}
