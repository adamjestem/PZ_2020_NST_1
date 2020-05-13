package org.budowa.flow.kanban;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.budowa.entities.Building;

import java.net.URL;
import java.util.ResourceBundle;

public class KanbanItemController implements Initializable {
    public Label nameText;
    public ImageView priorityImage;
    public Label priorityText;

    private final Building building;

    public KanbanItemController(Building building) {
        this.building = building;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameText.setText(building.getName());
        priorityText.setText(building.getPriority().toString());
        priorityText.setStyle("-fx-text-fill: " + building.getPriority().getColor());
        priorityImage.setImage(building.getPriority().getImage());
    }

    public void focus() {
        nameText.setStyle("-fx-underline: true");
    }

    public void blur() {
        nameText.setStyle("-fx-underline: false");
    }
}
