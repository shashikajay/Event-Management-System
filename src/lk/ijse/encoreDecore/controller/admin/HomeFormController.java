package lk.ijse.encoreDecore.controller.admin;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;

public class HomeFormController {
    public AnchorPane pane;
    public AnchorPane servicePane;
    public AnchorPane availabilityPane;

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, pane);
    }

    public void btnWeddingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.WEDDING, servicePane);
    }
}
