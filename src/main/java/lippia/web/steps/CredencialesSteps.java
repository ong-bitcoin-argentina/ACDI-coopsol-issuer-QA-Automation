package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.CredencialesService;

import java.text.ParseException;
import java.util.Objects;

public class CredencialesSteps extends PageSteps {
    @When("el admin completa el filtro \"Tipo:\" (.*), \"Nombre:\" (.*), \"Apellido:\" (.*), \"Desde:\" (.*), \"Hasta:\" (.*)")
    public void filterCredential(String type, String nombre, String apellido, String desde, String hasta) {
        if (!Objects.equals(type, "")) {
            CredencialesService.selectType(type);
        }
        CredencialesService.selectFilters(nombre, apellido, desde, hasta);
        CredencialesService.clickBuscar();
    }

    @Then("se muestran los resultados de acuerdo al criterio de busqueda")
    public void checkResults() throws ParseException {
        CredencialesService.checkResults();
    }

    @And("relleno los campos requeridos de (.*),(.*),(.*),(.*) con informacion valida")
    public void fillInformation(String did, String nombre,String apellido, String actividad) throws InterruptedException {
        CredencialesService.fillInformation(did, nombre,apellido, actividad);
    }

    @When("el admin hace click en  \"+ Crear nueva credencial\"")
    public void clickNuevaCredencial() {
        CredencialesService.clickNuevaCredencial();

    }

    @And("el admin hace click en \"Guardar\"")
    public void saveCredencial(){
        CredencialesService.saveCred();
    }
    @Then("el campo vacio muesta el mensaje de error  \"Requerido\"")
    public void checkRequerido(){
        CredencialesService.checkMessage();
    }

    @When("el admin selecciona el motivo (.*)")
    public void selectMotivo(String motivo){
        CredencialesService.selectMotive(motivo);
    }

}

