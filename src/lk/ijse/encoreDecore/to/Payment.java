package lk.ijse.encoreDecore.to;

import java.time.LocalDate;

public class Payment {
    private String invoice;
    private String orderId;
    private double amount;
    private double remaining;

    private String date;
    public Payment(String invoice, String orderId, double amount, double remaining, String date) {
        this.invoice = invoice;
        this.orderId = orderId;
        this.amount = amount;
        this.remaining = remaining;
        this.date=date;
    }
    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "invoice='" + invoice + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", remaining=" + remaining +
                ", date='" + date + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }
}
