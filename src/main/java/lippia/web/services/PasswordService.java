package lippia.web.services;

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
        getElement(PasswwordConstants.NEW_PASSWORD_INPUT).sendKeys(Keys.CONTROL,Keys.BACK_SPACE);
        setInput(PasswwordConstants.NEW_PASSWORD_INPUT, newPass);
    }

    public static void setRepeatNewPassword(String newPass) {
        getElement(PasswwordConstants.REPEAT_NEW_PASSWORD_INPUT).sendKeys(Keys.CONTROL,Keys.BACK_SPACE);
        setInput(PasswwordConstants.REPEAT_NEW_PASSWORD_INPUT, newPass);
    }

    public static void verifyMessage(String message) {
        waitVisibility(String.format(PasswwordConstants.CHANGE_PASSWORD_MESSAGE, message));
        Assert.assertTrue(isVisible(String.format(PasswwordConstants.CHANGE_PASSWORD_MESSAGE, message)), "No se encontro el mensaje");
    }
}
