package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.TemplatesConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.math.BigInteger;
import java.util.Random;



public class TemplatesService extends ActionManager {

    public static void goToTemplates(){
        click(TemplatesConstants.MENU_ITEM);
        Assert.assertTrue(isVisible(TemplatesConstants.NEW_TEMPLATE));
    }

    public static void clickNewTemplate(){
        click(TemplatesConstants.NEW_TEMPLATE);
    }

    public static void fillNameandEmisor(String name,String emisor) {
        BigInteger b = new BigInteger(256, new Random());
        setInput(TemplatesConstants.INPUT_NAME, name+b);
        click(TemplatesConstants.INPUT_EMISOR);
        for (int i = 1; ; i++) {
            if (getElement(TemplatesConstants.EMISOR_OPTION, String.valueOf(i)).getAttribute("title").equals(emisor)) {
                click(getElement(TemplatesConstants.EMISOR_OPTION, String.valueOf(i)));
                break;
            }



        }
        click(TemplatesConstants.ACCEPT_BUTTON);
    }

    public static void successMessage(String message){
        waitVisibility(TemplatesConstants.SUCCESS_MESSAGE);
        Assert.assertEquals(getText(TemplatesConstants.SUCCESS_MESSAGE),message);
    }

    public static void cleanTemplates(){
        try{
            click(TemplatesConstants.NEXT_BUTTON);
            for (int i = 2; ; i++) {
                try {
                    getElement(TemplatesConstants.DELETE_BUTTON, String.valueOf(i)).isDisplayed();
                } catch (Exception e) {
                    click(TemplatesConstants.DELETE_BUTTON, String.valueOf(i - 1));
                    break;
                }
            }
        }
        catch(Exception f){
            for (int i = 2; ; i++) {
                try {
                    getElement(TemplatesConstants.DELETE_BUTTON, String.valueOf(i)).isDisplayed();
                } catch (Exception e) {
                    click(TemplatesConstants.DELETE_BUTTON, String.valueOf(i - 1));
                    break;
                }
            }


        }
    }
    public static void acceptDeleteTemplate(){
        waitVisibility(TemplatesConstants.ACCEPT_BUTTON);
        click(TemplatesConstants.ACCEPT_BUTTON);
        waitInvisibility(TemplatesConstants.ACCEPT_BUTTON);

    }


    public static void clickEditCred(){
        click(TemplatesConstants.EDIT_BUTTON);
    }

    public static void clickCategory(){
        click(TemplatesConstants.CATEGORY);
    }

    public static void fillCat(String category){
        for (int i=1;i<7;i++){
            if(getText(TemplatesConstants.CAT_OPTIONS,String.valueOf(i)).equals(category)){
                click(TemplatesConstants.CAT_OPTIONS,String.valueOf(i));
                break;
            }
        }
    }
    public static void clickSave() {
        WebDriver driver = DriverManager.getDriverInstance();
        Actions action = new Actions(driver);
        action.moveToElement(getElement(TemplatesConstants.SAVE)).click().perform();
    }
}
