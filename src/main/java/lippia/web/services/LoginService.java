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

    public static void verifyMessage(String message) {
        waitVisibility(String.format(LoginConstants.MESSAGE_ERROR, message));
        Assert.assertTrue(getElement(String.format(LoginConstants.MESSAGE_ERROR, message)).isDisplayed(), "No se encontro el mensaje");
    }

    public static void login() {
        navegarWeb();
        setUser(PropertyManager.getProperty("user"));
        setPassword(PropertyManager.getProperty("pass"));
        BaseService.clickButton("login");
    }

    public static void verifyLogout() {
        BaseService.waitLocatedElement(LoginConstants.LOGIN_BUTTON, 25);
        Assert.assertTrue(getElement(LoginConstants.LOGIN_BUTTON).isDisplayed(), "No se encontro la pagina de login");
    }
}
