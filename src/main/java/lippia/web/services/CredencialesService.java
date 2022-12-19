package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.CredencialesConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        List<String> list = new ArrayList<>();
        List<String> check = new ArrayList<>();
        for (int i = 2; ; i++) {
            String crea = getText(CredencialesConstants.CHECK_DESDE, String.valueOf(i)).substring(0, 10);
            String emi = getText(CredencialesConstants.CHECK_HASTA, String.valueOf(i)).substring(0, 10);
            Date creacion = new SimpleDateFormat("dd/MM/yyyy").parse(crea);
            Date emision = new SimpleDateFormat("dd/MM/yyyy").parse(emi);
            list.add(tipo.get());
            list.add(firstname.get());
            list.add(lastname.get());
            list.add(from.get());
            list.add(todate.get());
            list.removeIf(cadena -> Objects.equals(cadena, null));
            for (String cadena : list) {
                if (cadena.equals(tipo.get()) & getText(CredencialesConstants.CHECK_TIPO, String.valueOf(i)).equals(tipo.get())) {
                    check.add("check");
                } else if (cadena.equals(firstname.get()) & getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).contains(firstname.get())) {
                    check.add("check");
                } else if (cadena.equals(lastname.get()) & getText(CredencialesConstants.CHECK_NOMBRE, String.valueOf(i)).contains(lastname.get())) {
                    check.add("check");
                } else if (cadena.equals(from.get())) {
                    Date desde = new SimpleDateFormat("dd/MM/yyyy").parse(from.get());
                    if ((creacion.after(desde) || creacion.equals(desde)) && (emision.after(desde) || emision.equals(desde))) {
                        check.add("check");
                    }
                } else if (cadena.equals(todate.get())) {
                    Date hasta = new SimpleDateFormat("dd/MM/yyyy").parse(todate.get());
                    if ((creacion.before(hasta) || creacion.equals(hasta)) && (emision.before(hasta) || emision.equals(hasta))) {
                        check.add("check");
                    }
                }

            }
            if (Objects.equals(check.size(), list.size()) && check.stream().allMatch(val -> val.equals("check"))) {
                break;
            } else {
                check.clear();
            }

        }


    }

}






