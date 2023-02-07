package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.AddEmployeeModel;
import lk.ijse.encoreDecore.tm.EmployeeTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateEmployeeFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtcontact;

    @FXML
    private JFXTextField txtRole;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private JFXTextField txtId;


    @FXML
    void txtIdOnAction(ActionEvent event) {

    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name=txtName.getText();
        String nic= txtNic.getText();
        String email = txtEmail.getText();
        String contact = txtcontact.getText();
        String role = txtRole.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        EmployeeTm employee = new EmployeeTm(id, name, nic,contact,email,role,salary);

        try {
            if(employee!=null) {
                boolean isUpdated = AddEmployeeModel.updateEmployee(employee);

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
        String id=EmployeeFormController.id;
        txtId.setText(id);

        try {
            EmployeeTm employee = AddEmployeeModel.loadEmployee(id);

            txtName.setText(employee.getName());
            txtNic.setText(employee.getNic());
            txtRole.setText(employee.getRole());
            txtcontact.setText(employee.getContact());
            txtEmail.setText(employee.getEmail());
            txtSalary.setText(String.valueOf(employee.getSalary()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
