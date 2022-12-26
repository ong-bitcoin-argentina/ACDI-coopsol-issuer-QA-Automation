package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;
import lippia.web.services.ActivitiesService;

public class ActivitiesSteps extends PageSteps {
    @Then("se muestra un listado con las actividades de los usuarios.")
    public void checkList() throws InterruptedException {
        ActivitiesService.checkActResult();
    }

}
