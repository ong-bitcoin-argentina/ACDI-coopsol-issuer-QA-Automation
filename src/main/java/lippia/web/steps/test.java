package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.Given;
import lippia.web.services.testService;

public class test extends PageSteps {

    @Given("The client is in google page")
    public void test(){
        System.out.print(PropertyManager.getProperty("user"));
        System.out.print(PropertyManager.getProperty("pass"));
        testService.navigateTest();

    }
}
