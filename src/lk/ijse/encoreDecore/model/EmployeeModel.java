package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public static ArrayList<EmployeeTm> loadEmployees() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeTm> employeeTms = new ArrayList<>();
       ResultSet result = CrudUtil.execute("select * from employee");


        while (result.next()){
            employeeTms.add(new EmployeeTm(
                    result.getString(2),
                    result.getString(1),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getDouble(7)
            ));
        }

return employeeTms;
    }
}
