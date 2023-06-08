package starter.stepdef.Admin.TrainCarriage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.TrainCarriage.DeleteTrainCarriageByIdPage;

public class DeleteTrainCarriageByIdSteps {

    @Steps
    DeleteTrainCarriageByIdPage deleteTrainCarriageById;

    @Given("I have endpoint post new login for DTC")
    public void userMustLoginForDTC() {
        deleteTrainCarriageById.setEndpointLoginDTC();
    }

    @When("I send request to endpoint for DTC")
    public void userSendLoginForDTC() {
        deleteTrainCarriageById.sendRequestLoginDTC();
    }

    @When("user set DELETE valid endpoint for DTC")
    public void userSetDELETEValidEndpointForDTC() {
        deleteTrainCarriageById.setDeleteValidEndpointForDTC();
    }

    @When("user send DELETE HTTP request with valid endpoint for DTC")
    public void userSendDELETEHTTPRequestForDTC() {
        deleteTrainCarriageById.sendPOSTHTTPRequestForDTC();
    }

    @Then("user received valid DELETE HTTP response code 200 for DTC")
    public void userReceivedHTTPResponseCodeForDTC() {
        deleteTrainCarriageById.validateHTTPResponseCode200ForDTC();
    }
    //=============================================INVALID ENDPOINT============================

    @Given("I have endpoint post new login for DTC2")
    public void userMustLoginForDTC2() {
        deleteTrainCarriageById.setEndpointLoginDTC2();
    }

    @When("I send request to endpoint for DTC2")
    public void userSendLoginForDTC2() {
        deleteTrainCarriageById.sendRequestLoginDTC2();
    }

    @When("user set DELETE invalid endpoint for DTC")
    public void userSetDELETEInvalidEndpointForDTC() {
        deleteTrainCarriageById.setDeleteInvalidEndpointForDTC();
    }

    @When("user send DELETE HTTP request with invalid endpoint for DTC")
    public void userSendInvalidEndpointDELETEHTTPRequestForDTC() {
        deleteTrainCarriageById.sendPOSTInvalidEndpointHTTPRequestForDTC();
    }

    @Then("user received invalid endpoint DELETE HTTP response code 404 for DTC")
    public void userReceivedInvalidEnpointHTTPResponseCodeForDTC() {
        deleteTrainCarriageById.validateInvalidEndpointHTTPResponseCode404ForDTC();
    }
//    @Given("I have endpoint post new login for GTC2")
//    public void userMustLoginForGTC2() {
//        deleteTrainCarriageById.setEndpointLoginGTC2();
//    }
//
//    @When("I send request to endpoint for GTC2")
//    public void userSendLoginForGTC2() {
//        deleteTrainCarriageById.sendRequestLoginGTC2();
//    }
//
//    @When("user set GET invalid endpoint for GTC")
//    public void userSetPOSTInvalidEndpointForGTC() {
//        deleteTrainCarriageById.setPostInvalidEndpointForGTC();
//    }
//
//    @When("user send GET HTTP request with invalid endpoint for GTC")
//    public void userSendPOSTInvalidEndpointHTTPRequestForGTC() {
//        deleteTrainCarriageById.sendPOSTInvalidEndpointHTTPRequestForGTC();
//    }
//
//    @Then("user received invalid endpoint GET HTTP response code 200 for GTC")
//    public void userReceivedInvalidEndpointHTTPResponseCodeForGTC() {
//        deleteTrainCarriageById.validateHTTPInvalidEndpointResponseCode404ForGTC();
//    }
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