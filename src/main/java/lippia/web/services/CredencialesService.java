package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.CredencialesConstants;
import lippia.web.constants.ValidacionDeIdentidadConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class CredencialesService extends ActionManager {
    public static void selectType(String type) {
        click(CredencialesConstants.HIDE);
        waitVisibility(CredencialesConstants.TIPO);
        click(CredencialesConstants.TIPO);
        click(CredencialesConstants.TIPO_OPTIONS,type);



        }


}
