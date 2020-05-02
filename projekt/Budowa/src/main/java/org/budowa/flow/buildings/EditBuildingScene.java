package org.budowa.flow.buildings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.budowa.entities.*;
import org.budowa.router.Router;
import org.budowa.services.BuildingsService;
import org.budowa.services.DialogService;
import org.budowa.services.UsersService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.util.stream.Collectors.toCollection;

public class EditBuildingScene implements Initializable {

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
    public static int selectedBuildingId;

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
        reloadWorkers();
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
        building.setManagerId(managers.get(choiceBoxManager.getSelectionModel().getSelectedIndex()).getId());
        building.setStartDate(datePickerStartDate.getValue().toString());
        building.setEndDate(datePickerEndDate.getValue().toString());
        building.setStatus(BuildingStatus.FOUNDATIONS);
        building.setPriority(BuildingPriority.values()[choiceBoxPriority.getSelectionModel().getSelectedIndex()]);
        building.setWorkers(selectedWorkers);
        buildingsService.update(building);
        back();
    }

    private void setup() {
        building = buildingsService.getById(selectedBuildingId);
        selectedWorkersNames = FXCollections.observableArrayList();
        workersList.setItems(selectedWorkersNames);
        managers = usersService.getByRole(UserRole.MANAGER);
        workers = usersService.getByRole(UserRole.WORKER);
        mapToItems();
        choiceBoxManager.getItems().setAll(managersItems);
        choiceBoxPriority.getItems().setAll(BuildingPriority.values());
        choiceBoxWorkers.getItems().setAll(workersItems);
        setupBuildingInfo();
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

        return isValid;
    }

    private boolean isTextValid(String text) {
        return text == null || text.isEmpty();
    }

    private void setupBuildingInfo() {
        textFieldName.setText(building.getName());
        textFieldCustomer.setText(building.getCustomer());
        textFieldAddress.setText(building.getAddress());
        datePickerStartDate.setValue(LocalDate.parse(building.getStartDate()));
        datePickerEndDate.setValue(LocalDate.parse(building.getEndDate()));
        choiceBoxPriority.setValue(building.getPriority());
        choiceBoxManager.setValue(building.getManager().getFullName());
        textAreaDescription.setText(building.getDescription());
        textAreaAdditionalNotes.setText(building.getAdditionalNotes());
        selectedWorkers = building.getWorkers().stream().collect(toCollection(ArrayList::new));
        selectedWorkers.forEach( worker -> selectedWorkersNames.add(worker.getFullName()));
        reloadWorkers();
    }

    private void back() {
        try {
            this.router.goToBuildingDetail(selectedBuildingId);
        } catch (IOException exception) {
            dialogService.showErrorDialog("Coś poszło nie tak");
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

    private void reloadWorkers() {
        workers.removeAll(selectedWorkers);
        mapToItems();
        choiceBoxWorkers.getItems().setAll(workersItems);
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
