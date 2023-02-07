package lk.ijse.encoreDecore.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.model.EmployeeModel;
import lk.ijse.encoreDecore.model.EventModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.tm.EventTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;
import lk.ijse.encoreDecore.util.SceneNavigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    public AnchorPane pane;
    public AnchorPane subPane;
    public TableView<EventTm> tblEvent;
    public TableColumn colEvent;
    public TableColumn colNumberOfOrders;
    public TableColumn colIncome;
    public Label lblCustomers;
    public Label lblOrders;

    public void btnEmployeesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,subPane);
    }

    public void btnpackagesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PACKAGE,subPane);
    }

    public void btnSalaryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SALARY,subPane);
    }

    public void btnAccountOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ACCOUNT,subPane);
    }
    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,subPane);
    }
    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        SceneNavigation.navigate(Routes.LOGIN,pane);
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEvent.setCellValueFactory(new PropertyValueFactory<>("event"));
        colNumberOfOrders.setCellValueFactory(new PropertyValueFactory<>("orders"));
        colIncome.setCellValueFactory(new PropertyValueFactory<>("income"));

        try {
            ArrayList<EventTm> events = EventModel.loadEvents();
            ObservableList observableList = FXCollections.observableArrayList(events);
            tblEvent.setItems(observableList);

            int orders = EventModel.getOders();
            lblOrders.setText(String.valueOf(orders));

            int customers= EventModel.getCustomers();
            lblCustomers.setText(String.valueOf(customers));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
