package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.SalaryModel;
import lk.ijse.encoreDecore.tm.SalaryTm;
import lk.ijse.encoreDecore.to.Salary;
import sun.util.resources.LocaleData;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddSalaryFormController implements Initializable {

    public ImageView mouseClick;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXComboBox cmbMonth;

    @FXML
    private JFXTextField txtId;

    @FXML
    private Label lblName;

    @FXML
    private JFXTextField lblAmount;



    @FXML
    void searchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            SalaryTm salary = SalaryModel.searchSalary(id);
            lblName.setText(salary.getName());
            lblAmount.setText(String.valueOf(salary.getAmount()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        searchOnAction(event);

    }

    public void btnContinueOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        double amount= Double.parseDouble(lblAmount.getText());
        String date= String.valueOf(LocalDate.now());
        String month = (String) cmbMonth.getValue();

        Salary salary = new Salary(id, amount,date,month);

        if(salary!=null){
            try {
                boolean isAdded = SalaryModel.addSalary(salary);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
            alert.setTitle("some text fields are empty");// line 2
            alert.setHeaderText("Invalid User Name or Password!");// line 3
            alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
            alert.showAndWait(); // line 5
        }


        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbMonth.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }
}
