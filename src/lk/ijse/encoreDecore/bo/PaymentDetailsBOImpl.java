package lk.ijse.encoreDecore.bo;

import lk.ijse.encoreDecore.dao.custom.CustomerDAO;
import lk.ijse.encoreDecore.dao.custom.PaymentDAO;
import lk.ijse.encoreDecore.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.encoreDecore.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.encoreDecore.dao.custom.impl.PaymentDetailsDAOImpl;
import lk.ijse.encoreDecore.to.Customer;
import lk.ijse.encoreDecore.to.PaymentDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDetailsBOImpl {
    public ArrayList<PaymentDetails> getAllCustomers() throws SQLException, ClassNotFoundException {
        PaymentDAO paymentDetailsDAO = new PaymentDetailsDAOImpl();
        return getAllCustomers();
    }
}
