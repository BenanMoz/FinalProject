package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class NopCommerceWeb extends CommonOps {

    @Test(description = "Test 01 checking login action", groups = "tst")
    //should fail, will catch screenshot here
    @Description("this will check login action with username and pwd")
    public void test01_verifylogin() {
        WebFlows.login("ben2@gmail.com", "123456");
        Verifications.verifyTextIsDisplayed(mainPage.logout_btn);
        driver.get(getData("url"));
    }

    @Test(description = "checking simple action of hovering over computers item")
    @Description("this test will check hovering action on computers")
    public void test02_mouseHoverComputers() {
        UIActions.mouse_hover(categories.Computers, computers.desktops);
        Verifications.verifyTextinPage(desktop.PageTitle, "Desktops");
        driver.get(getData("url"));
    }

    @Test(description = "adding to cart" )
    @Description("adding to cart - software item")
    public void test03_goToWin8andAddToCart() {
        UIActions.mouse_hover(categories.Computers, computers.software);
        UIActions.click(softwarePage.win8_product);
        UIActions.click(win8addToCart.addtoCart);
        UIActions.refreshBrowser();
        Verifications.verifyTextinPage((shoppingCartPage.cart_label), "(1)");
        driver.get(getData("url"));
    }

    @Test(description = "checking categories in menu")
    @Description("verifying the 7 actions in menu bar")
    public void test04_verifyMenuBarElements() {
        Verifications.VisibilityOfElements(mainPage.menu_elements);
        driver.get(getData("url"));

    }

    //data driven(object-not csvData) - using data providers in other class
    @Test(dataProviderClass = UIActions.class, dataProvider = "data-provider")
    public void test05_searchProduct(String searchKey, String expectedResult) {
        UIActions.update_text_human(barPage.searchBar, searchKey);
        UIActions.click(barPage.searchButton);
        Verifications.existsOfElement(searchResultPage.searchResult, expectedResult);
        driver.get(getData("url"));
    }

    @Test(dataProviderClass = ManageDDT.class, dataProvider = "data-provider")
    public void test06_searchProduct(String searchKey, String expectedResult) {
        UIActions.update_text_human(barPage.searchBar, searchKey);
        UIActions.click(barPage.searchButton);
        Verifications.existsOfElement(searchResultPage.searchResult, expectedResult);
        driver.get(getData("url"));
    }



}