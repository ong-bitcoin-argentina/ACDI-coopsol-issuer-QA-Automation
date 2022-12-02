package lippia.web.constants;

import org.openqa.selenium.WebElement;

public class LoginConstants {
    public static final String USER_INPUT = "id:username";
    public static final String PASSWORD_INPUT = "id:password";
    public static final String LOGIN_BUTTON = "xpath://*[@class='ButtonLogin']/button";
    public static final String CREDENCIALES_PAGE = "xpath://h1[contains(text(),'Credenciales')]";
    public static final String MESSAGE_ERROR = "xpath://*[contains(text(),'Campo obligatorio')]";
}
