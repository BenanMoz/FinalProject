package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoriesPage {

        @FindBy(how= How.XPATH , using = "//ul[@class='top-menu notmobile']/li")
        public WebElement menu_bar_list ;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[1]")
        public WebElement Computers;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[2]")
        public WebElement Electronics;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[3]")
        public WebElement Apparel;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[4]")
        public WebElement Digital_downloads;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[5]")
        public WebElement Books;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[6]")
        public WebElement Jewelery;

        @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[7]")
        public WebElement Gift_cards;

}







