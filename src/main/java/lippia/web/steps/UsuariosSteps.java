package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LoginService;
import lippia.web.services.UsuariosService;

public class UsuariosSteps extends PageSteps {

    @When("^el admin completa el formulario con \"Nombre:\" (.*), \"Contraseña:\" (.*) y \"Roles:\" (.*)$")
    public void elAdminCompletaElFormularioConNombrePassYRol(String name, String pass, String role) {
        UsuariosService.completeForm(name, pass, role);
    }

    @Then("^el usuario se crea exitosamente con \"Nombre:\" (.*) y \"Roles:\" (.*)$")
    public void elUsuarioSeCreaExitosamente(String name, String role) {
        UsuariosService.verifyNewUser(name, role);
    }
}
