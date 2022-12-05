package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BarPage {

    @FindBy(how= How.XPATH , using = "//p[@text()='The product has been added to your ']")
    public WebElement menu_bar_list ;

    @FindBy(how = How.XPATH, using = "//input[@class='search-box-text ui-autocomplete-input']" )
    public WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//button[@class='button-1 search-box-button']")
    public WebElement searchButton;
}
