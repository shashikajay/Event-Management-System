package lk.ijse.encoreDecore.bo;

import lk.ijse.encoreDecore.dao.custom.CustomerDAO;
import lk.ijse.encoreDecore.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.encoreDecore.to.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return getAllCustomers();
    }
    public boolean addCustomer(Customer dto) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return addCustomer(dto);
    }
}
