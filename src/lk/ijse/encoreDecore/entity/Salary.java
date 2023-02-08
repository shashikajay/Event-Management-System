package lk.ijse.encoreDecore.entity;

public class Salary {
    public Salary() {
    }

    public Salary(String id, double amount, String date, String month) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "SalaryEntity{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                '}';
    }

    private String id;
    private double amount;
    private String date;
    private String month;
}
