package lk.ijse.encoreDecore.controller.recep.services;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.controller.recep.ServicesFormController;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServiceDetailsFormController {
    public AnchorPane pane;
    public AnchorPane servicePane;

    public void btnWeddingOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.WEDDING,servicePane);
    }

    public void btnBirthdayOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BIRTHDAY,servicePane);
    }

    public void btnBatchReuniOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BATCH_REUNION,servicePane);
    }

    public void btnAnniversaryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ANNIVERSARY,servicePane);
    }

    public void btnBabyShowerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.BABY_SHOWER,servicePane);
    }

    public void btnCustomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOM_PARTY,servicePane);
    }

    public void initialize() {
//        try {
//            switch (ServicesFormController.formName) {
//                case "Anniversary":
//                    Navigation.navigate(Routes.ANNIVERSARY, servicePane);
//                    break;
//                case "Baby Shower":
//                    Navigation.navigate(Routes.BABY_SHOWER, servicePane);
//                    break;
//                case "Batch Reunion":
//                    Navigation.navigate(Routes.BATCH_REUNION, servicePane);
//                    break;
//                case "Birthday":
//                   Navigation.navigate(Routes.BIRTHDAY, servicePane);
//                    break;
//                case "Custom":
//                    Navigation.navigate(Routes.CUSTOM_PARTY, servicePane);
//                    break;
//                case "Wedding":
//                    Navigation.navigate(Routes.WEDDING,servicePane);
//                    break;
//
//                }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
