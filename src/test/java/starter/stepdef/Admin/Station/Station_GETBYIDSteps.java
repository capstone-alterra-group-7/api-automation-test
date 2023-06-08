package starter.stepdef.Admin.Station;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Station.Station_GETBYID;

public class Station_GETBYIDSteps {

    @Steps
    Station_GETBYID stationGetbyid;


    @Given("Admin set get api endpoints")
    public void AdminSetGetApiEndpoints() {
        stationGetbyid.SetApiEndpoints();
    }


    @When("admin request to endpoint for Get By Id")
    public void adminRequestToEndpointForGetById() {
        stationGetbyid.sendRequestLogin();
    }

    @And("admin set GET valid endpoints")
    public void adminSetGETValidEndpoints() {
        stationGetbyid.setPostValidEndpointGetStationById();
    }

    @And("admin send GET HTTP request with valid endpoint")
    public void adminSendGETHTTPRequestWithValidEndpoint() {
        stationGetbyid.sendPOSTHTTPRequestForGetAllStation();
    }

    @Then("admin receive valid HTTP response code {int}")
    public void adminReceiveValidHTTPResponseCode(int arg0) {
        stationGetbyid.validateHTTPResponseCode200ForGetAllStation();
    }
}
