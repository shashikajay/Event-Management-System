package lk.ijse.encoreDecore.to;

import lk.ijse.encoreDecore.tm.SelectedServicesTm;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlaceOrder {
    private String required ;
    private String orderId;
    private String cusId;
    private String packageId;
    private String today;
    private double total;
    private ArrayList<SelectedServicesTm> services;

    public PlaceOrder() {
    }

    public PlaceOrder(String required, String orderId, String cusId, String packageId, String today, double total, ArrayList<SelectedServicesTm> services) {
        this.required = required;
        this.orderId = orderId;
        this.cusId = cusId;
        this.packageId = packageId;
        this.today = today;
        this.total = total;
        this.services = services;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<SelectedServicesTm> getServices() {
        return services;
    }

    public void setServices(ArrayList<SelectedServicesTm> services) {
        this.services = services;
    }
}
