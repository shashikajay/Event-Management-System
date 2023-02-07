package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.AddEmployeeModel;
import lk.ijse.encoreDecore.model.EmployeeModel;
import lk.ijse.encoreDecore.model.PaymentDetailsModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.tm.PaymentDetailsTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colconatact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colSalary;



    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove employee Confirmation");
        alert.setHeaderText("Please Confirm!");
        alert.setContentText("Are you sure want to remove empoyee with id "+id+" ?!");

        Optional<ButtonType> result = alert.showAndWait ();
        if(result.get()==ButtonType.OK){
            try {
                boolean isRemoved = AddEmployeeModel.removeEmployee(id);
                if(isRemoved){

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }



    }


    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/AddEmployeeForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/UpdateEmployeeForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }



        static ObservableList observableList;
        public void initialize() {
        try {
            colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
            colconatact.setCellValueFactory(new PropertyValueFactory<>("contact"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

            ArrayList<EmployeeTm> employeeList = EmployeeModel.loadEmployees();
             observableList = FXCollections.observableArrayList(employeeList);
            tblEmployee.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setTxtSearch();
    }

    private void setTxtSearch() {
        FilteredList<EmployeeTm> filteredList = new FilteredList(observableList, b -> true);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(employeeTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (employeeTm.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (employeeTm.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (employeeTm.getNic().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (employeeTm.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else {
                    return false;
                }
            });
        });

        SortedList<EmployeeTm> sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tblEmployee.comparatorProperty());
        tblEmployee.setItems(sortedList);
    }

    static String id;
    public void selectRowOnMouseClick(MouseEvent mouseEvent) {
        EmployeeTm employee = tblEmployee.getSelectionModel().getSelectedItem();
        id=employee.getId();

    }
}
