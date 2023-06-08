package starter.stepdef.Admin.Station;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Station.PUT_UpdateStation;

public class UpdateStationSteps {

    @Steps
    PUT_UpdateStation updateStation;

    @Given("Admin want to set put api endpoints")
    public void WantToSetPutApiEndpoints() {
        updateStation.SetPutApi();
    }


    @When("admin request to endpoint for Update Station")
    public void adminRequestToEndpointForUpdateStation() {
        updateStation.AdminRequestLogin();
    }

    @And("Admin update station")
    public void adminUpdateStation() {
        updateStation.PutUpdateStation();
    }

    @And("admin set put valid endpoints")
    public void adminSetPutValidEndpoints() {
        updateStation.setPostValidEndpointPutUpdateStation();
    }

    @And("admin send put HTTP request with valid endpoint")
    public void adminSendPutHTTPRequestWithValidEndpoint() {
        updateStation.PutRequest();
    }

    @Then("admin receive valid put response code {int}")
    public void adminReceiveValidPutResponseCode(int arg0) {
        updateStation.validateHTTPResponseCode200ForUpdateStation();
    }
}
