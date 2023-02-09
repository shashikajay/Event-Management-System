package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.custom.CustomerDAO;
import lk.ijse.encoreDecore.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
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
        return null;
    }
}
