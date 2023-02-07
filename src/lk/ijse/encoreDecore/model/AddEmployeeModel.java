package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.EmployeeTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddEmployeeModel {
    public static String getId() throws SQLException, ClassNotFoundException {
        String sql ="select EId from employee order by EId desc limit 1 ";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static boolean addEmployee(EmployeeTm employee) throws SQLException, ClassNotFoundException {
        String sql ="insert into employee values(?,?,?,?,?,?,?) ";
        return CrudUtil.execute(sql, employee.getName(),employee.getId(),employee.getNic(),employee.getContact(),employee.getRole(),employee.getEmail(),employee.getSalary());

    }

    public static boolean removeEmployee(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employee WHERE EId=?";
        return CrudUtil.execute(sql, id);
    }

    public static boolean updateEmployee(EmployeeTm employee) throws SQLException, ClassNotFoundException {
        String sql ="UPDATE employee set name=?,nic=?,contact=?,role=?,email=?,salary=?\n" +
                "where EId=?; ";
        return CrudUtil.execute(sql, employee.getName(),employee.getNic(),employee.getContact(),employee.getRole(),employee.getEmail(),employee.getSalary(),employee.getId());


    }

    public static EmployeeTm loadEmployee(String id) throws SQLException, ClassNotFoundException {
        String sql = "select * from employee WHERE EId=?";
       ResultSet result =  CrudUtil.execute(sql, id);

        if (result.next()) {
            EmployeeTm employee= new EmployeeTm(
                    result.getString(2),
                    result.getString(1),
                    result.getString(3),
                    result.getString(4),
                    result.getString(6),
                    result.getString(5),
                    result.getDouble(7)
            );
            return employee;
        }

        return null;
    }
}
