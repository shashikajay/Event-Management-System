package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.AccountTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountModel {
    public static ArrayList<AccountTm> loadAccountEncripted() throws SQLException, ClassNotFoundException {
        ArrayList<AccountTm> accounts = new ArrayList<>();

        String role = "receptionist";
        String sql= "select full_name, name, password from user where role = ?";
        ResultSet resultSet = CrudUtil.execute(sql,role);

        while (resultSet.next()){
            accounts.add(new AccountTm(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    "########"
            ));
        }
        return accounts;
    }

    public static ArrayList<AccountTm> loadAccountDecripted() throws SQLException, ClassNotFoundException {
        ArrayList<AccountTm> accounts = new ArrayList<>();

        String role = "receptionist";
        String sql= "select full_name, name, password from user where role = ?";
        ResultSet resultSet = CrudUtil.execute(sql,role);

        while (resultSet.next()){
            accounts.add(new AccountTm(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return accounts;
    }

    public static boolean updateReceppass(String name, String txtRecepNewPassText) throws SQLException, ClassNotFoundException {
        String sql = "update user set password =? where name=?";
        return CrudUtil.execute(sql,txtRecepNewPassText,name);
    }
}
