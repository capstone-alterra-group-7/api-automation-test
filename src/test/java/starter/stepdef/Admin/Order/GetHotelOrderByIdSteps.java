package starter.stepdef.Admin.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Order.GetHotelOrderUserByIdPage;

public class GetHotelOrderByIdSteps {

    @Steps
    GetHotelOrderUserByIdPage GetHotelOrderUserByIdPage;

    @Given("I have endpoint post new login for get hotel order ById")
    public void userMustLoginForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.setEndpointLogin();
    }

    @When("I send request to endpoint for get hotel order ById")
    public void userSendLoginForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.sendRequestLogin();
    }

    @When("I set GET valid endpoint for get hotel order ById")
    public void userSetPOSTValidEndpointForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.setPostValidEndpointForGetHotelOrderById();
    }

    @When("I send GET HTTP request with valid endpoint for get hotel order ById")
    public void userSendGETHTTPRequestForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.sendGETHTTPRequestForGetHotelOrderById();
    }

    @Then("I received valid GET HTTP response code 200 for get hotel order ById")
    public void userReceivedHTTPResponseCodeForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.validateHTTPResponseCode400ForGetHotelOrderById();
    }

    @Then("I receive valid data response for get hotel order ById")
    public void userReceivedValidDataResponseForGetHotelOrderUserById() {
        GetHotelOrderUserByIdPage.validateInvalidDataResponseForGetHotelOrderById();
    }


    //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for get hotel order ById2")
    public void userMustLoginForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.setEndpointLogin();
    }

    @When("I send request to endpoint for get hotel order ById2")
    public void userSendLoginForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.sendRequestLogin();
    }

    @When("I set GET invalid endpoint for get hotel order ById2")
    public void userSetPOSTValidEndpointForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.setPostInvalidEndpointForGetHotelOrderById();
    }

    @When("I send GET HTTP request with invalid endpoint for get hotel order ById2")
    public void userSendGETInvalidHTTPRequestForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.sendGETInvalidHTTPRequestForGetHotelOrderById();
    }

    @Then("I received invalid GET HTTP response code 404 for get hotel order ById2")
    public void userReceivedHTTPResponseCodeForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.validateInvalidHTTPResponseCode404ForGetHotelOrderById();
    }

    @Then("I receive invalid data response for get hotel order ById2")
    public void userReceivedValidDataResponse404ForGetHotelOrderUserById2() {
        GetHotelOrderUserByIdPage.validateInvalidDataResponse404ForGetHotelOrderById();
    }
}