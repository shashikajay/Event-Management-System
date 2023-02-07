package lk.ijse.encoreDecore.controller.admin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.encoreDecore.model.ItemModel;
import lk.ijse.encoreDecore.tm.ItemTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RepairedItemFormController implements Initializable {
    public AnchorPane pane;
    public JFXTextField txtName;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;
    public Label lblItemId;

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id= lblItemId.getText();
        String name= txtName.getText();
        int qty= Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());

        ItemTm item = new ItemTm(id, name, qty, price);

        try {
            boolean isAdded = ItemModel.addRepairedItems(item);
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
            String[] split = ItemModel.getRepairedItemId().split("R");
            int number = Integer.parseInt(split[1]);
            String id=null;
            number++;

            if(10>number){
                id= "R00"+ number;
            } else if (100>number) {
                id= "R0"+ number;
            }else{
                id="R"+ number;
            }

            lblItemId.setText(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
