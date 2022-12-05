package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.nopCommerce.*;

public class ManagePages extends Base {

    public static void initNopCommerce() {
        nopCommercelogin = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        categories = PageFactory.initElements(driver, CategoriesPage.class);
        computers = PageFactory.initElements(driver, ComputersPage.class);
        desktop = PageFactory.initElements(driver, DesktopsPage.class);
        softwarePage = PageFactory.initElements(driver,SoftwarePage.class);
        win8addToCart = PageFactory.initElements(driver,Win8prodtoCartPage.class);
        barPage = PageFactory.initElements(driver,BarPage.class);
        shoppingCartPage = PageFactory.initElements(driver,ShoppingCartPage.class);
        searchResultPage = PageFactory.initElements(driver,SearchResultPage.class);
    }

}
