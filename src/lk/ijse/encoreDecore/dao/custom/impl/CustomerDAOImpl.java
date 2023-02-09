package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.SQLUtil;
import lk.ijse.encoreDecore.dao.custom.CustomerDAO;
import lk.ijse.encoreDecore.entity.Customer;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        return null;
    }

    @Override
    public boolean add(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO client VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,entity.getCId(), entity.getName(), entity.getAddress(), entity.getNic(), entity.getContact(),entity.getEmail(),entity.getGender(),entity.getAge());

    }
    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("select * from client where nic=?", id);
        while (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getInt(8));
        }
        return null;
    }
}
