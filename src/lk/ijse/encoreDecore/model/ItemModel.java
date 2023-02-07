package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.AvailabilityTm;
import lk.ijse.encoreDecore.tm.ItemTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {


    public static ArrayList<ItemTm> loadBrought() {
        ArrayList<ItemTm> itemTms = new ArrayList<>();
        try{
            String search="%I%";
            ResultSet resultSet = CrudUtil.execute("select * from item_payments where PId like ?",search);
            while (resultSet.next()){
                itemTms.add(new ItemTm(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemTms;
    }

    public static ArrayList<ItemTm> loadEmployees() {
        ArrayList<ItemTm> itemTms = new ArrayList<>();
        try{
            String search="%R%";
            ResultSet resultSet = CrudUtil.execute("select * from item_payments where PId like ?",search);
            while (resultSet.next()){
                itemTms.add(new ItemTm(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemTms;
    }

    public static boolean removeBrougthItem(String broughtItemId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_payments WHERE PId=?";
        return CrudUtil.execute(sql, broughtItemId);

    }

    public static boolean removeRepairedItem(String repairedItemId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_payments WHERE PId=?";
        return CrudUtil.execute(sql, repairedItemId);
    }

    public static String getBroughtItemId() throws SQLException, ClassNotFoundException {
        String search ="%I%";
        String sql ="select PId from item_payments where PId like ? order by PId desc limit 1";
        ResultSet result= CrudUtil.execute(sql,search);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static boolean addBroughtItem(ItemTm item) throws SQLException, ClassNotFoundException {
        String sql = "insert into item_payments values (?,?,?,?)";
        return CrudUtil.execute(sql, item.getId(),item.getName(),item.getQty(),item.getCost());

    }

    public static String getRepairedItemId() throws SQLException, ClassNotFoundException {
        String search ="%R%";
        String sql ="select PId from item_payments where PId like ? order by PId desc limit 1";
        ResultSet result= CrudUtil.execute(sql,search);

        String id=null;
        if(result.next()){
            id =result.getString(1);
        }
        return id;
    }

    public static boolean addRepairedItems(ItemTm item) throws SQLException, ClassNotFoundException {
        String sql = "insert into item_payments values (?,?,?,?)";
        return CrudUtil.execute(sql, item.getId(),item.getName(),item.getQty(),item.getCost());
    }
}
