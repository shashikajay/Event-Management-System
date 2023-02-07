package lk.ijse.encoreDecore.tm;

public class SalaryTm {
    private String id;
    private String name;
    private String nic;
    private double amount;
    private String date;
    private String month;

    public SalaryTm(String id, String name, String nic, double amount, String date, String month) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.amount = amount;
        this.date = date;
        this.month = month;
    }

    public SalaryTm() {
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SalaryTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
