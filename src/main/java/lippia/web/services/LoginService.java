package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.LoginConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LoginService extends ActionManager {
    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void setUser(String user) {
        setInput(LoginConstants.USER_INPUT, user);
    }

    public static void setPassword(String pass) {
        setInput(LoginConstants.PASSWORD_INPUT, pass);
    }

    public static void verifyLogin() {
        waitPresences(LoginConstants.CREDENCIALES_PAGE);
        Assert.assertTrue(getElement(LoginConstants.CREDENCIALES_PAGE).isDisplayed(), "No se encontro la pagina credenciales");
    }

    public static void verifyMessage() {
        waitVisibility(LoginConstants.MESSAGE_ERROR);
        Assert.assertTrue(getElement(LoginConstants.MESSAGE_ERROR).isDisplayed(), "No se encontro el mensaje");
    }
}
