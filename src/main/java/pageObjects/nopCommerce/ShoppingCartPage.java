package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage {
    @FindBy(how= How.XPATH , using = "//span[@class='cart-qty']")
    public WebElement cart_label ;

}
