package lk.ijse.encoreDecore.tm;

public class AccountTm {
    private String name;
    private String userName;
    private String Password;

    public AccountTm() {
    }

    public AccountTm(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
