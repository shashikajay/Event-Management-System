package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.db.DBConnection;
import lk.ijse.encoreDecore.tm.ItemTm;
import lk.ijse.encoreDecore.tm.SelectedServicesTm;
import lk.ijse.encoreDecore.tm.ServiceTm;
import lk.ijse.encoreDecore.to.PlaceOrder;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderModel {
    public static ArrayList<ServiceTm> loadServies() {
        ArrayList<ServiceTm> services = new ArrayList<>();
        try{
            String searchText = "S%";
            String sql="select name, low, normal from wedding_details where id like ?";
            ResultSet resultSet = CrudUtil.execute(sql,searchText);
            while (resultSet.next()){
                services.add(new ServiceTm(
                        resultSet.getString(1),
                        resultSet.getDouble(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return services;
    }

    public static ArrayList<ItemTm> loadItems() {
        ArrayList<ItemTm> items = new ArrayList<>();
        try{
            String searchText = "R%";
            String sql="select name, low, normal, high from wedding_details where id like ?";
            ResultSet resultSet = CrudUtil.execute(sql,searchText);
            while (resultSet.next()){
                items.add(new ItemTm(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public static String getOrderId() throws SQLException, ClassNotFoundException {
        String sql = "select OId from orders order by OId desc limit 1";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static ArrayList<ServiceNameTm> getServices() throws SQLException, ClassNotFoundException {
        ArrayList<ServiceNameTm> services =new ArrayList<>();
        String sql = "select name from wedding_services order by SId";
        ResultSet result= CrudUtil.execute(sql);

        while (result.next()){
            services.add(new ServiceNameTm(result.getString(1))
            );
        }

        return services;
    }

    public static ArrayList<ServiceTm> loadAllServies(String servicesValue) {
        ArrayList<ServiceTm> services = new ArrayList<>();
        try{
            String sql="select wedding_service_details.name, wedding_service_details.budget, wedding_service_details.semi, wedding_service_details.luxury\n" +
                    "from wedding_service_details\n" +
                    "join wedding_services  on wedding_services.SId = wedding_service_details.SId\n" +
                    "where wedding_services.name=?";
            ResultSet resultSet = CrudUtil.execute(sql,servicesValue);
            while (resultSet.next()){
                services.add(new ServiceTm(
                        resultSet.getString(1),
                        resultSet.getDouble(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return services;
    }

    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            String orderSql= "insert into orders values (?,?,?,?,?,?)";
            boolean isOdersInserted = CrudUtil.execute(orderSql,placeOrder.getOrderId(),placeOrder.getCusId(),placeOrder.getPackageId(),placeOrder.getToday(),placeOrder.getRequired(),placeOrder.getTotal());

            if (isOdersInserted) {
                int num=0;

                for (SelectedServicesTm servicesTm: placeOrder.getServices()) {
                    String orderDetailsSql="insert into order_details values (?,?,?,?)";
                    boolean isOrderDetailsInserted= CrudUtil.execute(orderDetailsSql,placeOrder.getOrderId(),servicesTm.getName(),servicesTm.getType(),servicesTm.getPrice());
                    if(isOrderDetailsInserted){
                        num++;
                    }
                }

                if(num==placeOrder.getServices().size()){
                    return true;
                }
            }

            DBConnection.getDbConnection().getConnection().rollback();
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }
}
