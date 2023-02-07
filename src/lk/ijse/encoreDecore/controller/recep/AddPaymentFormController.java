package lk.ijse.encoreDecore.controller.recep;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.AddPaymentModel;
import lk.ijse.encoreDecore.to.Payment;
import lk.ijse.encoreDecore.to.PaymentDetails;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddPaymentFormController implements Initializable {

    public ToggleGroup gender;
    public JFXTextField txtSearch;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtAmountPaing;

    @FXML
    private Label lblNic;

    @FXML
    private Label lblCusName;

    @FXML
    private Label lblEventType;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblhadPiad;

    @FXML
    private Label lblHasToPay;

    @FXML
    private Label lblInvoice;

    @FXML
    void btnPayOnAction(ActionEvent event) throws IOException {
        String invoice =lblInvoice.getText();
        String orderId =lblOrderId.getText();
        double amount= Double.parseDouble(txtAmountPaing.getText());
        double remainingAmount= Double.parseDouble(lblHasToPay.getText())-Double.parseDouble(txtAmountPaing.getText());
        String  date= String.valueOf(LocalDate.now());

        Payment payment = new Payment(invoice,orderId,amount,remainingAmount,date);
        try {
            if(Double.parseDouble(lblHasToPay.getText())!=0){
                boolean isAdded=AddPaymentModel.addPayment(payment);
            }

        } catch (SQLException e) {
            System.out.println("methana");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(payment);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();




    }

    public void btnSerchOnAction(ActionEvent actionEvent) {
        String serchText= txtSearch.getText();
        try {
            PaymentDetails paymentDetails=AddPaymentModel.getPaymentDetails(serchText);

            if(paymentDetails!= null){
                lblNic.setText(paymentDetails.getNic());
                lblOrderId.setText(paymentDetails.getOrderId());
                lblCusName.setText(paymentDetails.getName());
                lblEventType.setText(paymentDetails.getEvent());
                lblhadPiad.setText(String.valueOf(paymentDetails.getPaidAmount()));
                lblHasToPay.setText(String.valueOf(paymentDetails.getHasToPayAmount()));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void txtSerchOnAction(ActionEvent actionEvent) {
        btnSerchOnAction(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String[] split = AddPaymentModel.getInvoice().split("I");
            int number = Integer.parseInt(split[1]);
            String id=null;
            number++;

            if(10>number){
                id= "I00"+ number;
            } else if (100>number) {
                id= "I0"+ number;
            }else{
                id="I"+ number;
            }

            lblInvoice.setText(id);
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }
    }
}
