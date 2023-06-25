package starter.stepdef.Admin.TrainCarriage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.TrainCarriage.GetAllTrainCarriagePage;

public class GetAllTrainCarriageSteps {

        @Steps
        GetAllTrainCarriagePage getAllTrainCarriagePage;
        @Given("I have endpoint post new login for Get All Train Carriage")
        public void userMustLoginForGetAllTrainCarriage(){
            getAllTrainCarriagePage.setEndpointLogin();
        }
        @When("I send request to endpoint for Get All Train Carriage")
        public void userSendLoginForGetAllTrainCarriage(){
            getAllTrainCarriagePage.sendRequestLogin();
        }
        @When("user set GET valid endpoint")
        public void userSetPOSTValidEndpointForGetAllTrainCarriage() {
            getAllTrainCarriagePage.setPostValidEndpointForGetAllTrainCarriage();
        }

        @When("user send GET HTTP request with valid endpoint")
        public void userSendPOSTHTTPRequestForGetAllTrainCarriage() {
            getAllTrainCarriagePage.sendPOSTHTTPRequestForGetAllTrainCarriage();
        }

        @Then("user received valid GET HTTP response code 200")
        public void userReceivedHTTPResponseCodeForGetAllTrainCarriage() {
            getAllTrainCarriagePage.validateHTTPResponseCode200ForGetAllTrainCarriage();
        }
        //=============================================INVALID ENDPOINT============================
    @Given("I have invalid endpoint post new login for Get All Train Carriage")
    public void userMustLoginForInvalidGetAllTrainCarriage(){
        getAllTrainCarriagePage.setInvalidEndpointLogin();
    }
    @When("I send invalid request to endpoint for Get All Train Carriage")
    public void userSendLoginForInvalidGetAllTrainCarriage(){
        getAllTrainCarriagePage.sendInvalidRequestLogin();
    }
    @When("user set invalid GET valid endpoint")
    public void userSetPOSTValidEndpointForInvalidGetAllTrainCarriage() {
        getAllTrainCarriagePage.setPostValidEndpointForGetAllTrainCarriage();
    }

    @When("user send invalid GET HTTP request with valid endpoint")
    public void userSendPOSTHTTPRequestForInvalidGetAllTrainCarriage() {
        getAllTrainCarriagePage.sendPOSTInvalidHTTPRequestForGetAllTrainCarriage();
    }

    @Then("user received invalid GET HTTP response code 404")
    public void userReceivedHTTPResponseCodeForInvalidGetAllTrainCarriage() {
        getAllTrainCarriagePage.validateInvalidHTTPResponseCode404ForGetAllTrainCarriage();
    }
}
