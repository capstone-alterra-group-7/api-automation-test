package starter.stepdef.Admin.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Order.GetTicketOrderUserPage;

public class GetTicketOrderSteps {

    @Steps
    GetTicketOrderUserPage GetTicketOrderUserPage;

    @Given("I have endpoint post new login for Get Ticket Order")
    public void userMustLoginForGetTicketOrderUser() {
        GetTicketOrderUserPage.setEndpointLogin();
    }

    @When("I send request to endpoint for Get Ticket Order")
    public void userSendLoginForGetTicketOrderUser() {
        GetTicketOrderUserPage.sendRequestLogin();
    }

    @When("I set GET valid endpoint for Get Ticket Order")
    public void userSetPOSTValidEndpointForGetTicketOrderUser() {
        GetTicketOrderUserPage.setPostValidEndpointForGetTicketOrder();
    }

    @When("I send GET HTTP request with valid endpoint for Get Ticket Order")
    public void userSendPOSTHTTPRequestForGetTicketOrderUser() {
        GetTicketOrderUserPage.sendPOSTHTTPRequestForGetTicketOrder();
    }

    @Then("I received valid GET HTTP response code 200 for Get Ticket Order")
    public void userReceivedHTTPResponseCodeForGetTicketOrderUser() {
        GetTicketOrderUserPage.validateHTTPResponseCode200ForGetTicketOrder();
    }

    @Then("I receive valid data response for Get Ticket Order")
    public void userReceivedValidDataResponseForGetTicketOrderUser() {
        GetTicketOrderUserPage.validateValidDataResponseForGetTicketOrder();
    }

    //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for Get Ticket Order2")
    public void userMustLoginForGetTicketOrderUser2() {
        GetTicketOrderUserPage.setEndpointLogin();
    }

    @When("I send request to endpoint for Get Ticket Order2")
    public void userSendLoginForGetTicketOrderUser2() {
        GetTicketOrderUserPage.sendRequestLogin();
    }

    @When("I set GET invalid endpoint for Get Ticket Order2")
    public void userSetPOSTInvalidEndpointForGetTicketOrderUser2() {
        GetTicketOrderUserPage.setPostInvalidEndpointForGetTicketOrder();
    }

    @When("I send GET HTTP request with invalid endpoint for Get Ticket Order2")
    public void userSendInvalidPOSTHTTPRequestForGetTicketOrderUser2() {
        GetTicketOrderUserPage.sendPOSTInvalidHTTPRequestForGetTicketOrder();
    }

    @Then("I received invalid GET HTTP response code 404 for Get Ticket Order2")
    public void userReceivedHTTPResponseCodeForGetTicketOrderUser2() {
        GetTicketOrderUserPage.validateInvalidHTTPResponseCode404ForGetTicketOrder();
    }

    @Then("I receive invalid data response for Get Ticket Order2")
    public void userReceivedInvalidDataResponseForGetTicketOrderUser2() {
        GetTicketOrderUserPage.validateInvalidDataResponseForGetTicketOrder();
    }
}