package lk.ijse.encoreDecore.controller.admin;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SalaryDetailsFormController {
    public AnchorPane pane;

    public void btnOkOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
