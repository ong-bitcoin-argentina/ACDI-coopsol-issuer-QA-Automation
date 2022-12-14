package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.PasswwordConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class PasswordService extends ActionManager {

    public static void setNewPassword(String newPass) {
        setPassword(newPass, PasswwordConstants.NEW_PASSWORD_INPUT);

    }

    public static void setRepeatNewPassword(String newPass) {
        setPassword(newPass, PasswwordConstants.REPEAT_NEW_PASSWORD_INPUT);
    }

    public static void setPassword(String pass, String locator){
        if (pass.equals("default")) {
            getElement(locator).sendKeys(Keys.CONTROL, Keys.BACK_SPACE);
            setInput(locator, PropertyManager.getProperty("pass"));

        } else {
            getElement(locator).sendKeys(Keys.CONTROL, Keys.BACK_SPACE);
            setInput(locator, pass);

        }
    }

    public static void verifyMessage(String message) {
        waitVisibility(String.format(PasswwordConstants.CHANGE_PASSWORD_MESSAGE, message));
        Assert.assertTrue(isVisible(String.format(PasswwordConstants.CHANGE_PASSWORD_MESSAGE, message)), String.format("No se encontro el mensaje: %s", message));
    }
}
