package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.AddEmployeeModel;
import lk.ijse.encoreDecore.model.CustomerModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEmployeeFormController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtRole;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private Label lblId;

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = lblId.getText();
        String name=txtName.getText();
        String nic= txtNic.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String role = txtRole.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        EmployeeTm employee = new EmployeeTm(id, name, nic,contact,email,role,salary);

        try {
            if(employee!=null) {
                boolean isAdded = AddEmployeeModel.addEmployee(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String[] split = AddEmployeeModel.getId().split("E");
            int number = Integer.parseInt(split[1]);
            String id=null;
            number++;

            if(10>number){
                id= "E00"+ number;
            } else if (100>number) {
                id= "E0"+ number;
            }else{
                id="E"+ number;
            }

            lblId.setText(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
