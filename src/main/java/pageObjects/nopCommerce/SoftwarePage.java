package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SoftwarePage {
    @FindBy(how= How.XPATH , using = "//div[@class='picture']/a/img[@alt='Picture of Windows 8 Pro']")
    public WebElement win8_product ;


}









