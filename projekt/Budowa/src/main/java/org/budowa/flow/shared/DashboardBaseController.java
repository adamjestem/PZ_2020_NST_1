package org.budowa.flow.shared;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import org.budowa.App;
import org.budowa.entities.Building;
import org.budowa.entities.BuildingStatus;
import org.budowa.flow.kanban.KanbanController;
import org.budowa.flow.kanban.KanbanItemController;
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
        try {
            this.kanbanController.toDoList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.TODO));
            this.kanbanController.foundationList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.FOUNDATIONS));
            this.kanbanController.wallsList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.WALLS));
            this.kanbanController.ceilingList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.CEILING));
            this.kanbanController.roofList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.ROOF));
            this.kanbanController.doneList.getItems().setAll(this.getBuildingNodes(buildings, BuildingStatus.DONE));
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.ERROR_LOADING_BUILDINGS);
        }
    }

    private Node[] getBuildingNodes(Building[] buildings, BuildingStatus status) throws IOException {
        var filteredBuildings = new ArrayList<Node>();
        for (var building : buildings) {
            if (building.getStatus() != status) {
                continue;
            }
            filteredBuildings.add(getBuildingNode(building));
        }
        return filteredBuildings.toArray(Node[]::new);
    }

    private Node getBuildingNode(Building building) throws IOException {
        var controller = new KanbanItemController(building);
        var loader = new FXMLLoader(App.class.getResource("KanbanItem.fxml"));
        loader.setController(controller);
        Node node = loader.load();
        node.setCursor(Cursor.HAND);
        node.setOnMouseClicked(mouseEvent -> {
            try {
                this.router.goToBuildingDetail(building.getId());
            } catch (IOException e) {
                this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
            }
        });

        return node;
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
        } catch (NullPointerException ignored) {
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }
}
