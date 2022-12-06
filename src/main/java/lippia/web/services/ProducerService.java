package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.ProducerConstants;
import org.openqa.selenium.*;
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

    public static void save()  {
        WebDriver driver = DriverManager.getDriverInstance();

        Actions action = new Actions(driver);
        action.moveToElement(getElement(ProducerConstants.SAVE_BUTTON)).click().perform();

    }

   public static void  successMessage(){
       waitInvisibility(ProducerConstants.NEW_PROD_MODAL);
       waitVisibility(ProducerConstants.MESSAGE);
       Assert.assertTrue(isVisible(ProducerConstants.MESSAGE));

   }

   public static void getFirstRes(){
        Assert.assertTrue(getElement(ProducerConstants.FIRST_RES).isDisplayed());

   }

   public static void clickEdit(){
        click(ProducerConstants.EDIT_BUTTON);
   }

   public static void editProdDetails(){
       getElement(ProducerConstants.APELLIDO).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.APELLIDO).sendKeys(Keys.DELETE);
       setInput(ProducerConstants.APELLIDO,PropertyManager.getProperty("prod.edit.apellido"));
       getElement(ProducerConstants.NOMBRE).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.NOMBRE).sendKeys(Keys.DELETE);
       setInput(ProducerConstants.NOMBRE,PropertyManager.getProperty("prod.edit.nombre"));
       getElement(ProducerConstants.DNI).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.DNI).sendKeys(Keys.DELETE);;
       setInput(ProducerConstants.DNI,PropertyManager.getProperty("prod.edit.dni"));
       getElement(ProducerConstants.EMAIL).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.EMAIL).sendKeys(Keys.DELETE);;
       setInput(ProducerConstants.EMAIL,PropertyManager.getProperty("prod.edit.email"));
       getElement(ProducerConstants.TEL).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.TEL).sendKeys(Keys.DELETE);;
       setInput(ProducerConstants.TEL,PropertyManager.getProperty("prod.edit.telefono"));
       getElement(ProducerConstants.CUIT).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.CUIT).sendKeys(Keys.DELETE);
       setInput(ProducerConstants.CUIT,PropertyManager.getProperty("prod.edit.cuit"));
       getElement(ProducerConstants.DID).sendKeys(Keys.CONTROL,"a");
       getElement(ProducerConstants.DID).sendKeys(Keys.DELETE);
       setInput(ProducerConstants.DID,PropertyManager.getProperty("prod.edit.DID"));
   }

   public static void filterNewProdDetails(){
        WebDriver driver = DriverManager.getDriverInstance();
        driver.navigate().refresh();
        waitVisibility(ProducerConstants.FILTER_FIRSTNAME);
       setInput(ProducerConstants.FILTER_LASTNAME,PropertyManager.getProperty("prod.edit.apellido"));
       setInput(ProducerConstants.FILTER_FIRSTNAME,PropertyManager.getProperty("prod.edit.nombre"));
       setInput(ProducerConstants.FILTER_DNI,PropertyManager.getProperty("prod.edit.dni"));
   }

   public static void checkNewProdDetails(){
        Assert.assertEquals(getText(ProducerConstants.PROD_LASTNAME),PropertyManager.getProperty("prod.edit.apellido"));
       Assert.assertEquals(getText(ProducerConstants.PROD_FIRSTNAME),PropertyManager.getProperty("prod.edit.nombre"));
       String dni = getText(ProducerConstants.PROD_DNI).replace(".","");
       Assert.assertEquals(dni,PropertyManager.getProperty("prod.edit.dni"));
       String cuit=getText(ProducerConstants.PROD_CUIT).replace(".","");
       Assert.assertEquals(cuit,PropertyManager.getProperty("prod.edit.cuit"));
       Assert.assertEquals(getText(ProducerConstants.PROD_DID),PropertyManager.getProperty("prod.edit.DID"));

   }


}