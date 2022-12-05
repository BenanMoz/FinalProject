package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesktopsPage {

    @FindBy(how= How.XPATH , using = "//div[@class='page-title']")
    public WebElement PageTitle ;

}
