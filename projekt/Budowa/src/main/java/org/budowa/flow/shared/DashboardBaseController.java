package org.budowa.flow.shared;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;
import org.budowa.flow.kanban.KanbanController;
import org.budowa.router.Router;
import org.budowa.services.DialogService;
import org.budowa.services.PdfBuilder;
import org.budowa.texts.Translations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public abstract class DashboardBaseController implements Initializable {

    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();
    private final PdfBuilder pdfBuilder = PdfBuilder.inject();

    @FXML
    public KanbanController kanbanController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setBuildings(this.loadBuildings());
    }

    protected abstract Building[] loadBuildings();

    public void setBuildings(Building[] buildings) {
        this.kanbanController.toDoList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.TODO));
        this.kanbanController.foundationList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.FOUNDATIONS));
        this.kanbanController.wallsList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.WALLS));
        this.kanbanController.ceilingList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.CEILING));
        this.kanbanController.roofList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.ROOF));
        this.kanbanController.doneList.getItems().setAll(this.getFilteredLabels(buildings, BuildingStatus.DONE));
    }

    private Label[] getFilteredLabels(Building[] buildings, BuildingStatus status) {
        var filteredBuildings = new ArrayList<Label>();
        for (var building : buildings) {
            if (building.getStatus() != status) {
                continue;
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
            try {
                this.router.goToBuildingDetail(building.getId());
            } catch (IOException e) {
                this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
            }
        });
        return label;
    }

    protected void printRaport(String title) {
        try {
            var buildings = this.loadBuildings();

            var builder = this.pdfBuilder.create(title).addText(title).addEmptyLine();
            for (var building : buildings) {
                builder = builder.addDataBlock("Nazwa:", building.getName())
                        .addDataBlock("Status:", building.getStatus().toString())
                        .addEmptyLine();
            }
            builder.save();
            this.dialogService.showInfoDialog(Translations.SUCCESSFULLY_SAVED_PDF);
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }
}
