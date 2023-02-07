package lk.ijse.encoreDecore.controller.recep.placeOrder;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.controller.recep.CustomerFormController;
import lk.ijse.encoreDecore.db.DBConnection;
import lk.ijse.encoreDecore.model.CustomerModel;
import lk.ijse.encoreDecore.model.PlaceOrderModel;
import lk.ijse.encoreDecore.model.ServiceNameTm;
import lk.ijse.encoreDecore.tm.*;
import lk.ijse.encoreDecore.to.PlaceOrder;
import lk.ijse.encoreDecore.util.Navigation;
import lk.ijse.encoreDecore.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    public TableView<SelectedServicesTm> tbleSelectedItems;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colPrice;
    public JFXComboBox cmbServices;
    public Label lblDiscount;
    public Label lblServiceCharges;
    public JFXDatePicker requiredDate;
    public Label lblTotal;
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<ServiceTm> tbleService;

    @FXML
    private TableColumn<?, ?> colServiceName;

    @FXML
    private TableColumn<?, ?> colSemi;

    @FXML
    private TableColumn<?, ?> colBudget;

    @FXML
    private TableColumn<?, ?> colLuxury;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblCusName;

    static ObservableList servicesObservableList;
    static ArrayList<SelectedServicesTm> selectedServices= new ArrayList<>();
    static String name;
    @FXML
    void btnbackOnAction(ActionEvent event) throws IOException {
    }
    public void btnMakePaymentOnAction(ActionEvent actionEvent) throws IOException {
        String required = String.valueOf(requiredDate.getValue());
        String orderId= lblOrderId.getText();
        String cusId= lblCustomerId.getText();
        String packageId="P001";
        String today= String.valueOf(LocalDate.now());
        double total = Double.parseDouble(lblTotal.getText());

        PlaceOrder placeOrder = new PlaceOrder(required,orderId,cusId,packageId,today,total,selectedServices);
        report();
        try {
            boolean isOrderPlaced= PlaceOrderModel.placeOrder(placeOrder);

            if(isOrderPlaced){
                Navigation.navigate(Routes.AVAILABILITY,pane);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void report(){
        InputStream resource =this.getClass().getResourceAsStream("/lk/ijse/encoreDecore/report/orderDetailReport.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getDbConnection().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String[] split = PlaceOrderModel.getOrderId().split("O");
             int number = Integer.parseInt(split[1]);
            String id=null;
            number++;

            if(10>number){
                id= "O00"+ number;
            } else if (100>number) {
                id= "O0"+ number;
            }else{
                id="O"+ number;
            }

            lblOrderId.setText(id);

            String cusId= CustomerFormController.clientId;
            lblCustomerId.setText(cusId);
            lblCusName.setText(CustomerModel.getClientName(cusId));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            ArrayList<ServiceNameTm> services = PlaceOrderModel.getServices();

            ArrayList<String> nameList=new ArrayList<>();
            for (ServiceNameTm serviceNameTm:services) {
                nameList.add(serviceNameTm.getName());
            }

            System.out.println(services);
            ObservableList observableList = FXCollections.observableArrayList(nameList);
            cmbServices.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        tbleService.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tbleService.getSelectionModel().setCellSelectionEnabled(true);

    }
    public double getCelValueService(TableView<ServiceTm> tableView ){
        TablePosition tablePosition =tableView.getSelectionModel().getSelectedCells().get(0);
        int row =tablePosition.getRow();
        ServiceTm item = tableView.getItems().get(row);
        TableColumn tableColumn = tablePosition.getTableColumn();
        double value = (Double) tableColumn.getCellObservableValue(item).getValue();
        return value;
    }
    public void cmbServicesOnAction(ActionEvent actionEvent) {
        String servicesValue = (String) cmbServices.getValue();

        colServiceName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        colSemi.setCellValueFactory(new PropertyValueFactory<>("semi"));
        colLuxury.setCellValueFactory(new PropertyValueFactory<>("luxury"));

        ArrayList<ServiceTm> services= PlaceOrderModel.loadAllServies(servicesValue);
        ObservableList observableList = FXCollections.observableArrayList(services);
        tbleService.setItems(observableList);
    }


    public void selectCellOnAction(MouseEvent mouseEvent) {
        double value=getCelValueService(tbleService);

        int num=-1;
        ServiceTm service = tbleService.getSelectionModel().getSelectedItem();

        for (int i =0; i<selectedServices.size();i++){
            if(selectedServices.get(i).getName().equals(service.getName())){
                num=i;
            }
        }

        if(num==-1){
            if(service.getBudget()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Budget",value));
            }else if(service.getSemi()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Semi Luxury",value));
            }else if(service.getLuxury()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Luxury",value));
            }
        }else{
            selectedServices.remove(num);
            if(service.getBudget()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Budget",value));
            }else if(service.getSemi()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Semi Luxury",value));
            }else if(service.getLuxury()==value){
                selectedServices.add(new SelectedServicesTm(service.getName(),"Luxury",value));
            }
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        servicesObservableList = FXCollections.observableArrayList(selectedServices);
        tbleSelectedItems.setItems(servicesObservableList);

        setTotal();
    }

    public void setTotal(){
        double total= 0;
        for (int i =0; i<selectedServices.size();i++){
            total=total+selectedServices.get(i).getPrice();
        }
        double serviceCharge=(total/100)*10;
        total =total+serviceCharge;

        lblServiceCharges.setText(String.valueOf(serviceCharge));
        lblTotal.setText(String.valueOf(total));
    }

    public void btnRemoveAllOnAction(ActionEvent actionEvent) {
        selectedServices.removeAll(selectedServices);
        servicesObservableList = FXCollections.observableArrayList(selectedServices);
        tbleSelectedItems.setItems(servicesObservableList);

        setTotal();
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        int num =0;

        for (int i =0; i<selectedServices.size();i++){
            if(selectedServices.get(i).getName().equals(name)){
                num=i;
            }
        }

        selectedServices.remove(num);
        servicesObservableList = FXCollections.observableArrayList(selectedServices);
        tbleSelectedItems.setItems(servicesObservableList);

        setTotal();
    }

    public void selectItemOnClick(MouseEvent mouseEvent) {
        SelectedServicesTm selectedServicesTm= tbleSelectedItems.getSelectionModel().getSelectedItem();
        name=selectedServicesTm.getName();
    }
}
