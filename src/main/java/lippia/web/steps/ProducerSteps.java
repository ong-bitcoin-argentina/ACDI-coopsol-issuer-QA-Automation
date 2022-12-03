package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lippia.web.services.ProducerService;

public class ProducerSteps extends PageSteps {
    @Given("estoy logueado en la web de coopsol con el usuario “User_Admin\"")
     public void doLogin(){
        ProducerService.doLogin();
    }
    @When("hago click en la pestaña \"Productores\"")
    public void clickProductores(){
        ProducerService.goToProducers();
    }

    @When("hago click en el boton \"+Nuevo Productor\"")
    public void newProductor(){
        ProducerService.newProducer();
    }

    @When("relleno los campos del formulario “Apellido”, “Nombre”, “DNI”, “Email”, “Número_de_teléfono”, “CUIT”, “DID”")
    public void fillProductor(){
        ProducerService.fillProducerDetails();
    }

    @When("hago click en el boton \"Guardar\"")
    public void saveProductor() throws InterruptedException {
        ProducerService.save();
    }


}
