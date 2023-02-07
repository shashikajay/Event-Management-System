package lk.ijse.encoreDecore.controller.recep;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.OrderModel;
import lk.ijse.encoreDecore.tm.SelectedServicesTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static lk.ijse.encoreDecore.controller.recep.PaymentDetailsFormController.observableList;

public class OrderDetailsFormController implements Initializable {
    public Label lblOrderId;
    public TableView<SelectedServicesTm> tblOrderDetails;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colPrice;
    public AnchorPane pane;

    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String id = OrderFormController.orderId;
        lblOrderId.setText(id);

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<SelectedServicesTm> orderArray = new ArrayList<>();
        try {
            orderArray = OrderModel.loadOrderDetails(id);
            observableList = FXCollections.observableArrayList(orderArray);
            tblOrderDetails.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
