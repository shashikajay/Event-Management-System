package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.custom.PaymentDAO;
import lk.ijse.encoreDecore.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDetailsDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
