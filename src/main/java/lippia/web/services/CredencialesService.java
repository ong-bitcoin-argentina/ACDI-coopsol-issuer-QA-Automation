package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.CredencialesConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CredencialesService extends ActionManager {

    public static ThreadLocal<String> tipo = new ThreadLocal<>();
    public static ThreadLocal<String> firstname = new ThreadLocal<>();
    public static ThreadLocal<String> lastname = new ThreadLocal<>();
    public static ThreadLocal<String> from = new ThreadLocal<>();
    public static ThreadLocal<String> todate = new ThreadLocal<>();

    public static void selectType(String type) {
        tipo.set(type);
        WebDriver driver = DriverManager.getDriverInstance();
        Actions actions = new Actions(driver);
        click(CredencialesConstants.HIDE);
        waitVisibility(CredencialesConstants.TIPO);
        click(CredencialesConstants.TIPO);
        for (int i = 1; ; ++i) {
            if (getText(CredencialesConstants.TIPO_OPTIONS, String.valueOf(i)).equals(type)) {
                actions.moveToElement(getElement(CredencialesConstants.TIPO_OPTIONS, String.valueOf(i))).click().perform();
                break;
            }
        }

    }

    public static void selectFilters(String nombre, String apellido, String desde, String hasta) {
        firstname.set(nombre);
        lastname.set(apellido);
        from.set(desde);
        todate.set(hasta);
        setInput(CredencialesConstants.NOMBRE, nombre);
        setInput(CredencialesConstants.APELLIDO, apellido);
        setInput(CredencialesConstants.DESDE, desde);
        setInput(CredencialesConstants.HASTA, hasta);
        getElement(CredencialesConstants.HASTA).sendKeys(Keys.ENTER);

    }

    public static void clickBuscar() {
        WebDriver driver = DriverManager.getDriverInstance();
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(CredencialesConstants.BUSCAR)).click().perform();
        waitVisibility(CredencialesConstants.NOMBRE, String.valueOf(2));
    }

    public static void checkResults() throws ParseException {
        String nombreApellido = firstname.get() + " " + lastname.get();
        Date desde = new SimpleDateFormat("dd/MM/yyyy").parse(from.get());
        Date hasta = new SimpleDateFormat("dd/MM/yyyy").parse(todate.get());
        for (int i = 2; ; i++) {
            String crea = getText(CredencialesConstants.CHECK_DESDE, String.valueOf(i)).substring(0, 10);
            String emi = getText(CredencialesConstants.CHECK_HASTA, String.valueOf(i)).substring(0, 10);
            Date creacion = new SimpleDateFormat("dd/MM/yyyy").parse(crea);
            Date emision = new SimpleDateFormat("dd/MM/yyyy").parse(emi);
            if ((!Objects.equals(tipo.get(), "")) && (!Objects.equals(firstname.get(), "")) &&
                    (!Objects.equals(lastname.get(), "")) && (!Objects.equals(from.get(), "")) &&
                    (!Objects.equals(todate.get(), ""))) {
                if (getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).equals(nombreApellido) &&
                        getText(CredencialesConstants.CHECK_TIPO, String.valueOf(i)).equals(tipo.get()) &&
                        ((creacion.after(desde) || creacion.equals(desde)) && (creacion.before(hasta) || creacion.equals(hasta))) &&
                        ((emision.after(desde) || emision.equals(desde)) && (emision.before(hasta) || emision.equals(hasta)))) {
                    break;
                }
                else if((!Objects.equals(firstname.get(), "")) &&
                        (!Objects.equals(lastname.get(), "")) && (!Objects.equals(from.get(), "")) &&
                        (!Objects.equals(todate.get(), ""))){
                    if (getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).equals(nombreApellido) &&
                            ((creacion.after(desde) || creacion.equals(desde)) && (creacion.before(hasta) || creacion.equals(hasta))) &&
                            ((emision.after(desde) || emision.equals(desde)) && (emision.before(hasta) || emision.equals(hasta)))) {
                        break;
                    }
                }
                else if((!Objects.equals(lastname.get(), "")) && (!Objects.equals(from.get(), "")) &&
                        (!Objects.equals(todate.get(), ""))){
                    if (getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).contains(lastname.get()) &&
                            ((creacion.after(desde) || creacion.equals(desde)) && (creacion.before(hasta) || creacion.equals(hasta))) &&
                            ((emision.after(desde) || emision.equals(desde)) && (emision.before(hasta) || emision.equals(hasta)))) {
                        break;
                    }
                }
                else if((!Objects.equals(from.get(), "")) && (!Objects.equals(todate.get(), ""))){
                    if (((creacion.after(desde) || creacion.equals(desde)) && (creacion.before(hasta) || creacion.equals(hasta))) &&
                            ((emision.after(desde) || emision.equals(desde)) && (emision.before(hasta) || emision.equals(hasta)))) {
                        break;
                    }
                }
                else if(!Objects.equals(todate.get(), "")){
                    if ((creacion.before(hasta) || creacion.equals(hasta)) &&
                            (emision.before(hasta) || emision.equals(hasta))) {
                        break;
                    }
                }
                else if(Objects.equals(from.get(),"") && Objects.equals(todate.get(), "")){
                    if (getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).equals(nombreApellido) &&
                            getText(CredencialesConstants.CHECK_TIPO, String.valueOf(i)).equals(tipo.get()) ) {
                        break;
                    }
                }
            }
        }
    }
}





