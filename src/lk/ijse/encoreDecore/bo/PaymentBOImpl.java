package lk.ijse.encoreDecore.bo;

import lk.ijse.encoreDecore.dao.custom.CustomerDAO;
import lk.ijse.encoreDecore.dao.custom.PaymentDAO;
import lk.ijse.encoreDecore.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.encoreDecore.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.encoreDecore.to.Customer;
import lk.ijse.encoreDecore.to.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl {
    public ArrayList<Payment> getAllCustomers() throws SQLException, ClassNotFoundException {
        PaymentDAO paymentDAO = new PaymentDAOImpl();
        return getAllCustomers();
    }
}
