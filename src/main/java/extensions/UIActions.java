package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import utilities.Base;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("go to first page")
    public static void gotoFirstPage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    @Step("click on element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("change text in element")
    public static void update_text(WebElement elem, String s) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(s);
    }

    @Step("update text as human")
    public static void update_text_human(WebElement elem, String s) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        for (char ch : s.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("update element in drop down")
    public static void update_dropDown(WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("refresh browser")
    public static void refreshBrowser() {
        driver.navigate().refresh();
    }

    @Step("mouse hovering")
    public static void mouse_hover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();

    }

    @DataProvider(name = "data-provider")
    public static Object[][] getDataObject() {
        return new Object[][]{
                {"mac", "Apple MacBook Pro 13-inch"},
                {"Apple iCam", "Apple iCam"}
        };
    }

}



