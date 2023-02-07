package lk.ijse.encoreDecore.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneNavigation {
    static Stage stage;
        public static void navigate(Routes route, AnchorPane pane) throws IOException {
            stage = (Stage) pane.getScene().getWindow();
            switch (route) {
                case LOGIN:
                    stage.setTitle("Customer Manage Form");
                    setUi("login/LoginForm.fxml");
                    stage.centerOnScreen();
                    break;
                case AVAILABILITY:
                    stage.setTitle("Availability Form");
                    setUi("recep/RecepsionistDashboardForm.fxml");
                    stage.setMaximized(true);
                    break;
                case DASHBOARD:
                    stage.setTitle("Overview Form");
                    setUi("admin/DashBoardForm.fxml");
                    stage.setMaximized(true);
                    break;

                default:
                    new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
            }
        }
        private static void setUi(String location) throws IOException {
            stage.setScene(new Scene(FXMLLoader.load(SceneNavigation.class.getResource( "/lk/ijse/encoreDecore/view/"+location ))));
            stage.show();
        }
}
