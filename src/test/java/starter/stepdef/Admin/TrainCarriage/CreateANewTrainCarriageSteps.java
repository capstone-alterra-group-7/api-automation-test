package starter.stepdef.Admin.TrainCarriage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.TrainCarriage.CreateANewTrainCarriagePage;

public class CreateANewTrainCarriageSteps {

        @Steps
        CreateANewTrainCarriagePage CreateANewTrainCarriage;
        @Given("Enter Endpoint Login Valid Endpoint TC")
        public void endpointLoginCreateTC(){
            CreateANewTrainCarriage.setEndpointLogin();
        }
        @When("Enter Request Login Valid Endpoint TC")
        public void reqLoginCreateTC(){
            CreateANewTrainCarriage.sendRequestLogin();
        }
        @When("Enter Endpoint TC Valid Endpoint")
        public void setValidEndpointCreateTC() {
            CreateANewTrainCarriage.setValidEndpointTC();
        }

        @When("Enter Request TC Valid Endpoint")
        public void sendReqCreateTC() {
            CreateANewTrainCarriage.sendRequestCreateTC();
        }

        @Then("Receive 201 response Valid Endpoint")
        public void receiveResponseCreateTC() {
            CreateANewTrainCarriage.validateResponse201TC();
        }
        //=======================================================INVALID ENDPOINT==========================================

    @Given("Enter Endpoint Login Valid Endpoint TC2")
    public void endpointLoginCreateTC2(){
        CreateANewTrainCarriage.setEndpointLogin2();
    }
    @When("Enter Request Login Valid Endpoint TC2")
    public void reqLoginCreateTC2(){
        CreateANewTrainCarriage.sendRequestLogin2();
    }
    @When("Enter Endpoint TC Invalid Endpoint")
    public void setInvalidEndpointCreateTC() {
        CreateANewTrainCarriage.setInvalidEndpointTC();
    }

    @When("Enter Request TC Invalid Endpoint")
    public void sendInvalidEndpointReqCreateTC() {
        CreateANewTrainCarriage.sendInvalidEndpointRequestCreateTC();
    }

    @Then("Receive 404 response Invalid Endpoint")
    public void receiveInvalidEndpointResponseCreateTC() {
        CreateANewTrainCarriage.validateInvalidEndpointResponse404TC();
    }
//==========================================================INVALID REQUEST=============================================
@Given("Enter Endpoint Login Valid Endpoint TC3")
public void endpointLoginCreateTC3(){
    CreateANewTrainCarriage.setEndpointLogin3();
}
    @When("Enter Request Login Valid Endpoint TC3")
    public void reqLoginCreateTC3(){
        CreateANewTrainCarriage.sendRequestLogin3();
    }
    @When("Enter Endpoint TC Valid Endpoint for invalid request")
    public void setValidEndpointInvalidReqCreateTC() {
        CreateANewTrainCarriage.setValidEndpointInvalidReqTC();
    }

    @When("Enter Request TC Valid Endpoint for invalid request")
    public void sendReqInvalidReqCreateTC() {
        CreateANewTrainCarriage.sendRequestCreateInvalidReqTC();
    }

    @Then("Receive 400 response Invalid Endpoint for invalid request")
    public void receiveResponseInvalidReqCreateTC() {
        CreateANewTrainCarriage.validateResponse400TC();
    }


























//    @Given("I have invalid endpoint post new login for create a new Train Carriage2")
//    public void userMustLoginForInvalidGetAllTrainCarriage(){
//        CreateANewTrainCarriage.setInvalidEndpointLogin();
//    }
//    @When("I send valid request to endpoint for create a new Train Carriage2")
//    public void userSendLoginForInvalidGetAllTrainCarriage(){
//        CreateANewTrainCarriage.sendInvalidRequestLogin();
//    }
//    @When("user set POST invalid endpoint for create a new Train Carriage")
//    public void userSetPOSTInvalidEndpointForInvalidGetAllTrainCarriage() {
//        CreateANewTrainCarriage.setPostInvalidEndpointForGetAllTrainCarriage();
//    }
//
//    @When("user send valid POST HTTP request for create a new Train Carriage with invalid endpoint")
//    public void userSendPOSTHTTPRequestForInvalidGetAllTrainCarriage() {
//        CreateANewTrainCarriage.sendPOSTInvalidHTTPRequestForGetAllTrainCarriage();
//    }
//
//    @Then("user received invalid POST HTTP for create a new Train Carriage response code 404")
//    public void userReceivedHTTPResponseCodeForInvalidGetAllTrainCarriage() {
//        CreateANewTrainCarriage.validateInvalidHTTPResponseCode404ForGetAllTrainCarriage();
//    }
//    //==============================================================================INVALID REQ==============================
//    @Given("I have invalid endpoint post new login for create a new Train Carriage1")
//    public void userMustLoginForGetAllTrainCarriage1(){
//        CreateANewTrainCarriage.setInvalidEndpointLoginReq();
//    }
//    @When("I send invalid request to endpoint for create a new Train Carriage1")
//    public void userSendLoginForGetAllTrainCarriage1(){
//        CreateANewTrainCarriage.sendInvalidRequestLoginReq();
//    }
//    @When("user set GET invalid endpoint for create a new Train Carriage1")
//    public void userSetPOSTValidEndpointForGetAllTrainCarriage1() {
//        CreateANewTrainCarriage.setPostInvalidEndpointForGetAllTrainCarriageReq();
//    }
//
//    @When("user send invalid GET HTTP request for create a new Train Carriage with valid endpoint1")
//    public void userSendPOSTHTTPRequestForGetAllTrainCarriage1() {
//        CreateANewTrainCarriage.sendPOSTInvalidHTTPRequestForGetAllTrainCarriageReq();
//    }
//
//    @Then("user received invalid Req GET HTTP for create a new Train Carriage response code 400")
//    public void userReceivedHTTPResponseCodeForGetAllTrainCarriage1() {
//        CreateANewTrainCarriage.validateInvalidHTTPResponseCode404ForGetAllTrainCarriageReq();
//    }
}
