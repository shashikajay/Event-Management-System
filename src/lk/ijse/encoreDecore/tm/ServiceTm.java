package lk.ijse.encoreDecore.tm;

public class ServiceTm {
    private String Name;
    private double budget;
    private double semi;

    private double luxury;



    public ServiceTm(String name, double budget, double semi,double luxury) {
        Name = name;
        this.budget = budget;
        this.semi = semi;
        this.luxury=luxury;
    }

    @Override
    public String toString() {
        return "ServiceTm{" +
                "Name='" + Name + '\'' +
                ", budget=" + budget +
                ", semi=" + semi +
                '}';
    }

    public ServiceTm() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getSemi() {
        return semi;
    }

    public void setSemi(double semi) {
        this.semi = semi;
    }

    public double getLuxury() {
        return luxury;
    }

    public void setLuxury(double luxury) {
        this.luxury = luxury;
    }
}
