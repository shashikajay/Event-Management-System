package lk.ijse.encoreDecore.tm;

public class EventTm {
    private String name;
    private int orders;
    private Double income;

    public EventTm() {
    }

    public EventTm(String name, int orders, Double income) {
        this.name = name;
        this.orders = orders;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
