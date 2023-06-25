package starter.stepdef.User.HistorySearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.HistorySearch.GetAllHistortySearchUserPage;
public class GetAllHistorySearchSteps {

        @Steps
        GetAllHistortySearchUserPage getAllHistorySearch;
        @Given("I have endpoint post new login for get all history search")
        public void userMustLoginForGetAllHistorySearch(){
            getAllHistorySearch.setEndpointLogin();
        }
        @When("I send request to endpoint for get all history search")
        public void userSendLoginForGetAllHistorySearch(){
            getAllHistorySearch.sendRequestLogin();
        }
        @When("user set GET valid endpoint for get all history search")
        public void userSetPOSTValidEndpointForGetAllHistorySearch() {
            getAllHistorySearch.setPostValidEndpointForGetAllHistorySearch();
        }

        @When("user send GET HTTP request with valid endpoint for get all history search")
        public void userSendPOSTHTTPRequestForGetAllHistorySearch() {
            getAllHistorySearch.sendPOSTHTTPRequestForGetAllHistorySearch();
        }

        @Then("user received valid GET HTTP response code 200 for get all history search")
        public void userReceivedHTTPResponseCodeForGetAllHistorySearch() {
            getAllHistorySearch.validateHTTPResponseCode200ForGetAllHistorySearch();
        }
    @Then("user receive valid data response for get all history search")
    public void userReceivedValidDataResponseForGetAllHistorySearch() {
        getAllHistorySearch.validateValidDataResponseForGetAllHistorySearch();
    }
        //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for get all history search2")
    public void userMustLoginForInvalidGetAllHistorySearch(){
        getAllHistorySearch.setInvalidEndpointLogin();
    }
    @When("I send request to endpoint for get all history search2")
    public void userSendLoginForInvalidGetAllHistorySearch(){
        getAllHistorySearch.sendInvalidRequestLogin();
    }
    @When("user set GET invalid endpoint for get all history search")
    public void userSetPOSTValidEndpointForInvalidGetAllHistorySearch() {
        getAllHistorySearch.setPostValidEndpointForGetAllHistorySearch();
    }

    @When("user send GET HTTP request with valid endpoint for invalid get all history search")
    public void userSendPOSTHTTPRequestForInvalidGetAllHistorySearch() {
        getAllHistorySearch.sendPOSTInvalidHTTPRequestForGetAllHistorySearch();
    }

    @Then("user received valid GET HTTP response code 404 for invalid get all history search")
    public void userReceivedHTTPResponseCodeForInvalidGetAllHistorySearch() {
        getAllHistorySearch.validateInvalidHTTPResponseCode404ForGetAllHistorySearch();
    }
    @Then("user receive valid data response for invalid get all history search")
    public void userReceivedValidDataResponseForInvalidGetAllHistorySearch() {
        getAllHistorySearch.validateValidDataResponseForInvalidGetAllHistorySearch();
}
}