package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.BaseService;
import lippia.web.services.CredencialesService;

import java.text.ParseException;
import java.util.Objects;

public class CredencialesSteps extends PageSteps {
   @When("el admin completa el filtro \"Tipo:\" (.*), \"Nombre:\" (.*), \"Apellido:\" (.*), \"Desde:\" (.*), \"Hasta:\" (.*)")
   public void filterCredential(String type, String nombre, String apellido, String desde,String hasta) throws ParseException {
       if (!Objects.equals(type, "")){
           CredencialesService.selectType(type);
       }
       CredencialesService.selectFilters(nombre,apellido,desde,hasta);
       CredencialesService.clickBuscar();
   }

   @Then("se muestran los resultados de acuerdo al criterio de busqueda")
    public void checkResults() throws ParseException {
       CredencialesService.checkResults();
   }

    @Then("^los campos '(.*)', '(.*)' y '(.*)' muestran el mensaje de error '(.*)'$")
    public void losCamposYMuestranElMensajeDeError(String didInput, String nombreInput, String apellidoInput, String message) {
       CredencialesService.verifyMessage(didInput, nombreInput, apellidoInput, message);
    }
}
