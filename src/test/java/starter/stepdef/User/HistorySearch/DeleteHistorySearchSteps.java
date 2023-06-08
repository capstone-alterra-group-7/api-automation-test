package starter.stepdef.User.HistorySearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.HistorySearch.DeleteHistorySearchPage;

public class DeleteHistorySearchSteps {

    @Steps
    DeleteHistorySearchPage deleteHistorySearchPage;

    @Given("I have endpoint post new login for DHS")
    public void userMustLoginForDHS() {
        deleteHistorySearchPage.setEndpointLoginDHS();
    }

    @When("I send request to endpoint for DHS")
    public void userSendLoginForDHS() {
        deleteHistorySearchPage.sendRequestLoginDHS();
    }

    @When("user set DELETE valid endpoint for DHS")
    public void userSetDELETEValidEndpointForDHS() {
        deleteHistorySearchPage.setDeleteValidEndpointForDHS();
    }

    @When("user send DELETE HTTP request with valid endpoint for DHS")
    public void userSendDELETEHTTPRequestForDHS() {
        deleteHistorySearchPage.sendPOSTHTTPRequestForDHS();
    }

    @Then("user received valid DELETE HTTP response code 200 for DHS")
    public void userReceivedHTTPResponseCodeForDHS() {
        deleteHistorySearchPage.validateHTTPResponseCode200ForDHS();
    }

    @Then("user received data response for DHS")
    public void userReceivedDataResponseCodeForDHS() {
        deleteHistorySearchPage.validateDataResponseForDHS();
    }
    //=============================================INVALID ENDPOINT============================

    @Given("I have endpoint post new login for DHS2")
    public void userMustLoginForDHS2() {
        deleteHistorySearchPage.setEndpointLoginDHS2();
    }

    @When("I send request to endpoint for DHS2")
    public void userSendLoginForDHS2() {
        deleteHistorySearchPage.sendRequestLoginDHS2();
    }

    @When("user set DELETE invalid endpoint for DHS")
    public void userSetDELETEInvalidEndpointForDHS() {
        deleteHistorySearchPage.setDeleteInvalidEndpointForDHS();
    }

    @When("user send DELETE HTTP request with invalid endpoint for DHS")
    public void userSendInvalidEndpointDELETEHTTPRequestForDHS() {
        deleteHistorySearchPage.sendPOSTInvalidEndpointHTTPRequestForDHS();
    }

    @Then("user received invalid endpoint DELETE HTTP response code 404 for DHS")
    public void userReceivedInvalidEnpointHTTPResponseCodeForDHS() {
        deleteHistorySearchPage.validateInvalidEndpointHTTPResponseCode404ForDHS();
    }

    @Then("user received data response for invalid endpoint DHS")
    public void userReceivedDataResponseCodeForInvalidEndpointDHS() {
        deleteHistorySearchPage.validateDataResponseForInvalidEndpointDHS();
    }

    //======================================================INVALID ID===================================================
    @Given("I have endpoint post new login for DHS3")
    public void userMustLoginForDHS3() {
        deleteHistorySearchPage.setEndpointLoginDHS3();
    }

    @When("I send request to endpoint for DHS3")
    public void userSendLoginForDHS3() {
        deleteHistorySearchPage.sendRequestLoginDHS3();
    }

    @When("user set DELETE valid endpoint for invalid id DHS")
    public void userSetDELETEValidEndpointForInvalidRequestDHS() {
        deleteHistorySearchPage.setDeleteValidEndpointForInvalidRequestDHS();
    }

    @When("user send DELETE HTTP request with valid endpoint for invalid id DHS")
    public void userSendvalidEndpointDELETEHTTPRequestForInvalidEndpointDHS() {
        deleteHistorySearchPage.sendPOSTValidEndpointHTTPRequestForInvalidRequestDTC();
    }

    @Then("user received valid endpoint DELETE HTTP response code 400 for invalid id DHS")
    public void userReceivedInvalidRequestHTTPResponseCodeForDHS() {
        deleteHistorySearchPage.validateInvalidEndpointHTTPResponseCode400ForInvalidReqDHS();
    }

    @Then("user received data response for invalid id DHS")
    public void userReceivedDataResponseCodeForInvalidRequestDHS() {
        deleteHistorySearchPage.validateDataResponseForInvalidRequestDHS();

    }
}