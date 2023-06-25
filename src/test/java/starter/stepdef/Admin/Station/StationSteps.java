package starter.stepdef.Admin.Station;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Station.Station;

public class StationSteps {

    @Steps
    Station station;
    @Given("I set GET api endpoints")
    public void ISetGetApiEndpoints() {
      station.setEndpointLogin();
    }


    @When("I request to endpoint for Get All Train")
    public void iSendGETHTTPRequest() {
        station.sendRequestLogin();
    }

    @And("user set GET valid endpoints")
    public void setPostValidEndpointForGetAllStation() {
        station.setPostValidEndpointForGetAllStation();
    }

    @And("user send HTTP request with valid endpoint")
    public void UserSendHttpRequestWithValidEndpoint() {
        station.sendPOSTHTTPRequestForGetAllStation();
    }


    @Then("I receive valid HTTP response code {int}")
    public void iReceiveValidHTTPResponseCode(int arg0) {
        station.validateHTTPResponseCode200ForGetAllStation();
    }


}
