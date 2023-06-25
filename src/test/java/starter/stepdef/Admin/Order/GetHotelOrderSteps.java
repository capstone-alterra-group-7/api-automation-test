package starter.stepdef.Admin.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Order.GetHotelOrderUserPage;

public class GetHotelOrderSteps {

    @Steps
    GetHotelOrderUserPage getHotelOrderUserPage;

    @Given("I have endpoint post new login for get hotel order")
    public void userMustLoginForGetHotelOrderUser() {
        getHotelOrderUserPage.setEndpointLogin();
    }

    @When("I send request to endpoint for get hotel order")
    public void userSendLoginForGetHotelOrderUser() {
        getHotelOrderUserPage.sendRequestLogin();
    }

    @When("I set GET valid endpoint for get hotel order")
    public void userSetPOSTValidEndpointForGetHotelOrderUser() {
        getHotelOrderUserPage.setPostValidEndpointForGetHotelOrder();
    }

    @When("I send GET HTTP request with valid endpoint for get hotel order")
    public void userSendPOSTHTTPRequestForGetHotelOrderUser() {
        getHotelOrderUserPage.sendPOSTHTTPRequestForGetHotelOrder();
    }

    @Then("I received valid GET HTTP response code 200 for get hotel order")
    public void userReceivedHTTPResponseCodeForGetHotelOrderUser() {
        getHotelOrderUserPage.validateHTTPResponseCode200ForGetHotelOrder();
    }

    @Then("I receive valid data response for get hotel order")
    public void userReceivedValidDataResponseForGetHotelOrderUser() {
        getHotelOrderUserPage.validateValidDataResponseForGetHotelOrder();
    }

    //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for get hotel order2")
    public void userMustLoginForGetHotelOrderUser2() {
        getHotelOrderUserPage.setEndpointLogin();
    }

    @When("I send request to endpoint for get hotel order2")
    public void userSendLoginForGetHotelOrderUser2() {
        getHotelOrderUserPage.sendRequestLogin();
    }

    @When("I set GET invalid endpoint for get hotel order2")
    public void userSetPOSTInvalidEndpointForGetHotelOrderUser2() {
        getHotelOrderUserPage.setPostInvalidEndpointForGetHotelOrder();
    }

    @When("I send GET HTTP request with invalid endpoint for get hotel order2")
    public void userSendInvalidPOSTHTTPRequestForGetHotelOrderUser2() {
        getHotelOrderUserPage.sendPOSTInvalidHTTPRequestForGetHotelOrder();
    }

    @Then("I received invalid GET HTTP response code 404 for get hotel order2")
    public void userReceivedHTTPResponseCodeForGetHotelOrderUser2() {
        getHotelOrderUserPage.validateInvalidHTTPResponseCode404ForGetHotelOrder();
    }

    @Then("I receive invalid data response for get hotel order2")
    public void userReceivedInvalidDataResponseForGetHotelOrderUser2() {
        getHotelOrderUserPage.validateInvalidDataResponseForGetHotelOrder();
    }
}