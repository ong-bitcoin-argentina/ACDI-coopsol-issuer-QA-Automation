package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class testService extends ActionManager {
    public static void navigateTest(){
        navigateTo(PropertyManager.getProperty("web-app.url"));
    }
}
