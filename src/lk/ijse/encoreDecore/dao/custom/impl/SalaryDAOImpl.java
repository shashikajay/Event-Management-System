package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.custom.SalaryDAO;
import lk.ijse.encoreDecore.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Salary entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Salary entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Salary search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
