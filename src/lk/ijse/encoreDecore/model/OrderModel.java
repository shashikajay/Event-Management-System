package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.OrderTm;
import lk.ijse.encoreDecore.tm.SelectedServicesTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel {
    public static ArrayList<OrderTm> loadOrders() throws SQLException, ClassNotFoundException {
        ArrayList<OrderTm> orders = new ArrayList<>();
        ResultSet result = CrudUtil.execute("select orders.OId, orders.today, orders.required_date, package.type,client.nic,client.name,orders.total\n" +
                "from orders\n" +
                "JOIN package on package.PId = orders.PId\n" +
                "JOIN client on  orders.CId=client.CId");

        while (result.next()){
            orders.add(new OrderTm(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getDouble(7)
            ));
        }

        return orders;

    }

    public static ArrayList<SelectedServicesTm> loadOrderDetails(String id) throws SQLException, ClassNotFoundException {
        ArrayList<SelectedServicesTm> orderDetails = new ArrayList<>();

        String sql="select name,type,price from order_details where OId=?";
        ResultSet result= CrudUtil.execute(sql,id);

        while (result.next()){
            orderDetails.add(new SelectedServicesTm(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3)
            ));
        }
        return orderDetails;
    }

    public static boolean removeOrder(String orderId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM orders WHERE OId=?";
        return CrudUtil.execute(sql, orderId);
    }
}
