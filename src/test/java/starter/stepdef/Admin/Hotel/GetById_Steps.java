package starter.stepdef.Admin.Hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel.GetById_Hotel;

public class GetById_Steps {

    @Steps
    GetById_Hotel getByIdHotel;

    @Given("I have endpoint post new login for Id Hotel")
    public void HaveEndpointPostNewLoginForIdHotel () {
        getByIdHotel.EndpointLoginForIdHotel();
    }

    @When("I send request to endpoint for Id Hotel")
    public void SendRequestToEndpointForIdHotel () {
        getByIdHotel.SendRequestForIdHotel();
    }

    @And("user set GET valid endpoint for Id Hotel")
    public void UserSetGetValidEndpointForIdHotel () {
        getByIdHotel.setPostValidEndpointForIdHotel();
    }

    @And("user send GET HTTP request with valid endpoint for Id Hotel")
    public void UserSendGetHttpRequestWithValidEndpointForIdHotel () {
        getByIdHotel.sendPOSTHTTPRequestForIdHotel();
    }


    @Then("user received valid Get By Id HTTP response code {int}")
    public void userReceivedValidGetByIdHTTPResponseCode(int arg0) {
        getByIdHotel.validateHTTPResponseCode200ForIdHotel();
    }


    @Given("I have endpoint post new login for invalid Id Hotel")
    public void HaveEndpointInvalidIdHotel () {
        getByIdHotel.EndpointInvalidIdHotel();
    }

    @When("I send request to endpoint for invalid Id Hotel")
    public void SendRequestToEndpointForInvalidIdHotel () {
        getByIdHotel.SendRequestForIdHotel2();
    }


    @And("user set GET invalid endpoint for Id Hotel")
    public void UserSetGetInvalidEndpointForIdHotel () {
        getByIdHotel.setPostInvalidEndpointForIdHotel();
    }

    @And("user send GET HTTP request with invalid endpoint for Id Hotel")
    public void UserSendGetHttpRequestWithInvalidEndpointForIdHotel() {
        getByIdHotel.sendGetHTTPRequestInvalidForIdHotel();
    }

    @Then("user received invalid Get By Id HTTP response code {int}")
    public void UserReceivedInvalidGetByIdHttpResponseCode(int arg0) {
        getByIdHotel.validateHTTPInvalidEndpointResponseCode404ForGetIdHotel();
    }


}
