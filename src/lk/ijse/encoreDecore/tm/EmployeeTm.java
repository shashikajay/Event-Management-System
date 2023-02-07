package lk.ijse.encoreDecore.tm;

public class EmployeeTm {
    private String id;
    private String name;
    private String nic;
    private String contact;
    private String email;
    private String role;
    private double salary;

    public EmployeeTm(String id, String name, String nic, String contact, String email, String role, double salary) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.role = role;
        this.salary = salary;
    }

    public EmployeeTm() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
