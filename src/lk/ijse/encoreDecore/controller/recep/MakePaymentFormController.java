package lk.ijse.encoreDecore.controller.recep;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.controller.recep.placeOrder.PlaceOrderFormController;

import java.io.IOException;

public class MakePaymentFormController extends PlaceOrderFormController {

    public AnchorPane pane;
    public void btnPayOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
