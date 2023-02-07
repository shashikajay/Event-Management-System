package lk.ijse.encoreDecore.tm;

public class OrderTm {

    private String orderId;
    private String orderDate;
    private String eventDate;
    private String eventType;
    private String nic;
    private String name;
    private Double paidAmount;

    public OrderTm(String orderId, String orderDate, String eventDate, String eventType, String nic, String name, Double paidAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.nic = nic;
        this.name = name;
        this.paidAmount = paidAmount;
    }

    public OrderTm(){}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
