package utilities;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    public static Connection openConnection(String url, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("error while connecting to db: " + e);
        }
        return con;
    }

    public static void closeConnection(){
        try {
            con.close();
        }
        catch (Exception e){
            System.out.println("error while closing DB");
        }

    }
}
