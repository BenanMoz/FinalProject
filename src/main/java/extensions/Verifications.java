package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Verifications extends CommonOps {
    @Step("text is displayed")
    public static void verifyTextIsDisplayed (WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
      assertTrue(elem.isDisplayed());
    }

    @Step("text in page")
    public static void verifyTextinPage(WebElement elem,String s) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),s);
    }

    @Step("visibility of elements - soft ")
    public static void VisibilityOfElements(List<WebElement> elems) {
        for (WebElement webelem : elems) {
            softAssert.assertTrue(webelem.isDisplayed(), "elem not displayed in menu bar");
        }
        softAssert.assertAll();
    }

    @Step("verify element exist in search")
    public static void existsOfElement(WebElement elem, String k) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), k);
    }

    }



