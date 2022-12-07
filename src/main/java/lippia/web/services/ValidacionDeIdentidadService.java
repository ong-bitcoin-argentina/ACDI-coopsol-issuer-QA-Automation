package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.ValidacionDeIdentidadConstants;
import org.testng.Assert;

public class ValidacionDeIdentidadService extends ActionManager {
    public static void verifySolicitudesAprobadas() {
        waitVisibility(ValidacionDeIdentidadConstants.SOLICITUDES_APROBADAS);
        Assert.assertTrue(getElement(ValidacionDeIdentidadConstants.SOLICITUDES_APROBADAS).isDisplayed(), "No se encuentran las Solicitudes Aprobadas");
    }
}
