package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.TemplatesService;

public class TemplatesSteps extends PageSteps {

    @Given("el admin esta logueado en la web de coopsol")
    public void doLogin(){
        TemplatesService.doLogin();
    }

    @When("el admin selecciona \"Tipos de credenciales\"")
    public void goToTemplate(){
        TemplatesService.goToTemplates();
    }

    @And("el admin da click en el boton \"Nuevo Template\"")
    public void clickNewTemplates(){
        TemplatesService.clickNewTemplate();
    }

    @And("el admin completa el Nombre (.*) y Emisor (.*)")
    public void fillNameandEmisor(String name,String emisor){
        TemplatesService.fillNameandEmisor(name,emisor);
    }

    @Then("se muestran un mensaje de \"Template creado exitosamente\"")
    public void checkResult(){
        TemplatesService.successMessage();
        TemplatesService.cleanTemplates();

    }


}
