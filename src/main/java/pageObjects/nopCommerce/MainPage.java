package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy (how=How.XPATH , using = "//a[@class='ico-logout']")
    public WebElement logout_btn ;

    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li")
    public List<WebElement> menu_elements;



}
