package lippia.web.constants;

import org.openqa.selenium.WebElement;

public class UsuariosConstants {
    public static final String FORM_INPUT = "xpath://*[contains(text(),'%s')]/input";
    public static final String NAME_INPUT = "xpath://*[contains(text(),'Nombre')]/input";
    public static final String PASSWORD_INPUT = "xpath://*[@name='password']";
    public static final String NEW_USER_BUTTON = "xpath://*[@class='ButtonPrimary primary']/p";
    public static final String ROLE_INPUT = "xpath:/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/form/div[3]/div/div/div";
    public static final String ROLE = "xpath://*[@title='%s']/div";
    public static final String GUARDAR_BUTTON = "xpath:/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/form/div[4]/button";
    public static final String USER_DATA = "xpath://div/table/tbody/tr";
    public static final String USER_PAGES = "xpath://*[@class=\"ant-pagination ant-table-pagination ant-table-pagination-right\"]/li";
}
