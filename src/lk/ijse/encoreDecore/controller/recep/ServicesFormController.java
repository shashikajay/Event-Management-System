package lk.ijse.encoreDecore.controller.recep;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;

public class ServicesFormController {
    @FXML
    private AnchorPane pane;

    public static String formName;
    @FXML
    void btnAnniversaryOnAction(ActionEvent event) throws IOException {
        formName="Anniversary";
        Navigation.navigate(Routes.ANNIVERSARY_SERVICE_DETAILS,pane);
    }

    @FXML
    void btnBabyShowerOnAction(ActionEvent event) throws IOException {
        formName="Baby Shower";
        Navigation.navigate(Routes.BABY_SHOWER_SERVICE_DETAILS,pane);
    }

    @FXML
    void btnBatchReunionOnAction(ActionEvent event) throws IOException {
        formName="Batch Reunion";
        Navigation.navigate(Routes.BATCH_REUNION_SERVICE_DETAILS,pane);
    }

    @FXML
    void btnBirthdayOnAction(ActionEvent event) throws IOException {
        formName="Birthday";
        Navigation.navigate(Routes.BIRTHDAY_SERVICE_DETAILS,pane);
    }

    @FXML
    void btnCustomOnAction(ActionEvent event) throws IOException {
        formName="Custom";
        Navigation.navigate(Routes.CUSTOM_PARTY_SERVICE_DETAILS,pane);
    }

    @FXML
    void btnWeddingOnAction(ActionEvent event) throws IOException {
        formName="Wedding";
        Navigation.navigate(Routes.WEDDING_SERVICE_DETAILS,pane);

    }
}
