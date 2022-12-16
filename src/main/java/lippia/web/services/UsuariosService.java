package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.UsuariosConstants;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UsuariosService extends ActionManager {
    public static void completeForm(String name, String pass, String role) {
        setName(name);
        setInput(UsuariosConstants.PASSWORD_INPUT, pass);
        setRole(role);
    }

    public static void setName(String name){
        BaseService.RANDOM_NAME.set(TemplatesService.getRandom(name));
        setInput(UsuariosConstants.NAME_INPUT, BaseService.RANDOM_NAME.get());
    }

    public static void setRole(String role) {
        click(UsuariosConstants.ROLE_INPUT);
        click(UsuariosConstants.ROLE, role);
        click(UsuariosConstants.ROLE_INPUT);
    }

    public static void verifyNewUser(String name, String role) { //TODO arreglar name
        goToLastPage();
        String userName = BaseService.RANDOM_NAME.get().toLowerCase();
        waitInvisibilities(String.format(UsuariosConstants.USER_DATA, userName));
        List<WebElement> dataNewUser = getElements(String.format(UsuariosConstants.USER_DATA, userName));//TODO no encuentra al usuario
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dataNewUser.get(0).getText(), userName);
        softAssert.assertEquals(dataNewUser.get(1).getText(), role);
        softAssert.assertEquals(formatDate(dataNewUser.get(2).getText()), formatDate(String.valueOf(new Date())));

        softAssert.assertAll();
    }

    public static void goToLastPage(){
        List<WebElement> userPages = getElements(UsuariosConstants.USER_PAGES);
        WebElement lastPage = userPages.get(userPages.size() - 2);
        click(lastPage);
    }

    public static Date formatDate(String date){
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Date formatedDate;
        try {
            formatedDate = formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return formatedDate;
    }
}
