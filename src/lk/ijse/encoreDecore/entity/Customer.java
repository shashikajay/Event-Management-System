package lk.ijse.encoreDecore.entity;

public class Customer {

    public Customer() {
    }

    public Customer(String CId, String name, String address, String nic, String contact, String email, String gender, int age) {
        this.CId = CId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "CId='" + CId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    private String CId;
    private String name;
    private String address;
    private String nic;
    private String contact;
    private String email;
    private String gender;
    private int age;

}
