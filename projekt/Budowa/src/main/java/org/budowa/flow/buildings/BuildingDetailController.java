package org.budowa.flow.buildings;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.entities.UserRole;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.*;
import org.budowa.texts.Translations;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuildingDetailController implements Initializable {

    //region injectables
    private final BuildingsService buildingsService = BuildingsService.inject();

    private final UsersService usersService = UsersService.inject();
    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();
    private final SessionManager sessionManager = SessionManager.inject();
    private final PdfBuilder pdfBuilder = PdfBuilder.inject();
    //endregion

    // region template controls
    public Label title;
    public Label description;
    public VBox workers;
    public Label managerName;
    public Label priority;
    public Label status;
    public Button returnButton;
    public Button deleteButton;
    public Button editButton;
    public Label startDate;
    public Label endDate;
    //endregion

    public static int selectedBuildingId;
    private Building building;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        building = this.buildingsService.getById(BuildingDetailController.selectedBuildingId);
        this.setTitle(building);
        this.setDescription(building);
        this.setStatus(building);
        this.setPriority(building);
        this.setManagerName(building);
        this.setDates(building);
        this.setWorkers(building);
        if (this.sessionManager.getLoggedInUser().getUserRole() == UserRole.OWNER) {
            this.deleteButton.setStyle("visibility: visible");
            this.editButton.setStyle("visibility: visible");
            this.deleteButton.setOnMouseClicked(event -> {
                try {
                    var decision = dialogService.showConfirmDialog("Czy na pewno chcesz usunąć budynek " + building.getName());
                    if (decision.isPresent() && decision.get() == ButtonType.OK) {
                        this.buildingsService.delete(building);
                        dialogService.showInfoDialog("Budynek usunięty");
                        this.router.goTo(Route.DASHBOARD);
                    }
                } catch (IOException exception) {
                    dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
                }
            });
        }

        this.returnButton.setOnMouseClicked(event -> {
            try {
                this.router.goTo(Route.DASHBOARD);
            } catch (IOException exception) {
                dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
            }
        });
    }

    public void editAction() {
        var building = this.buildingsService.getById(BuildingDetailController.selectedBuildingId);
        try {
            router.goToEditBuildingDetail(building.getId());
        } catch (IOException e) {
            dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
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
        this.managerName.setText(this.getManagerName(building.getManager()));
    }

    private void setWorkers(Building building) {
        var workers = building.getWorkers().toArray(new User[0]);
        for (var worker : workers) {
            var label = new Label(worker.getFullName());
            label.setFont(Font.font("System", FontWeight.BOLD, 14));
            this.workers.getChildren().add(label);
        }
    }

    private void setDates(Building building) {
        this.startDate.setText(this.getDataValue(building.getStartDate()));
        this.endDate.setText(this.getDataValue(building.getEndDate()));
    }

    public void printRaport(ActionEvent mouseEvent) {
        try {
            pdfBuilder.create(this.building.getName())
                    .addDataBlock("Nazwa budynku:", building.getName())
                    .addDataBlock("Status:", this.building.getStatus().toString())
                    .addDataBlock("Priorytet:", this.building.getPriority().toString())
                    .addDataBlock("Data dodania:", this.getDataValue(this.building.getStartDate()))
                    .addDataBlock("Data zakończenia:", this.getDataValue(this.building.getEndDate()))
                    .addDataBlock("Kierownik:", this.getManagerName(building.getManager()))
                    .addList("Pracownicy:", this.building.getWorkers().stream().map(User::getFullName).toArray(String[]::new))
                    .addDataBlock("Opis:", this.building.getDescription())
                    .save();

            this.dialogService.showInfoDialog(Translations.SUCCESSFULLY_SAVED_PDF);
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    private String getManagerName(User manager) {
        return manager != null ? manager.getFullName() : "Nieprzypisany";
    }

    private String getDataValue(String date) {
        return date == null || date.equals("") ? "Brak" : date;
    }
}
