package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDB;
import workflows.WebFlows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Listeners(utilities.Listeners.class)
    public class DBClass extends CommonOps {

        String query = "select * from names;";
        String myName;
        String myPass;


        @Test(description = "Test 01 checking main query")
        @Description("this will check general query to DB")
        public void test01_verifyMainQuery () throws Exception {
           Connection con1 =  ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
          try{
           Statement ste = con1.createStatement();
           ResultSet rs = ste.executeQuery(query);
        }
          catch (Exception e){
              System.out.println("error with DB" +e);
          }
          try {
              while (rs.next()) {
                  myName = rs.getString(1);
                  myPass = rs.getString(2);
                  System.out.println(myName + " " + myPass);

              }
          }
          catch (Exception e){
              System.out.println("error" + e);
          }
          con1.close();

}}
