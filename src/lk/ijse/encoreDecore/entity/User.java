package lk.ijse.encoreDecore.entity;

public class User {
    public User() {
    }

    public User(String name, String passwrod, String role) {
        this.name = name;
        this.passwrod = passwrod;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String name;
    private String passwrod;
    private String role;

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", passwrod='" + passwrod + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
