package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.BaseService;
import lippia.web.services.ValidacionDeIdentidadService;
import org.openqa.selenium.WebElement;

public class ValidacionDeIdentidadSteps extends PageSteps {
    @And("^el admin se encuentra en \"(.*)\"$")
    public void elAdminSeEncuentraEn(String button) {
        BaseService.clickButton(button);
    }

    @When("^el admin selecciona \"(.*)\"$")
    public void elAdminSelecciona(String button) {
        BaseService.clickButton(button);
    }

    @Then("se visualilza el tab Solicitudes Aprobadas")
    public void seVisualilzaElTabSolicitudesAprobadas() {
        ValidacionDeIdentidadService.verifySolicitudesAprobadas();
    }
}