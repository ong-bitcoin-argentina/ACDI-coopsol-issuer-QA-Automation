package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.ProducerService;

public class ProducerSteps extends PageSteps {
    @When("hago click en el boton \"+Nuevo Productor\"")
    public void newProductor(){
        ProducerService.newProducer();
    }

    @When("relleno los campos del formulario “Apellido”, “Nombre”, “DNI”, “Email”, “Número_de_teléfono”, “CUIT”, “DID”")
    public void fillProductor(){
        ProducerService.fillProducerDetails();
    }

    @When("hago click en el boton \"Guardar\"")
    public void saveProductor() {
        ProducerService.save();
    }

    @And("haber registrado un productor con anterioridad")
    public void crearProd(){
        ProducerService.goToProducers();
    }

    @And("hago click en el boton “Editar\"")
    public void edit(){
        ProducerService.getFirstRes();
        ProducerService.clickEdit();

    }

    @And("edito el formulario del productor con informacion válida")
    public void newDetails(){
        ProducerService.editProdDetails();
    }

     @Then("se edita exitosamente en la lista de productores")
    public void checkEdit(){
        ProducerService.filterNewProdDetails();
        ProducerService.checkNewProdDetails();
     }
}
