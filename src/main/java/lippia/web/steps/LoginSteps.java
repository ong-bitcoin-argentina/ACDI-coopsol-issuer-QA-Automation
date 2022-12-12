package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.BaseService;
import lippia.web.services.LoginService;

public class LoginSteps extends PageSteps {

    @Given("El usuario se encuentra en <Coopsol Issuer>")
    public void homeCoopSol(){
        LoginService.navegarWeb();
    }

    @When("El usuario completa Usuario con user")
    public void ElUsuarioCompletaUsuario() {
        LoginService.setUser(PropertyManager.getProperty("user"));
    }

    @When("El usuario completa Contraseña con password")
    public void elUsuarioCompletaContraseña() {
        LoginService.setPassword(PropertyManager.getProperty("pass"));
    }

    @When("^Hace click en el boton \"(.*)\"$")
    public void haceClickEnElBotonLogin(String button) {
        BaseService.clickButton(button);
    }

    @Then("Se muestra la página de Credenciales")
    public void seMuestraLaPáginaDeCredenciales() {
        LoginService.verifyLogin();
    }

    @When("El usuario completa Usuario con '(.*)'")
    public void elUsuarioCompletaUsuarioConUser(String user) {
        LoginService.setUser(user);
    }

    @When("El usuario completa Contraseña con '(.*)'")
    public void elUsuarioCompletaConPassword(String password) {
        LoginService.setPassword(password);
    }

    @Then("Se muestra el mensaje {string}")
    public void respuesta(String message) {
        LoginService.verifyMessage(message);
    }

    @Given("que el admin esta logueado en la web de coopsol.")
    public void queElAdminEstaLogueadoEnLaWebDeCoopsol() {
        LoginService.login();
    }

    @When("el usuario selecciona {string}")
    public void elUsuarioSeleccionaCerrarSesion(String button){
        BaseService.clickButton(button);
    }

    @Then("se redirije a pantalla del Log in")
    public void seRedirijeAPantallaDelLogIn() {
        LoginService.verifyLogout();
    }
}
