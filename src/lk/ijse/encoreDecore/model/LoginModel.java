package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.to.User;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginModel {
    public static ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<User> arrayList= new ArrayList<>();

        String sql="select name,password,role from user";
        ResultSet resultSet = CrudUtil.execute(sql);

        while(resultSet.next()){
            arrayList.add(new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
                    ));
        }

        return arrayList;
    }
}
