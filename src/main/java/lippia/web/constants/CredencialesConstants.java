package lippia.web.constants;

import org.openqa.selenium.WebElement;

public class CredencialesConstants {

    public static final String HIDE="xpath://*[@id=\"root\"]/div/div/div/div/div/div[1]/div[1]";
    public static final String TIPO="xpath://*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/button[1]";
    public static final String TIPO_OPTIONS = "xpath://div[contains(@class,'ant-dropdown')]/ul/li[%s]/span";

    public static final String NOMBRE="xpath://*[@id='rc-tabs-0-panel-1']/div/div[1]/span[1]/input";

    public static final String APELLIDO="xpath://*[@id='rc-tabs-0-panel-1']/div/div[1]/span[2]/input";

    public static final String DESDE="xpath://*[@id='rc-tabs-0-panel-1']/div/div[1]/div[1]/div/input";

    public static final String HASTA="xpath://*[@id='rc-tabs-0-panel-1']/div/div[1]/div[2]/div/input";

    public static final String BUSCAR="xpath://*[@id='rc-tabs-0-panel-1']/div/div[1]/button[2]";

    public static final String CHECK_NOMBRE="xpath://*[@id='rc-tabs-0-panel-1']/div/div[2]/div/div/div/div/div/table/tbody/tr[%s]/td[3]";

    public static final String CHECK_TIPO="xpath://*[@id='rc-tabs-0-panel-1']/div/div[2]/div/div/div/div/div/table/tbody/tr[%s]/td[4]";

    public static final String CHECK_DESDE="xpath://*[@id='rc-tabs-0-panel-1']/div/div[2]/div/div/div/div/div/table/tbody/tr[%s]/td[5]";

    public static final String CHECK_HASTA="xpath://*[@id='rc-tabs-0-panel-1']/div/div[2]/div/div/div/div/div/table/tbody/tr[%s]/td[6]";

    public static final String GUARDAR_BUTTON = "xpath://*[contains(text(),'Guardar')]";
    public static final String INPUT_MESSAGE = "xpath://*[text()='%s']/*[text()='%s']";
    public static final String NUEVA_CREDENCIAL_BUTTON = "xpath://*[text()=\"+ Crear nueva credencial\"]";
}
