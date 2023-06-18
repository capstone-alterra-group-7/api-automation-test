package starter.stepdef.Admin.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Order.GetTicketOrderUserByIdPage;

public class GetTicketOrderrByIdSteps {

    @Steps
    GetTicketOrderUserByIdPage GetTicketOrderUserByIdPage;

    @Given("I have endpoint post new login for Get Ticket Order by id")
    public void userMustLoginForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.setEndpointLogin();
    }

    @When("I send request to endpoint for Get Ticket Order by id")
    public void userSendLoginForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.sendRequestLogin();
    }

    @When("I set GET valid endpoint for Get Ticket Order by id")
    public void userSetPOSTValidEndpointForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.setPostValidEndpointForGetTicketOrderById();
    }

    @When("I send GET HTTP request with valid endpoint for Get Ticket Order by id")
    public void userSendGETHTTPRequestForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.sendGETHTTPRequestForGetTicketOrderById();
    }

    @Then("I received valid GET HTTP response code 200 for Get Ticket Order by id")
    public void userReceivedHTTPResponseCodeForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.validateHTTPResponseCode400ForGetTicketOrderById();
    }

    @Then("I receive valid data response for Get Ticket Order by id")
    public void userReceivedValidDataResponseForGetTicketOrderUserById() {
        GetTicketOrderUserByIdPage.validateInvalidDataResponse400ForGetTicketOrderById(); // SEMENTARA DOWN<<<
    }


    //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for Get Ticket Order by id2")
    public void userMustLoginForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.setEndpointLogin();
    }

    @When("I send request to endpoint for Get Ticket Order by id2")
    public void userSendLoginForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.sendRequestLogin();
    }

    @When("I set GET invalid endpoint for Get Ticket Order by id2")
    public void userSetPOSTValidEndpointForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.setPostInvalidEndpointForGetTicketOrderById();
    }

    @When("I send GET HTTP request with invalid endpoint for Get Ticket Order by id2")
    public void userSendGETInvalidHTTPRequestForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.sendGETInvalidHTTPRequestForGetTicketOrderById();
    }

    @Then("I received invalid GET HTTP response code 404 for Get Ticket Order by id2")
    public void userReceivedHTTPResponseCodeForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.validateInvalidHTTPResponseCode404ForGetTicketOrderById();
    }

    @Then("I receive invalid data response for Get Ticket Order by id2")
    public void userReceivedValidDataResponseForGetTicketOrderUserById2() {
        GetTicketOrderUserByIdPage.validateInvalidDataResponseForGetTicketOrderById();
    }
}