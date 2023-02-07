package lk.ijse.encoreDecore;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/encoreDecore/view/login/LoginForm.fxml"))));
        primaryStage.setTitle("Login Form");
        primaryStage.centerOnScreen();
      //  primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/lk/ijse/encoreDecore/assets/logo/CompanyLogo.png")));
        primaryStage.show();
    }
}
