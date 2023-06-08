package starter.stepdef.Admin.Station;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Station.DeleteStation;

public class DeleteStationSteps {

    @Steps
    DeleteStation deleteStation;

    @Given("Admin want to set delete api endpoints")
    public void SetDeleteApiEndpoints() {
        deleteStation.AdminEndpointLogin();
    }


    @When("admin request to endpoint for delete Station")
    public void adminRequestToEndpointForDeleteStation() {
        deleteStation.AdminRequestDeleteHTTPRequest();
    }

    @And("Admin delete station")
    public void adminDeleteStation() {
        deleteStation.AdminDeleteStation();
    }

    @And("admin set delete valid endpoints")
    public void adminSetDeleteValidEndpoints() {
        deleteStation.DeleteValidEndpoints();
    }


    @Then("admin receive valid delete response code {int}")
    public void adminReceiveValidDeleteResponseCode(int arg0) {
        deleteStation.validateHTTPResponseCode200ForDeleteStation();
    }

}
