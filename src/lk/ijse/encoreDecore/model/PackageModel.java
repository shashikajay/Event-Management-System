package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.ServiceTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageModel {
    public static ArrayList<String> getPackages() throws SQLException, ClassNotFoundException {
        ArrayList<String> array = new ArrayList<>();
        String sql = "select type from package";

        ResultSet result= CrudUtil.execute(sql);

        while (result.next()){
            array.add(result.getString(1)
            );
        }
        return array;
    }

    public static ArrayList<ServiceTm> loadServices(String name) throws SQLException, ClassNotFoundException {
        ArrayList<ServiceTm> array = new ArrayList<>();

        String sql = "select wedding_service_details.name, wedding_service_details.budget, wedding_service_details.semi,wedding_service_details.luxury\n" +
                "from wedding_service_details\n" +
                "join wedding_services  on wedding_services.SId = wedding_service_details.SId where wedding_services.name=?";

        ResultSet result= CrudUtil.execute(sql,name);

        while (result.next()){
            array.add(new ServiceTm(
                    result.getString(1),
                    result.getDouble(2),
                    result.getDouble(3),
                    result.getDouble(4)
            ));
        }
        return array;
    }

    public static boolean addService(String serviceName) throws SQLException, ClassNotFoundException {
        ArrayList<ServiceNameTm> array = new ArrayList<>();

        String sql = "select SId from wedding_services order by SId desc limit 1";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        String[] split = id.split("S");
        int number = Integer.parseInt(split[1]);
        String SId=null;
        number++;

        if(10>number){
            SId= "S00"+ number;
        } else if (100>number) {
            SId= "S0"+ number;
        }else{
            SId="S"+ number;
        }
        System.out.println(SId);

        String insertSql = "insert into wedding_services values(?,?)";
        return CrudUtil.execute(insertSql,SId,serviceName);
    }

    public static boolean removeService(String serviceName) throws SQLException, ClassNotFoundException {
        String sql ="delete from wedding_services where name=?";
        return CrudUtil.execute(sql,serviceName);
    }

    public static boolean updateService(String serviceName, String name) throws SQLException, ClassNotFoundException {
        String sql ="update wedding_services set name =? where name=?";
        return CrudUtil.execute(sql,name, serviceName);
    }

    public static boolean addServiceDetail(ServiceTm selectedItem, String SId) throws SQLException, ClassNotFoundException {
        ArrayList<ServiceTm> array = new ArrayList<>();

        String sql = "select SId from wedding_service_details order by SId desc limit 1";
        ResultSet result= CrudUtil.execute(sql);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }

        System.out.println(SId);

        String insertSql = "insert into wedding_service_details values(?,?,?,?,?)";
        return CrudUtil.execute(insertSql,SId, selectedItem.getName(),selectedItem.getBudget(),selectedItem.getSemi(),selectedItem.getLuxury());
    }

    public static String getSid(String serviceName) throws SQLException, ClassNotFoundException {

        String sql = "select SId from wedding_services where name=?";
        ResultSet result= CrudUtil.execute(sql,serviceName);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static boolean removeServiceDetail(String serviceDetailName) throws SQLException, ClassNotFoundException {
        String sql ="delete from wedding_service_details where name=?";
        return CrudUtil.execute(sql,serviceDetailName);
    }

    public static boolean updateServiceDetail(String serviceDetailName, ServiceTm selectedItem) throws SQLException, ClassNotFoundException {
        String sql ="update wedding_service_details set name =?, budget = ?, semi=?,luxury=?  where name=?";
        return CrudUtil.execute(sql,selectedItem.getName(),selectedItem.getBudget(),selectedItem.getSemi(),selectedItem.getLuxury(), serviceDetailName);
    }
}
