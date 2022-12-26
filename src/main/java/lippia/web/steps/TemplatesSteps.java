package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.TemplatesService;

public class TemplatesSteps extends PageSteps {



    @And("el admin da click en el boton \"Nuevo Template\"")
    public void clickNewTemplates(){
        TemplatesService.clickNewTemplate();
    }

    @And("el admin completa el Nombre (.*) y Emisor (.*)")
    public void fillNameandEmisor(String name,String emisor){
        TemplatesService.fillNameandEmisor(name,emisor);
    }

    @Then("se muestran un mensaje de {string}")
    public void checkResult(String message){
        TemplatesService.successMessage(message);
        if (message.equals("Template creado exitosamente")){
            TemplatesService.cleanTemplates();
            TemplatesService.acceptDeleteTemplate();
        }

    }
    @When("el admin hace clic en \"Eliminar\" un tipo de credencial")
    public void deleteTemplate(){
        TemplatesService.cleanTemplates();
    }

    @And("el admin hace clic en aceptar")
    public void acceptDelete(){
        TemplatesService.acceptDeleteTemplate();
    }


    @And("el admin tiene tipos de credenciales")
    public void goToCred(){
        TemplatesService.goToTemplates();
    }

    @And("el admin selecciona el boton \"Editar\" al costado derecho del template del primer resultado.")
    public void EditCred(){TemplatesService.clickEditCred();}

    @And("el admin hace click en la categoria de la credencial")
    public void clickCat(){TemplatesService.clickCategory();}

    @And("el admin elige la Categoria (.*)")
    public void fillCat(String category){TemplatesService.fillCat(category);}

    @And("el admin da click en \"Guardar\"")
    public void saveCat(){TemplatesService.clickSave();}


}
