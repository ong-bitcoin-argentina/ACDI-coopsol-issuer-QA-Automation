package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.ActivitiesConstants;
import lippia.web.constants.LoginConstants;
import lippia.web.constants.ValidacionDeIdentidadConstants;


public class BaseService extends ActionManager {
    public static void clickButton(String button) throws InterruptedException {
        switch (button) {
            case "login":
                click(LoginConstants.LOGIN_BUTTON);
                break;
            case "Validacion de Identidades":
                click(ValidacionDeIdentidadConstants.VALIDACION_IDENTIDADES_BUTTON);
                break;
            case "Solicitudes Aprobadas":
                click(ValidacionDeIdentidadConstants.SOLICITUDES_APROBADAS_BUTTON);
                break;
            case "Actividades":
                waitVisibility(ActivitiesConstants.ACTIVITIES);
                Thread.sleep(3000);
                click(ActivitiesConstants.ACTIVITIES);
                Thread.sleep(3000);
                break;
        }
    }
}
