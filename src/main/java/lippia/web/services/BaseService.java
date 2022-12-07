package lippia.web.services;

import com.crowdar.core.LocatorManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.LoginConstants;
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
            case "Validacion de Identidades":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Validacion de Identidades");
                break;
            case "Solicitudes Aprobadas":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Solicitudes Aprobadas");
                break;
            case "Cerrar sesión":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Cerrar sesión");
                break;
            case "Actividades":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON,"Actividades");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON,"Actividades");
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

