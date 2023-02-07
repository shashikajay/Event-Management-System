package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.SalaryTm;
import lk.ijse.encoreDecore.to.Salary;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryModel {


    public static ArrayList<SalaryTm> loadSalary() throws SQLException, ClassNotFoundException {
        ArrayList<SalaryTm> salary = new ArrayList<>();
        ResultSet result = CrudUtil.execute("select employee.EId,employee.name,employee.nic, salary.amount, salary.date, salary.month\n" +
                "from employee\n" +
                "JOIN salary  on employee.EId = salary.EId\n" +
                "order by salary.date asc ;");


        while (result.next()) {
            salary.add(new SalaryTm(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getString(5),
                    result.getString(6)
            ));
        }
        return salary;
    }


    public static SalaryTm searchSalary(String id) throws SQLException, ClassNotFoundException {
        String sql = "select employee.name, salary.amount\n" +
                "from salary\n" +
                "JOIN employee on employee.EId = salary.EId\n" +
                "and salary.EId =?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        if(resultSet.next()){
            SalaryTm salary = new SalaryTm(
                    null,
                    resultSet.getString(1),
                    null,
                    resultSet.getDouble(2),
                    null,
                    null
            );

            return salary;
        }
        return null;
    }

    public static boolean addSalary(Salary salary) throws SQLException, ClassNotFoundException {
        String sql = "insert  into  salary values (?, ?,?,?)";
        return CrudUtil.execute(sql,salary.getId(),salary.getAmount(),salary.getDate(),salary.getMonth());
    }

    public static boolean removeSalary(String id, String date) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM salary WHERE EId=? && date=?";
        return CrudUtil.execute(sql, id,date);
    }
}
