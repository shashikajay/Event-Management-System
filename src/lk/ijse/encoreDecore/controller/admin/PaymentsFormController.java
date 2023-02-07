package lk.ijse.encoreDecore.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.ItemModel;
import lk.ijse.encoreDecore.tm.ItemTm;
import lk.ijse.encoreDecore.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PaymentsFormController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<ItemTm> tblBroutght;

    @FXML
    private TableColumn<?, ?> broughtColId;

    @FXML
    private TableColumn<?, ?> broughtColName;

    @FXML
    private TableColumn<?, ?> broughtColQty;

    @FXML
    private TableColumn<?, ?> broughtColCost;

    @FXML
    private TableView<ItemTm> tblRepair;

    @FXML
    private TableColumn<?, ?> repairColId;

    @FXML
    private TableColumn<?, ?> repairColName;

    @FXML
    private TableColumn<?, ?> repaircolqty;

    @FXML
    private TableColumn<?, ?> repairColCost;

    static String broughtItemId;
    static String repairedItemId;
    @FXML
    void broughtMouseClick(MouseEvent event) {
        ItemTm item = tblBroutght.getSelectionModel().getSelectedItem();
        broughtItemId=item.getId();
    }

    @FXML
    void repairMouseClick(MouseEvent event) {
        ItemTm item = tblRepair.getSelectionModel().getSelectedItem();
        repairedItemId=item.getId();
    }

    @FXML
    void btnBroughtItemRemoveOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove Brought item Confirmation");
        alert.setHeaderText("Please Confirm!");
        alert.setContentText("Are you sure want to remove Brought item with id "+broughtItemId+" ?!");

        Optional<ButtonType> result = alert.showAndWait ();
        if(result.get()==ButtonType.OK){
            try {
                boolean isRemoved = ItemModel.removeBrougthItem(broughtItemId);
                if(isRemoved){

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void btnRepairItemRemoveOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove employee Confirmation");
        alert.setHeaderText("Please Confirm!");
        alert.setContentText("Are you sure want to remove empoyee with id "+repairedItemId+" ?!");

        Optional<ButtonType> result = alert.showAndWait ();
        if(result.get()==ButtonType.OK){
            try {
                boolean isRemoved = ItemModel.removeRepairedItem(repairedItemId);
                if(isRemoved){

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void btnBuyItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/BroughtItemForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();

    }

    public void btnRepairItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root= FXMLLoader.load((getClass().getResource("../../view/admin/RepairedItemForm.fxml")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(Navigation.pane.getScene().getWindow());
        stage.show();
    }

    static ObservableList broughtItemList;
    static ObservableList repairItemList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        repairColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        repairColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        repaircolqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        repairColCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        broughtColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        broughtColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        broughtColQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        broughtColCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ArrayList<ItemTm> broughtArrayList = ItemModel.loadBrought();
        broughtItemList = FXCollections.observableArrayList(broughtArrayList);
        tblBroutght.setItems(broughtItemList);

        ArrayList<ItemTm> repapiredArrayList = ItemModel.loadEmployees();
        repairItemList = FXCollections.observableArrayList(repapiredArrayList);
        tblRepair.setItems(repairItemList);
    }
}
