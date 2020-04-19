package org.budowa.flow.kanban;

import entities.Building;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class KanbanController {

    @FXML
    public ListView toDoList;
    public ListView foundationList;
    public ListView wallsList;
    public ListView ceilingList;
    public ListView roofList;
    public ListView doneList;

    public void addBuildings(Building[] building) {
        System.out.printf(building.toString());
    }
}
