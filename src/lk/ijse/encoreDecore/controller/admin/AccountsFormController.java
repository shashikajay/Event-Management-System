package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.encoreDecore.model.AccountModel;
import lk.ijse.encoreDecore.model.EmployeeModel;
import lk.ijse.encoreDecore.tm.AccountTm;
import lk.ijse.encoreDecore.tm.EmployeeTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccountsFormController implements Initializable {
    public AnchorPane pane;
    public TableView<AccountTm> tblAccounts;
    public TableColumn colName;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public CheckBox cbShowPassword;
    public JFXPasswordField txtRecepNewPass;
    public JFXPasswordField txtRecepConfirmPass;
    public JFXTextField txtRecepName;
    public Label lblUserName;

    public void btnAddOnAction(ActionEvent actionEvent) {

    }

    public void setCols(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    static ObservableList observableList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setCols();

            ArrayList<AccountTm> accounts = AccountModel.loadAccountEncripted();
            observableList = FXCollections.observableArrayList(accounts);
            tblAccounts.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void bxShowPasswordOnAction(ActionEvent actionEvent) {
        if(cbShowPassword.isSelected()){
            setCols();
            ArrayList<AccountTm> accounts = null;
            try {
                accounts = AccountModel.loadAccountDecripted();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            observableList = FXCollections.observableArrayList(accounts);
            tblAccounts.setItems(observableList);
        }else{
            try {
                setCols();

                ArrayList<AccountTm> accounts = AccountModel.loadAccountEncripted();
                observableList = FXCollections.observableArrayList(accounts);
                tblAccounts.setItems(observableList);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void selectRowOnAction(MouseEvent mouseEvent) {
        AccountTm accountTm = tblAccounts.getSelectionModel().getSelectedItem();
        txtRecepName.setText(accountTm.getUserName());
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String name=txtRecepName.getText();
        String newPass=txtRecepNewPass.getText();
        String confirmPass=txtRecepConfirmPass.getText();
        if(newPass.equals(confirmPass)){
            try {
                boolean isUpadated = AccountModel.updateReceppass(name,newPass);

                System.out.println(isUpadated);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
