package starter.stepdef.Admin.TrainCarriage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.TrainCarriage.GetTrainCarriageByIdPage;

public class GetTrainCarriageByIdSteps {

    @Steps
    GetTrainCarriageByIdPage getTrainCarriageById;

    @Given("I have endpoint post new login for GTC")
    public void userMustLoginForGTC() {
        getTrainCarriageById.setEndpointLoginGTC();
    }

    @When("I send request to endpoint for GTC")
    public void userSendLoginForGTC() {
        getTrainCarriageById.sendRequestLoginGTC();
    }

    @When("user set GET valid endpoint for GTC")
    public void userSetPOSTValidEndpointForGTC() {
        getTrainCarriageById.setPostValidEndpointForGTC();
    }

    @When("user send GET HTTP request with valid endpoint for GTC")
    public void userSendPOSTHTTPRequestForGTC() {
        getTrainCarriageById.sendPOSTHTTPRequestForGTC();
    }

    @Then("user received valid GET HTTP response code 200 for GTC")
    public void userReceivedHTTPResponseCodeForGTC() {
        getTrainCarriageById.validateHTTPResponseCode200ForGTC();
    }
    //=============================================INVALID ENDPOINT============================
    @Given("I have endpoint post new login for GTC2")
    public void userMustLoginForGTC2() {
        getTrainCarriageById.setEndpointLoginGTC2();
    }

    @When("I send request to endpoint for GTC2")
    public void userSendLoginForGTC2() {
        getTrainCarriageById.sendRequestLoginGTC2();
    }

    @When("user set GET invalid endpoint for GTC")
    public void userSetPOSTInvalidEndpointForGTC() {
        getTrainCarriageById.setPostInvalidEndpointForGTC();
    }

    @When("user send GET HTTP request with invalid endpoint for GTC")
    public void userSendPOSTInvalidEndpointHTTPRequestForGTC() {
        getTrainCarriageById.sendPOSTInvalidEndpointHTTPRequestForGTC();
    }

    @Then("user received invalid endpoint GET HTTP response code 200 for GTC")
    public void userReceivedInvalidEndpointHTTPResponseCodeForGTC() {
        getTrainCarriageById.validateHTTPInvalidEndpointResponseCode404ForGTC();
    }
//    @Given("I have invalid endpoint post new login for Get All Train Carriage")
//    public void userMustLoginForInvalidGetAllTrainCarriage(){
//        getAllTrainCarriagePage.setInvalidEndpointLogin();
//    }
//    @When("I send invalid request to endpoint for Get All Train Carriage")
//    public void userSendLoginForInvalidGetAllTrainCarriage(){
//        getAllTrainCarriagePage.sendInvalidRequestLogin();
//    }
//    @When("user set invalid GET valid endpoint")
//    public void userSetPOSTValidEndpointForInvalidGetAllTrainCarriage() {
//        getAllTrainCarriagePage.setPostValidEndpointForGetAllTrainCarriage();
//    }
//
//    @When("user send invalid GET HTTP request with valid endpoint")
//    public void userSendPOSTHTTPRequestForInvalidGetAllTrainCarriage() {
//        getAllTrainCarriagePage.sendPOSTInvalidHTTPRequestForGetAllTrainCarriage();
//    }
//
//    @Then("user received invalid GET HTTP response code 404")
//    public void userReceivedHTTPResponseCodeForInvalidGetAllTrainCarriage() {
//        getAllTrainCarriagePage.validateInvalidHTTPResponseCode404ForGetAllTrainCarriage();
//    }
//}
}