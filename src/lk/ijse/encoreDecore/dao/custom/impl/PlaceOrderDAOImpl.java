package lk.ijse.encoreDecore.dao.custom.impl;

import lk.ijse.encoreDecore.dao.custom.PlaceOrderDAO;
import lk.ijse.encoreDecore.entity.PlaceOrder;
import lk.ijse.encoreDecore.tm.ServiceTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
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
        return null;
    }
}
