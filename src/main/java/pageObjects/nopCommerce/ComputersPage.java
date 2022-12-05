package pageObjects.nopCommerce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComputersPage {

    @FindBy(how= How.XPATH , using = "//ul[@class='sublist first-level']/li/a[@href='/notebooks']")
    public WebElement notebooks ;

    @FindBy(how= How.XPATH , using = "//ul[@class='sublist first-level']/li/a[@href='/desktops']")
    public WebElement desktops ;

    @FindBy(how= How.XPATH , using = "//ul[@class='sublist first-level']/li/a[@href='/software']")
    public WebElement software ;


}
