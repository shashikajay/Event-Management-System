package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.custom.PlaceOrderDAO;
import lk.ijse.encoreDecore.entity.PlaceOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public ArrayList<PlaceOrder> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(PlaceOrder entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public PlaceOrder search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
