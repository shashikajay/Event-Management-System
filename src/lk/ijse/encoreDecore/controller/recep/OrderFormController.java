package lk.ijse.encoreDecore.controller.recep;

import com.jfoenix.controls.JFXDatePicker;
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
import lk.ijse.encoreDecore.model.OrderModel;
import lk.ijse.encoreDecore.model.PaymentDetailsModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.tm.OrderTm;
import lk.ijse.encoreDecore.tm.PaymentDetailsTm;
import lk.ijse.encoreDecore.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class OrderFormController {
    public AnchorPane pane;
    public JFXTextField txtSearch;
    public JFXDatePicker datePicker;

    @FXML
    private TableView<OrderTm> tblOrder;

    @FXML
    private TableColumn<?, ?> colOId;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colEventDate;

    @FXML
    private TableColumn<?, ?> colEventType;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPaidAmount;

    @FXML
    private TableColumn<?, ?> colRemainingamount;

    public void btnDetails(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/recep/OrderDetailsForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }

    public void btnRemove(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove order Confirmation");
        alert.setHeaderText("Please Confirm!");
        alert.setContentText("Are you sure want to remove empoyee with id "+orderId+" ?!");

        Optional<ButtonType> result = alert.showAndWait ();
//        if(result.get()==ButtonType.OK){
//            try {
//                boolean isRemoved = OrderModel.removeOrder(orderId);
//                if(isRemoved){
//
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    static String orderId;
    public void rowOnMouseClick(MouseEvent mouseEvent) {
        OrderTm orderTm = tblOrder.getSelectionModel().getSelectedItem();
        orderId=orderTm.getOrderId();
    }

    public void setcol(){
        colOId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colEventDate.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        colEventType.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPaidAmount.setCellValueFactory(new PropertyValueFactory<>("paidAmount"));
    }

    static ArrayList<OrderTm> orderArray= new ArrayList<>();
    static ObservableList observableList;

    public void initialize() {
        setcol();
        try {
            orderArray = OrderModel.loadOrders();
            observableList = FXCollections.observableArrayList(orderArray);
            tblOrder.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        setTxtSearch();
        searchDate();
    }
    private void setTxtSearch() {
        FilteredList<OrderTm> filteredList = new FilteredList(observableList, b -> true);
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(orderTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (orderTm.getOrderId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderTm.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderTm.getNic().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderTm.getEventType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<OrderTm> sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tblOrder.comparatorProperty());
        tblOrder.setItems(sortedList);
    }

    private void searchDate() {
        FilteredList<OrderTm> filteredList = new FilteredList(observableList, b -> true);
        datePicker.accessibleTextProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(orderTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (orderTm.getOrderDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderTm.getEventDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<OrderTm> sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tblOrder.comparatorProperty());
        tblOrder.setItems(sortedList);
    }

}
