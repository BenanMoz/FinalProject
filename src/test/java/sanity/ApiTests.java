package sanity;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import org.json.JSONObject;

@Listeners(utilities.Listeners.class)
public class ApiTests extends CommonOps {

    RequestSpecification httpRequest;
    Response response;
    String url = getData("url_api");

    @Test(description = "get all users")
    @Description("get Action - get all users")
    public void test01_Api() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        response = httpRequest.get("api/users?page=2");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description =  "Test :post-create new user")
    @Description("create new user")
    public void test02_Post() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("name", "morpheus");
        jsonParams.put("job", "leader");
        httpRequest.body(jsonParams.toString());
        response = httpRequest.post("/api/users");
        String ab = response.getBody().peek().prettyPrint();
        JSONObject new1 = new JSONObject(ab);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(description = "Test03:remove one user") //Delete
    @Description("Delete action - delete one user")
    public void test03_Remove() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        response = httpRequest.delete("api/users/1");
        System.out.println(response.getStatusCode());
    }

    @Test (description = "Test04: get specific user")
    @Description("get specific user - should success - user 100 not exist")
    public void test04_getSpecificUser() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        response = httpRequest.get("/api/users/100");
        Assert.assertEquals(response.getStatusCode(),404);
    }
}