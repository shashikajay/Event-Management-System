package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.PackageModel;
import lk.ijse.encoreDecore.model.PlaceOrderModel;
import lk.ijse.encoreDecore.model.ServiceNameTm;
import lk.ijse.encoreDecore.tm.SelectedServicesTm;
import lk.ijse.encoreDecore.tm.ServiceTm;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PackageFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane subPane;

    @FXML
    private TableView<ServiceNameTm> tblService;

    @FXML
    private TableColumn<?, ?> colService;

    @FXML
    private JFXTextField txtServiceName;

    @FXML
    private TableView<ServiceTm> tbleServiceContains;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colBudget;

    @FXML
    private TableColumn<?, ?> colSemi;

    @FXML
    private TableColumn<?, ?> colLuxury;

    @FXML
    private JFXTextField txtDetailName;

    @FXML
    private JFXTextField txtbudget;

    @FXML
    private JFXTextField txtSemi;

    @FXML
    private JFXTextField txtLuxury;

    @FXML
    private JFXComboBox<?> cmbPackage;

    @FXML
    void cmbPackageOnAction(ActionEvent event) {
        int index = cmbPackage.getSelectionModel().getSelectedIndex();

        if(index==0){
            try {
                ArrayList<ServiceNameTm> nameTms = PlaceOrderModel.getServices();
                colService.setCellValueFactory(new PropertyValueFactory<>("name"));
                ObservableList observableList = FXCollections.observableArrayList(nameTms);
                tblService.setItems(observableList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    void btnDetailAddOnAction(ActionEvent event) {
        try {
            String name=txtDetailName.getText();
            double budget = Double.parseDouble(txtbudget.getText());
            double semi = Double.parseDouble(txtSemi.getText());
            double luxury = Double.parseDouble(txtLuxury.getText());

            ServiceTm selectedItem = new ServiceTm(name,budget,semi,luxury);

            boolean isAdded= PackageModel.addServiceDetail(selectedItem,SId);

            if(isAdded){
                colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
                colSemi.setCellValueFactory(new PropertyValueFactory<>("semi"));
                colLuxury.setCellValueFactory(new PropertyValueFactory<>("luxury"));

                ArrayList<ServiceTm> servicesList= PackageModel.loadServices(serviceName);
                ObservableList serviceObservableList = FXCollections.observableArrayList(servicesList);
                tbleServiceContains.setItems(serviceObservableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDetailRemoveOnAction(ActionEvent event) {
        try {

            boolean isRemoved= PackageModel.removeServiceDetail(serviceDetailName);

            if(isRemoved){
                colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
                colSemi.setCellValueFactory(new PropertyValueFactory<>("semi"));
                colLuxury.setCellValueFactory(new PropertyValueFactory<>("luxury"));

                ArrayList<ServiceTm> servicesList= PackageModel.loadServices(serviceName);
                ObservableList serviceObservableList = FXCollections.observableArrayList(servicesList);
                tbleServiceContains.setItems(serviceObservableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void btnDetailUpdateOnAction(ActionEvent actionEvent) {
        try {
            String name=txtDetailName.getText();
            double budget = Double.parseDouble(txtbudget.getText());
            double semi = Double.parseDouble(txtSemi.getText());
            double luxury = Double.parseDouble(txtLuxury.getText());

            ServiceTm selectedItem = new ServiceTm(name,budget,semi,luxury);
            boolean isUpdated= PackageModel.updateServiceDetail(serviceDetailName,selectedItem);

            if(isUpdated){
                colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
                colSemi.setCellValueFactory(new PropertyValueFactory<>("semi"));
                colLuxury.setCellValueFactory(new PropertyValueFactory<>("luxury"));

                ArrayList<ServiceTm> servicesList= PackageModel.loadServices(serviceName);
                ObservableList serviceObservableList = FXCollections.observableArrayList(servicesList);
                tbleServiceContains.setItems(serviceObservableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String serviceDetailName;
    @FXML
    void selectServiceContainRow(MouseEvent event) {
        ServiceTm selectedItem= tbleServiceContains.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
            serviceDetailName =selectedItem.getName();

            txtDetailName.setText(selectedItem.getName());
            txtbudget.setText(String.valueOf(selectedItem.getBudget()));
            txtSemi.setText(String.valueOf(selectedItem.getSemi()));
            txtLuxury.setText(String.valueOf(selectedItem.getLuxury()));
        }

    }
    static String serviceName;
    static String SId;
    @FXML
    void selectServiceRow(MouseEvent event) {
        ServiceNameTm serviceNameTm= tblService.getSelectionModel().getSelectedItem();

        if(serviceNameTm!=null){
            serviceName=serviceNameTm.getName();

            try {
                SId = PackageModel.getSid(serviceName);

                colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
                colSemi.setCellValueFactory(new PropertyValueFactory<>("semi"));
                colLuxury.setCellValueFactory(new PropertyValueFactory<>("luxury"));

                ArrayList<ServiceTm> servicesList= PackageModel.loadServices(serviceNameTm.getName());
                ObservableList serviceObservableList = FXCollections.observableArrayList(servicesList);
                tbleServiceContains.setItems(serviceObservableList);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void btnServiceAddOnAction(ActionEvent event) {
        try {
            String name =txtServiceName.getText();
            boolean isAdded= PackageModel.addService(name);

            if(isAdded){
                ArrayList<ServiceNameTm> nameTms = PlaceOrderModel.getServices();
                colService.setCellValueFactory(new PropertyValueFactory<>("name"));
                ObservableList observableList = FXCollections.observableArrayList(nameTms);
                tblService.setItems(observableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnServiceRemoveOnAction(ActionEvent event) {
        try {
            boolean isRemoved= PackageModel.removeService(serviceName);

            if(isRemoved){
                ArrayList<ServiceNameTm> nameTms = PlaceOrderModel.getServices();
                colService.setCellValueFactory(new PropertyValueFactory<>("name"));
                ObservableList observableList = FXCollections.observableArrayList(nameTms);
                tblService.setItems(observableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnServiceUpdateOnAction(ActionEvent event) {
        try {
            String name=txtServiceName.getText();
            boolean isUpdate= PackageModel.updateService(serviceName,name);


            if(isUpdate){
                ArrayList<ServiceNameTm> nameTms = PlaceOrderModel.getServices();
                colService.setCellValueFactory(new PropertyValueFactory<>("name"));
                ObservableList observableList = FXCollections.observableArrayList(nameTms);
                tblService.setItems(observableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ArrayList<String> packages=PackageModel.getPackages();
            ObservableList observableList = FXCollections.observableArrayList(packages);
            cmbPackage.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
