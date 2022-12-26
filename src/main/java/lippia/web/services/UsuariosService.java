package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.UsuariosConstants;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UsuariosService extends ActionManager {
    public static void completeForm(String name, String pass, String role) {
        setName(name);
        setRole(role);
        setInput(UsuariosConstants.PASSWORD_INPUT, pass);
    }

    public static void setName(String name) {
        BaseService.RANDOM_NAME.set(TemplatesService.getRandom(name));
        setInput(UsuariosConstants.NAME_INPUT, BaseService.RANDOM_NAME.get());
    }

    public static void setRole(String role) {
        click(UsuariosConstants.ROLE_INPUT);
        click(UsuariosConstants.ROLE, role);
        click(UsuariosConstants.ROLE_INPUT);
    }

    public static void verifyNewUser(String role) {
        goToLastPage();
        String userName = BaseService.RANDOM_NAME.get().toLowerCase();
        List<String> newUser = getNewUser(userName);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(newUser.get(0), userName);
        softAssert.assertEquals(newUser.get(1), role);
        softAssert.assertEquals(newUser.get(2), todayDate());

        softAssert.assertAll();
    }

    public static List<String> getNewUser(String userName) {
        List<WebElement> newUserDataList = getElements(UsuariosConstants.USER_DATA);

        List<String> newUser = new ArrayList<>();
        for (WebElement user : newUserDataList) {
            String[] userData = user.getText().split("(?<=\\d)(\\s)", 2);
            if (userData[0].equals(userName)) {
                newUser.add(userData[0]);
                String[] secondHalf = userData[1].split(" ");
                newUser.addAll(Arrays.asList(secondHalf));
                break;
            }
        }
        return newUser;

    }

    public static void goToLastPage() {
        BaseService.waitLocatedElement(UsuariosConstants.USER_PAGES, 1);
        List<WebElement> userPages = getElements(UsuariosConstants.USER_PAGES);
        WebElement lastPage = userPages.get(userPages.size() - 3);
        click(lastPage);
    }

    public static String todayDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate;
        formatedDate = formater.format(new Date());
        return formatedDate;
    }

    public static void clickGuardarButton() {
        waitVisibility(UsuariosConstants.GUARDAR_BUTTON);
        click(UsuariosConstants.GUARDAR_BUTTON);
    }
}
