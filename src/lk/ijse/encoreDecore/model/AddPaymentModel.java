package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.to.Payment;
import lk.ijse.encoreDecore.to.PaymentDetails;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddPaymentModel {
    public static String getInvoice() throws SQLException, ClassNotFoundException {
        String sql = "select invoice from payment order by invoice desc limit 1";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static PaymentDetails getPaymentDetails(String serchText) throws SQLException, ClassNotFoundException {
        String sql = "select client.nic, client.name,  orders.OId,package.type, orders.total-payment.remaining_amount, payment.remaining_amount\n" +
                "    from orders\n" +
                "JOIN package  on package.PId = orders.PId and orders.OId=?\n" +
                "JOIN client  on client.CId = orders.CId\n" +
                "JOIN payment  on orders.OId = payment.OId\n" +
                "order by payment.invoice desc";
        ResultSet result= CrudUtil.execute(sql,serchText );

        PaymentDetails paymentDetails = null;
        if(result.next()){
            paymentDetails= new PaymentDetails(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getDouble(6)
            );

            return paymentDetails;
        }
        return null;
    }

    public static boolean addPayment(Payment payment) throws SQLException, ClassNotFoundException {
        String sql= "insert into payment values (?, ? ,? ,? ,? )";
          System.out.println(payment);
        return CrudUtil.execute(sql, payment.getOrderId(),payment.getInvoice(),payment.getDate(),payment.getAmount(),payment.getRemaining());
    }
}
