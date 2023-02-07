package lk.ijse.encoreDecore.to;

public class Customer {
    private String id;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String contact;
    private String gender;
    private String age;

    public Customer() {
    }

    public Customer(String id, String name, String nic, String email, String address, String contact, String gender, String age) {
        this.id=id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
