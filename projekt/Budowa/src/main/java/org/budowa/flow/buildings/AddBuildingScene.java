package org.budowa.flow.buildings;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.budowa.entities.*;
import org.budowa.services.BuildingsService;
import org.budowa.services.UsersService;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddBuildingScene implements Initializable {

    private final UsersService usersService = UsersService.inject();
    private final BuildingsService buildingsService = BuildingsService.inject();
    private ArrayList<User> managers;
    private Building building = new Building();

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
    private TextArea textAreaDescription;

    @FXML
    private TextArea textAreaAdditionalNotes;

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
        buildingsService.add(building);
    }

    private void setup() {
        managers = usersService.getByRole(UserRole.MANAGER);
        Object[] menuItems =  managers.stream()
                .map(manager -> manager.getFullName())
                .toArray();
        choiceBoxManager.getItems().setAll(menuItems);
        choiceBoxPriority.getItems().setAll(BuildingPriority.values());
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
