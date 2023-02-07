package lk.ijse.encoreDecore.controller.recep;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.AvailabilityModel;
import lk.ijse.encoreDecore.model.PaymentDetailsModel;
import lk.ijse.encoreDecore.tm.AvailabilityTm;
import lk.ijse.encoreDecore.tm.PaymentDetailsTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentDetailsFormController {
    @FXML
    private  AnchorPane pane;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<PaymentDetailsTm> tbelPaymentDetails;

    @FXML
    private TableColumn<?, ?> colInvoiceNo;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colCusName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colTotalAmount;

    @FXML
    private TableColumn<?, ?> colAmountPaid;

    @FXML
    private TableColumn<?, ?> colRemainingAmount;


    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/recep/AddPaymentForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();


    }

   static ObservableList observableList;


    public void initialize() {
       table();
    }
    public void table(){
        colInvoiceNo.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTotalAmount.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAmountPaid.setCellValueFactory(new PropertyValueFactory<>("paid"));
        colRemainingAmount.setCellValueFactory(new PropertyValueFactory<>("remaining"));

        ArrayList<PaymentDetailsTm> paymentDetails = PaymentDetailsModel.loadPayments();
        observableList = FXCollections.observableArrayList(paymentDetails);
        tbelPaymentDetails.setItems(observableList);
        setTxtSearch();
    }

    private void setTxtSearch() {
        FilteredList<PaymentDetailsTm> filteredList = new FilteredList(observableList, b -> true);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(paymentDetailsTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (paymentDetailsTm.getCusId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (paymentDetailsTm.getCusName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(paymentDetailsTm.getTotal()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        SortedList<PaymentDetailsTm> sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tbelPaymentDetails.comparatorProperty());
        tbelPaymentDetails.setItems(sortedList);
    }

    public void txtSearchOnKeyrelease(KeyEvent keyEvent) {

    }
}
