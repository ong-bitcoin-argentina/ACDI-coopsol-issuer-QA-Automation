package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.ValidacionDeIdentidadConstants;
import org.testng.Assert;

public class ValidacionDeIdentidadService extends ActionManager {
    public static void verifySolicitudes(String solicitudes) {
        switch (solicitudes) {
            case "Pendiente":
                waitVisibility(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "1");
                Assert.assertTrue(getElement(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "1").isDisplayed(), String.format("No se encuentran las Solicitudes %s", solicitudes));
                break;
            case "Aprobada":
                waitVisibility(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "2");
                Assert.assertTrue(getElement(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "2").isDisplayed(), String.format("No se encuentran las Solicitudes %s", solicitudes));
                break;
            case "Rechazada":
                waitVisibility(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "3");
                Assert.assertTrue(getElement(ValidacionDeIdentidadConstants.SOLICITUDES_PANEL, "3").isDisplayed(), String.format("No se encuentran las Solicitudes %s", solicitudes));
                break;
        }
    }
}
