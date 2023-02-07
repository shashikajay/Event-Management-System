package lk.ijse.encoreDecore.model;

import lk.ijse.encoreDecore.tm.EventTm;
import lk.ijse.encoreDecore.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventModel {
    public static ArrayList<EventTm> loadEvents() throws SQLException, ClassNotFoundException {
        ArrayList<EventTm> array = new ArrayList<>();
        String sql="select COUNT(OID),sum(total) FROM orders WHERE PId='P001'";
        ResultSet resultSet1 = CrudUtil.execute(sql);

        if(resultSet1.next()){
            EventTm event1=new EventTm("Wedding Planning",resultSet1.getInt(1),resultSet1.getDouble(2));
            array.add(event1);
        }

        EventTm event2=new EventTm("Birthday Party Planning",47,3239200.0);
        EventTm event3=new EventTm("Batch Reunion Party Planning",86,2637500.0);
        EventTm event4=new EventTm("Anniversary Party Planning",79,8764600.0);
        EventTm event5=new EventTm("Baby Shower Party Planning",83,9732100.0);
        EventTm event6=new EventTm("Custom Party Planning",42,6329700.0);

        array.add(event2);
        array.add(event3);
        array.add(event4);
        array.add(event5);
        array.add(event6);

        return array;
    }

    public static int getOders() throws SQLException, ClassNotFoundException {
        String sql="select COUNT(OID) FROM orders";
        ResultSet resultSet = CrudUtil.execute(sql);

        int orders=0;
        if(resultSet.next()){
            orders=resultSet.getInt(1);
        }
        return orders;
    }

    public static int getCustomers() throws SQLException, ClassNotFoundException {
        String sql="select COUNT(CId) FROM client";
        ResultSet resultSet = CrudUtil.execute(sql);

        int client=0;
        if(resultSet.next()){
            client=resultSet.getInt(1);
        }
        return client;
    }
}
