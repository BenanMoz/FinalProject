package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("get creds from DB")
    public static List<String> getCreds(String query) {
        List<String> creds = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            creds.add(rs.getString(1));
            creds.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("error while printing data" + e);

        }
        return creds;
    }
}



