package lk.ijse.encoreDecore.controller.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.model.LoginModel;
import lk.ijse.encoreDecore.to.User;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;
import lk.ijse.encoreDecore.util.SceneNavigation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public AnchorPane pane;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;
    public JFXTextField txtpass;
    public ImageView image;
    public ImageView hideIcon;
    public ImageView eyeIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtpass.setVisible(false);
        eyeIcon.setVisible(false);
    }

    public void btnFogetOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGET,pane);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        SceneNavigation.navigate(Routes.AVAILABILITY,pane);

        String name=txtName.getText();
        String password=txtPassword.getText();

        try {
            ArrayList<User> userList = LoginModel.getUsers();
            String role=null;

            System.out.println(userList);
            for (User user:userList) {
                if(user.getName().equals(name) && user.getPasswrod().equals(password)){
                    role=user.getRole();
                }
            }
            System.out.println(role);

            if(role==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
                alert.setTitle("Incorrect Password");// line 2
                alert.setHeaderText("Invalid User Name or Password!");// line 3
                alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
                alert.showAndWait(); // line 5
            } else if (role.equals("receptionist")) {
                SceneNavigation.navigate(Routes.AVAILABILITY,pane);
            } else if (role.equals("admin") ){
                SceneNavigation.navigate(Routes.DASHBOARD,pane);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean visibility=false;
    public void btnShowPassowrd(ActionEvent actionEvent) {
        if(!visibility){
            eyeIcon.setVisible(true);
            hideIcon.setVisible(false);
            txtpass.setText(txtPassword.getText());
            txtpass.setVisible(true);
            txtPassword.setVisible(false);
            visibility=true;
        }else{
            eyeIcon.setVisible(false);
            hideIcon.setVisible(true);
            txtPassword.setText(txtpass.getText());
            txtPassword.setVisible(true);
            txtpass.setVisible(false);
            visibility=false;
        }

    }
}
