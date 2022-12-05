package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage
{
    @FindBy (how = How.XPATH, using = "//h2[@class='product-title']")
    public WebElement searchResult;
}
