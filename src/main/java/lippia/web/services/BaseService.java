package lippia.web.services;

import com.crowdar.core.LocatorManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseService extends ActionManager {

    public static final ThreadLocal<String> RANDOM_NAME = new ThreadLocal<String>();

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
                clickGenericButton("Actividades");
                break;
            case "Tipos de credenciales":
                click(TemplatesConstants.MENU_ITEM);
                break;
            case "Productores":
                clickGenericButton("Productores");
                break;
            case "Usuarios":
                clickGenericButton("Usuarios");
                break;
            case "+ Nuevo Usuario":
                click(UsuariosConstants.NEW_USER_BUTTON);
                break;
            case "Guardar":
                clickGenericButton("Guardar");
                break;
            case "Configuración":
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Configuración");
                break;
            case "Actualizar contraseña":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, "Actualizar contraseña");
                break;
            case "Credenciales":
                clickGenericButton("Credenciales");
                break;
            case "Credenciales en uso":
                waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON,"Credenciales en uso");
                click(ValidacionDeIdentidadConstants.GENERIC_BUTTON,"Credenciales en uso");
                break;
            case "+ Crear nueva credencial":
                click(CredencialesConstants.NUEVA_CREDENCIAL_BUTTON);
                break;

        }
    }

    public static void clickGenericButton(String button){
        waitVisibility(ValidacionDeIdentidadConstants.GENERIC_BUTTON, button);
        click(ValidacionDeIdentidadConstants.GENERIC_BUTTON, button);
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

