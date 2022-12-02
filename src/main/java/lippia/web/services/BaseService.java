package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.LoginConstants;

public class BaseService extends ActionManager {
    public static void clickButton(String button) {
        switch (button){
            case "login":
                click(LoginConstants.LOGIN_BUTTON);
                break;
        }
    }
}
