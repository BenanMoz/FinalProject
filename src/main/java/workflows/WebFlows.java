package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {


    @Step("login action")
    public static void login(String email, String password) {
        UIActions.update_text(nopCommercelogin.Email, email);
        UIActions.update_text(nopCommercelogin.Password, password);
        // wait.until(ExpectedConditions.elementToBeClickable(nopCommercelogin.login));
        UIActions.click(nopCommercelogin.login);
    }

    @Step("login with DB")
    public static void loginDB() {
        List<String> cred = DBActions.getCreds("");
        UIActions.update_text(nopCommercelogin.Email, cred.get(0));
        UIActions.update_text(nopCommercelogin.Password, cred.get(1));
        UIActions.click(nopCommercelogin.login);
    }
}
