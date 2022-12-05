package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    public String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    @BeforeClass
    @Parameters("PlatformName")
    public void startSession(String PlatformName) {
         Platform = PlatformName;
        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (Platform.equalsIgnoreCase("api"))
             initApi();
        else
            throw new RuntimeException("invalid env");
        ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
    }

    @BeforeMethod
    public void before_method(Method method1) {
        if(!getData("PlatformName").equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method1.getName());
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }

    /*@AfterMethod
    public static void gotoFirstPage() {
           driver.get("https://demo.nopcommerce.com/");
    }*/

    @AfterClass
    public void closeSession() {
        if(!Platform.equalsIgnoreCase("api")) {
            driver.quit();}
    }


    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initialFireFoxDriver();
        else if (browserType.equalsIgnoreCase("IE"))
            driver = initIEDriver();
        else
            throw new RuntimeException("invalid browser");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.get("https://demo.nopcommerce.com/login");
        ManagePages.initNopCommerce();
        action = new Actions(driver);
        softAssert = new SoftAssert();
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;

    }

    public static WebDriver initialFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;

    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initApi(){

    }
}







