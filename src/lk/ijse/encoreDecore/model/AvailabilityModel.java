package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.AvailabilityTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvailabilityModel {
    public static ArrayList<AvailabilityTm> loadOrders(){
        ArrayList<AvailabilityTm> Orders = new ArrayList<>();
        try{
            ResultSet resultSet =CrudUtil.execute("select orders.required_date,client.name, package.type\n" +
                    "FROM orders\n" +
                    "    JOIN  client on   orders.CId=client.CId\n" +
                    "JOIN package  on  orders.PId=package.PId WHERE orders.required_date>=NOW()");
            while (resultSet.next()){
                Orders.add(new AvailabilityTm(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Orders;
    }

}
