package lk.ijse.encoreDecore.controller.recep;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.model.CustomerModel;
import lk.ijse.encoreDecore.to.Customer;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    public ToggleGroup Gender;
    public AnchorPane pane;
    public JFXTextField txtFName;
    public JFXTextField txtLName;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXRadioButton rbMale;
    public JFXRadioButton rvFemale;
    public Spinner<Integer> spinner;
    public Label lblId;

    public static String clientId;
    public void btnContinueOnAction(ActionEvent actionEvent) throws IOException {
            String name= txtFName.getText()+" "+txtLName.getText();
            String nic = txtNic.getText();
            String address=txtAddress.getText();
            String contact = txtContact.getText();
            String email = txtEmail.getText();
            String gender = null;
            if(rbMale.isSelected()){
                gender ="male";
            } else if (rvFemale.isSelected()) {
                gender="female";
            }
            String age= String.valueOf(spinner.getValue());
            String id = lblId.getText();

        Customer customer = new Customer(id,name,nic,email,address,contact,gender,age);

        try {
            int number = Integer.parseInt(CustomerModel.getClientId().substring(1));

            if(number<Integer.parseInt(lblId.getText().substring(1))){
                boolean isAdded = CustomerModel.save(customer);
                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                }
            }

            clientId=lblId.getText();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Navigation.navigate(Routes.WEDDING_PLACE_ORDER, pane);
    }
    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AVAILABILITY, pane);
    }

    public void txtNicSearchOnAction(ActionEvent actionEvent) {
        try {
            Customer customer= CustomerModel.search(txtNic.getText());

            String[] splited = customer.getName().split(" ");

            lblId.setText(customer.getId());
            txtFName.setText(splited[0]);
            txtLName.setText(splited[1]);
            txtEmail.setText(customer.getEmail());
            txtAddress.setText(customer.getAddress());
            txtContact.setText(customer.getContact());
            if(customer.getGender().equals("male")){
                rbMale.setSelected(true);
            }else {
                rvFemale.setSelected(true);
            }
            SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,120);
            valueFactory.setValue(Integer.valueOf(customer.getAge()));
            spinner.setValueFactory(valueFactory);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,120);
        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);

        int number= 0;
        try {
             String[] split = CustomerModel.getClientId().split("C");
            number = Integer.parseInt(split[1]);
            String id=null;
            number++;

            if(10>number){
                id= "C00"+ number;
            } else if (100>number) {
                id= "C0"+ number;
            }else{
                id="C"+ number;
            }

            lblId.setText(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
