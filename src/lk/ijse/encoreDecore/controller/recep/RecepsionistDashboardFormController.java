package lk.ijse.encoreDecore.controller.recep;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.model.AvailabilityModel;
import lk.ijse.encoreDecore.tm.AvailabilityTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;
import lk.ijse.encoreDecore.util.SceneNavigation;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RecepsionistDashboardFormController implements Initializable {
    public AnchorPane pane;
    public AnchorPane availabilityPane;
    public TableView tblOrder;
    public TableColumn colDate;
    public TableColumn colName;
    public TableColumn colEvent;
    public JFXDatePicker dateSearch;

    public void btnServiceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SERVICE,availabilityPane);
    }
    public void btnOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDER,availabilityPane);
    }
    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT_DETAILS,availabilityPane);
    }
    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER,pane);
    }
    public void calendarOnAction(ActionEvent actionEvent) {
        LocalDate date = dateSearch.getValue();


    }
    public void AvailabilityOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AVAILABILITY,pane);
    }
    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        SceneNavigation.navigate(Routes.LOGIN, pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEvent.setCellValueFactory(new PropertyValueFactory<>("event"));

        ArrayList<AvailabilityTm> orders = AvailabilityModel.loadOrders();
        ObservableList observableList = FXCollections.observableArrayList(orders);
        tblOrder.setItems(observableList);
        System.out.println(orders);
    }
}
