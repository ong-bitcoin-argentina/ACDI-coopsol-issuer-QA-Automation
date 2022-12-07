package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.LoginConstants;
import lippia.web.constants.TemplatesConstants;
import lippia.web.constants.ValidacionDeIdentidadConstants;
import lippia.web.steps.ValidacionDeIdentidadSteps;

public class BaseService extends ActionManager {
    public static void clickButton(String button) {
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

            case "Tipos de credenciales":
                click(TemplatesConstants.MENU_ITEM);
                break;
        }
    }
}
