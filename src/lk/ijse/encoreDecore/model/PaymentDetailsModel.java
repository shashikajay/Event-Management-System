package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.PaymentDetailsTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDetailsModel {
    public static ArrayList<PaymentDetailsTm> loadPayments() {
        ArrayList<PaymentDetailsTm> payments = new ArrayList<>();
        try{
            ResultSet resultSet = CrudUtil.execute("select payment.invoice, payment.OId, orders.CId, client.name,payment.date,orders.total,payment.amount,payment.remaining_amount\n" +
                    "from payment\n" +
                    "join orders  on payment.OId=orders.OId\n" +
                    "join client  on client.CId = orders.CId;");
            while (resultSet.next()){
                payments.add(new PaymentDetailsTm(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return payments;
    }
}
