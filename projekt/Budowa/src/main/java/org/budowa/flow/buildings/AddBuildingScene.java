package org.budowa.flow.buildings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.budowa.entities.*;
import org.budowa.router.Route;
import org.budowa.router.Router;
import org.budowa.services.BuildingsService;
import org.budowa.services.DialogService;
import org.budowa.services.UsersService;
import org.budowa.texts.Translations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBuildingScene implements Initializable {

    private final UsersService usersService = UsersService.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private ArrayList<User> managers;
    private ArrayList<User> workers;
    private ArrayList<User> selectedWorkers = new ArrayList<>();
    private  Object[] managersItems;
    private  Object[] workersItems;
    private ObservableList<String> selectedWorkersNames;
    private Building building = new Building();
    private final Router router = Router.inject();
    private final DialogService dialogService = DialogService.inject();

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldCustomer;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private DatePicker datePickerStartDate;

    @FXML
    private DatePicker datePickerEndDate;

    @FXML
    private ChoiceBox choiceBoxPriority;

    @FXML
    private ChoiceBox choiceBoxManager;

    @FXML
    private ChoiceBox choiceBoxWorkers;

    @FXML
    private Button addWorkerButton;

    @FXML
    private ListView<String> workersList;

    @FXML
    private TextArea textAreaDescription;

    @FXML
    private TextArea textAreaAdditionalNotes;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setup();
    }

    @FXML
    private void controlAction() {
        removeErrorFrom(textFieldName);
        removeErrorFrom(textFieldCustomer);
        removeErrorFrom(textFieldAddress);
        removeErrorFrom(datePickerStartDate);
        removeErrorFrom(datePickerEndDate);
        removeErrorFrom(choiceBoxPriority);
        removeErrorFrom(choiceBoxManager);
        removeErrorFrom(textAreaDescription);
        removeErrorFrom(textAreaAdditionalNotes);
    }

    @FXML
    private void backButtonAction () {
        back();
    }

    @FXML
    private void addWorkerAction() {
        selectedWorkersNames.add(workers.get(choiceBoxWorkers.getSelectionModel().getSelectedIndex()).getFullName());
        selectedWorkers.add(workers.get(choiceBoxWorkers.getSelectionModel().getSelectedIndex()));
        workers.removeAll(selectedWorkers);
        mapToItems();
        choiceBoxWorkers.getItems().setAll(workersItems);
    }

    @FXML
    private void buttonAddAction() {
        if (!isValid()) { return; }
        building.setName(textFieldName.getText());
        building.setCustomer(textFieldCustomer.getText());
        building.setAddress(textFieldAddress.getText());
        building.setDescription(textAreaDescription.getText());
        building.setAdditionalNotes(textAreaAdditionalNotes.getText());
        building.setManager(managers.get(choiceBoxManager.getSelectionModel().getSelectedIndex()));
        building.setStartDate(datePickerStartDate.getValue().toString());
        building.setEndDate(datePickerEndDate.getValue().toString());
        building.setStatus(BuildingStatus.FOUNDATIONS);
        building.setPriority(BuildingPriority.values()[choiceBoxPriority.getSelectionModel().getSelectedIndex()]);
        building.setWorkers(selectedWorkers);
        buildingsService.add(building);
        back();
    }

    private void setup() {
        selectedWorkersNames = FXCollections.observableArrayList();
        workersList.setItems(selectedWorkersNames);
        managers = usersService.getByRole(UserRole.MANAGER);
        workers = usersService.getByRole(UserRole.WORKER);
        mapToItems();
        choiceBoxManager.getItems().setAll(managersItems);
        choiceBoxPriority.getItems().setAll(BuildingPriority.values());
        choiceBoxWorkers.getItems().setAll(workersItems);
    }

    private boolean isValid() {
        boolean isValid = true;
        if (isTextValid(textFieldName.getText())) {
            setErrorFor(textFieldName);
            isValid = false;
        }

        if (isTextValid(textFieldCustomer.getText())) {
            setErrorFor(textFieldCustomer);
            isValid = false;
        }

        if (isTextValid(textFieldAddress.getText())) {
            setErrorFor(textFieldAddress);
            isValid = false;
        }

        if (choiceBoxPriority.getValue() == null) {
            setErrorFor(choiceBoxPriority);
            isValid = false;
        }

        if (choiceBoxManager.getValue() == null) {
            setErrorFor(choiceBoxManager);
            isValid = false;
        }

        if (datePickerStartDate.getValue() == null) {
            setErrorFor(datePickerStartDate);
            isValid = false;
        }

        if (datePickerEndDate.getValue() == null) {
            setErrorFor(datePickerEndDate);
            isValid = false;
        }

        if (datePickerEndDate.getValue().isBefore(datePickerStartDate.getValue())) {
            dialogService.showErrorDialog("Invalid Date. End date should be after Start Date");
            setErrorFor(datePickerEndDate);
            isValid = false;
        }

        return isValid;
    }

    private boolean isTextValid(String text) {
        return text == null || text.isEmpty();
    }

    private void back() {
        try {
            this.router.goTo(Route.DASHBOARD);
        } catch (IOException exception) {
            dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    private void mapToItems() {
        managersItems =  managers.stream()
                .map(manager -> manager.getFullName())
                .toArray();
        workersItems =  workers.stream()
                .map(worker -> worker.getFullName())
                .toArray();
    }

    private void setErrorFor(Control control) {
        control.setStyle("" +
                "-fx-border-color: red; " +
                "-fx-border-width: 1px; " +
                "-fx-border-radius: 2px; "
        );
    }

    private void removeErrorFrom(Control control) {
        control.setStyle(null);
    }
}
