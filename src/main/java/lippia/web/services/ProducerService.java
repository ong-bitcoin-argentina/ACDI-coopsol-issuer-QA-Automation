package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ProducerConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class ProducerService extends ActionManager {
    public static void doLogin() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
        setInput(ProducerConstants.USER_INPUT, PropertyManager.getProperty("user"));
        setInput(ProducerConstants.PASS_INPUT, PropertyManager.getProperty("pass"));
        click(ProducerConstants.LOGIN_BUTTON);
        waitVisibility(ProducerConstants.MENU_ITEM);
        Assert.assertTrue(isVisible(ProducerConstants.MENU_ITEM));
    }

    public static void goToProducers(){
        click(ProducerConstants.MENU_ITEM);
        Assert.assertTrue(isVisible(ProducerConstants.NEW_PRODUCER));
    }

    public static void newProducer(){
        click(ProducerConstants.NEW_PRODUCER);
        waitVisibility(ProducerConstants.NEW_PROD_MODAL);
        Assert.assertTrue(isVisible(ProducerConstants.NEW_PROD_MODAL));

    }

    public static void fillProducerDetails(){
        setInput(ProducerConstants.APELLIDO,PropertyManager.getProperty("prod.apellido"));
        setInput(ProducerConstants.NOMBRE,PropertyManager.getProperty("prod.nombre"));
        setInput(ProducerConstants.DNI,PropertyManager.getProperty("prod.dni"));
        setInput(ProducerConstants.EMAIL,PropertyManager.getProperty("prod.email"));
        setInput(ProducerConstants.TEL,PropertyManager.getProperty("prod.telefono"));
        setInput(ProducerConstants.CUIT,PropertyManager.getProperty("prod.cuit"));
        setInput(ProducerConstants.DID,PropertyManager.getProperty("prod.DID"));

    }

    public static void save() throws InterruptedException {
        WebDriver driver = DriverManager.getDriverInstance();
        Actions action = new Actions(driver);
        action.moveToElement(getElement(ProducerConstants.SAVE_BUTTON)).click().perform();
        waitInvisibility(ProducerConstants.NEW_PROD_MODAL);
        waitVisibility(ProducerConstants.MESSAGE);
        Assert.assertTrue(isVisible(ProducerConstants.MESSAGE));

    }
}