package lk.ijse.encoreDecore.tm;

public class ServiseDetailsTm {
    private String name;
    private Double amount;

    public ServiseDetailsTm(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public ServiseDetailsTm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
