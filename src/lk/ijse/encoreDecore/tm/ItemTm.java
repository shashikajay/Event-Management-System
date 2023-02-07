package lk.ijse.encoreDecore.tm;

public class ItemTm {
    private String id;
    private String name;
    private int qty;
    private double cost;

    public ItemTm() {
    }

    public ItemTm(String id, String name, int qty, double cost) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
