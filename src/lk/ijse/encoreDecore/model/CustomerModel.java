package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.to.Customer;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO client VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,customer.getId(), customer.getName(), customer.getAddress(), customer.getNic(), customer.getContact(),customer.getEmail(),customer.getGender(),customer.getAge());

    }

    public static String getClientId() throws SQLException, ClassNotFoundException {
        String sql = "select CId from client order by CId desc limit 1";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static Customer search(String nic) throws SQLException, ClassNotFoundException {
        String sql = "select * from client where nic=?";
        ResultSet result= CrudUtil.execute(sql,nic);

        Customer customer=null;
        if(result.next()){
            customer =new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    ""+result.getInt(8)
            );

        }
        return customer;
    }

    public static String getClientName(String cusId) throws SQLException, ClassNotFoundException {
        String sql = "select name from client where CId=?";
        ResultSet result= CrudUtil.execute(sql,cusId);

        if(result.next()){
            return result.getString(1);
        }
        return null;
    }
}
