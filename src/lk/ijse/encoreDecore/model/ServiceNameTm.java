package lk.ijse.encoreDecore.model;

public class ServiceNameTm {
    private String name;

    public ServiceNameTm() {
    }

    @Override
    public String toString() {
        return "ServiceNameTm{" +
                "name='" + name + '\'' +
                '}';
    }

    public ServiceNameTm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
