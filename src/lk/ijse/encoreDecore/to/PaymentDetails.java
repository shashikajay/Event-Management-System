package lk.ijse.encoreDecore.to;

public class PaymentDetails {
    private String nic;
    private String name;
    private String orderId;
    private String event;
    private double paidAmount;
    private double hasToPayAmount;

    public PaymentDetails(String nic, String name, String orderId, String event, double paidAmount, double hasToPayAmount) {
        this.nic = nic;
        this.name = name;
        this.orderId = orderId;
        this.event = event;
        this.paidAmount = paidAmount;
        this.hasToPayAmount = hasToPayAmount;
    }

    public PaymentDetails() {
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getHasToPayAmount() {
        return hasToPayAmount;
    }

    public void setHasToPayAmount(double hasToPayAmount) {
        this.hasToPayAmount = hasToPayAmount;
    }
}
