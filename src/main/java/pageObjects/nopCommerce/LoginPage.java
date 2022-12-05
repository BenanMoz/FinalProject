package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID , using = "Email")
    public WebElement Email;

    @FindBy (how=How.ID , using = "Password")
    public WebElement Password;

    @FindBy (how=How.XPATH , using = "//button[@class='button-1 login-button']")
    public WebElement login ;


}
