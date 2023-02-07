package lk.ijse.encoreDecore.tm;

public class PaymentDetailsTm {
    private String invoiceNo;
    private String OrderId;
    private String cusId;
    private String cusName;
    private String date;
    private Double total;
    private Double paid;
    private Double remaining;

    public PaymentDetailsTm(String invoiceNo, String orderId, String cusId, String cusName, String date, Double total, Double paid, Double remaining) {
        this.invoiceNo = invoiceNo;
        OrderId = orderId;
        this.cusId = cusId;
        this.cusName = cusName;
        this.date = date;
        this.total = total;
        this.paid = paid;
        this.remaining = remaining;
    }

    public PaymentDetailsTm() {
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }
}
