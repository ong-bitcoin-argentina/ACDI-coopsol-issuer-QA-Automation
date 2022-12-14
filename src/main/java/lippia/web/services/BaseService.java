package lippia.web.services;

import com.crowdar.core.LocatorManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.LoginConstants;
import lippia.web.constants.ProducerConstants;
import lippia.web.constants.TemplatesConstants;
import lippia.web.constants.ValidacionDeIdentidadConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseService extends ActionManager {
    public static void clickButton(String button) {
        switch (button) {
            case "login":
                click(LoginConstants.LOGIN_BUTTON);
                break;
            case "Validación de identidades":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Validación de identidades");
                break;
            case "Solicitudes Aprobadas":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Solicitudes Aprobadas");
                break;
            case "Cerrar sesión":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Cerrar sesión");
                break;
            case "Actividades":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actividades");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actividades");
                break;
            case "Tipos de credenciales":
                click(TemplatesConstants.MENU_ITEM);
                break;
            case "Productores":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Productores");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Productores");
                break;
            case "Configuración":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Configuración");
                break;
            case "Actualizar contraseña":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                break;

        }
    }

    public static void waitLocatedElement(String locatorElement, int time, String... locatorReplacementValue) {
        try {
            By locator = LocatorManager.getLocator(locatorElement, locatorReplacementValue);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance(), time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("No se encontro el elemento" + e.getMessage());
        }
    }
}

