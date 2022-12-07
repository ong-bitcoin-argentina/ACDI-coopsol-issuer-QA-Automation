package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.ActivitiesConstants;
import org.testng.Assert;

public class ActivitiesService extends ActionManager {

    public static void checkActResult(){
        waitVisibility(ActivitiesConstants.ACT_LIST);
        Assert.assertEquals(getText(ActivitiesConstants.ACT_LIST),"Listado de actividades");
    }
}
