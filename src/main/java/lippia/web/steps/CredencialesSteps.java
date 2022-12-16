package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.When;
import lippia.web.services.BaseService;
import lippia.web.services.CredencialesService;

public class CredencialesSteps extends PageSteps {
   @When("el admin completa el filtro \"Tipo:\" (.*), \"Nombre:\" (.*), \"Apellido:\" (.*), \"Desde:\" (.*), \"Hasta:\" (.*)")
   public void filterCredential(String type, String nombre, String apellido, String desde,String hasta)  {
       CredencialesService.selectType(type);
   }
}
