package lk.ijse.encoreDecore.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Customer Manage Form");
                setUi("login/LoginForm.fxml");
                break;
            case FORGET:
                window.setTitle("Forget Password Form");
                setUi("login/ForgetPasswordForm.fxml");
                break;

            case AVAILABILITY:
                window.setTitle("Availability Form");
                setUi("recep/RecepsionistDashboardForm.fxml");
                break;
            case SERVICE:
                window.setTitle("Service Form");
                setUi("recep/ServicesForm.fxml");
                break;
            case ORDER:
                window.setTitle("Order Form");
                setUi("recep/OrderForm.fxml");
                break;
            case PAYMENT_DETAILS:
                window.setTitle("Payment Details Form");
                setUi("recep/PaymentDetailsForm.fxml");
                break;

            case ANNIVERSARY:
                window.setTitle("Anniversary Details Form");
                setUi("recep/services/AnniversaryForm.fxml");
                break;
            case BABY_SHOWER:
                window.setTitle("Baby Shower Details Form");
                setUi("recep/services/BabyShowerForm.fxml");
                break;
            case BATCH_REUNION:
                window.setTitle("Batch Reunion Details Form");
                setUi("recep/services/BatchReunionForm.fxml");
                break;
            case BIRTHDAY:
                window.setTitle("Birthday Details Form");
                setUi("recep/services/BirthdayForm.fxml");
                break;
            case CUSTOM_PARTY:
                window.setTitle("Custom Party Details Form");
                setUi("recep/services/CustomPartyForm.fxml");
                break;
            case WEDDING:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/WeddingForm.fxml");
                break;
            case WEDDING_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/WeddingServiceDetailsForm.fxml");
                break;
            case CUSTOM_PARTY_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("/recep/services/CustomPartyForm.fxml");
                break;
            case ANNIVERSARY_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/AnniversaryServiceDetailsForm.fxml");
                break;
            case BABY_SHOWER_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/BabyShowerServiceDetailsForm.fxml");
                break;
            case BATCH_REUNION_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/BatchReunionServiceDetailsForm.fxml");
                break;
            case BIRTHDAY_SERVICE_DETAILS:
                window.setTitle("Wedding Details Form");
                setUi("recep/services/CustomServiceDetailsForm.fxml");
                break;

            case CUSTOMER:
                window.setTitle("Customer Registration Form");
                setUi("recep/CustomerForm.fxml");
                break;
            case WEDDING_PLACE_ORDER:
                window.setTitle("Place Order Form");
                setUi("recep/placeOrder/PlaceOrderForm.fxml");
                break;
            case MAKE_PAYMENT:
                window.setTitle("Make Payment Form");
                setUi("recep/MakePaymentForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("Overview Form");
                setUi("admin/DashBoardForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee Form");
                setUi("admin/EmployeeForm.fxml");
                break;
            case PACKAGE:
                window.setTitle("Package Form");
                setUi("admin/PackageForm.fxml");
                break;
            case SALARY:
                window.setTitle("SalaryTm Form");
                setUi("admin/SalariesForm.fxml");
                break;
            case PAYMENTS:
                window.setTitle("Payment Form");
                setUi("admin/PaymentsForm.fxml");
                break;
            case ACCOUNT:
                window.setTitle("Account Form");
                setUi("admin/AccountsForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void setUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/encoreDecore/view/" + location)));
    }
}
