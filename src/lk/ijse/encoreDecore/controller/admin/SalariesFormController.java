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
import lk.ijse.encoreDecore.model.SalaryModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.tm.SalaryTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class SalariesFormController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<SalaryTm> tblSalary;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colMonth;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove employee Confirmation");
        alert.setHeaderText("Please Confirm!");
        alert.setContentText("Are you sure want to remove empoyee with id "+id+" ?!");

        Optional<ButtonType> result = alert.showAndWait ();
        if(result.get()==ButtonType.OK){
            try {
                boolean isRemoved = SalaryModel.removeSalary(id,date);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/AddSalaryForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }

    public void btnDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/SalaryDetailsForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }

    static String id;
    static String date;
    public void selectedRow(MouseEvent mouseEvent) {
        SalaryTm salaryTm = tblSalary.getSelectionModel().getSelectedItem();
        id=salaryTm.getId();
        date = salaryTm.getDate();
    }
    static ObservableList observableList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));

        ArrayList<SalaryTm> salaryList = null;
        try {
            salaryList = SalaryModel.loadSalary();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

         observableList = FXCollections.observableArrayList(salaryList);
        tblSalary.setItems(observableList);
        setTxtSearch();
    }
        private void setTxtSearch() {
            FilteredList<SalaryTm> filteredList = new FilteredList(observableList, b -> true);

            txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(salaryTm -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (salaryTm.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (salaryTm.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (salaryTm.getNic().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }else {
                        return false;
                    }
                });
            });

            SortedList<SalaryTm> sortedList = new SortedList(filteredList);
            sortedList.comparatorProperty().bind(tblSalary.comparatorProperty());
            tblSalary.setItems(sortedList);
        }

    }
