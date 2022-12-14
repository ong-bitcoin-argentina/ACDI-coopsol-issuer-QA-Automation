package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.BaseService;
import lippia.web.services.PasswordService;

public class PasswordSteps extends PageSteps {

    @When("^hago click en la pestaña '(.*)'$")
    public void hagoClickEnLaPestaña(String button) {
        BaseService.clickButton(button);
    }

    @And("^hago click en el campo Nueva contraseña y completo con '(.*)'$")
    public void hagoClickEnElCampoNuevaContraseñaYCompletoConCrowdar(String newPass) {
        PasswordService.setNewPassword(newPass);
    }

    @And("^hago click en el campo Confirmar nueva contraseña y completo con '(.*)'$")
    public void hagoClickEnElCampoConfirmarNuevaContraseñaYCompletoConCrowdar(String newPass) {
        PasswordService.setRepeatNewPassword(newPass);
    }

    @And("^hago click en el boton '(.*)'$")
    public void hagoClickEnElBotonActualizarContraseña(String button) {
        BaseService.clickButton(button);
    }

    @Then("^el sistema muestra un mensaje  '(.*)'$")
    public void elSistemaMuestraUnMensaje(String message) {
        PasswordService.verifyMessage(message);
    }

}
