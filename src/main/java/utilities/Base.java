package utilities;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.nopCommerce.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static String Platform;

    //Web
    protected static WebDriver driver;

    //DataBase
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Api
    protected static JSONObject jsonParams = new JSONObject();
    protected static JsonPath Jp;

    //pages
    protected static LoginPage nopCommercelogin;
    protected static MainPage mainPage;
    protected static CategoriesPage categories;
    protected  static ComputersPage computers;
    protected  static DesktopsPage desktop;
    protected  static Win8prodtoCartPage win8addToCart;
    protected static SoftwarePage softwarePage;
    protected static BarPage barPage;
    protected static ShoppingCartPage shoppingCartPage;
    protected static SearchResultPage searchResultPage;



}
