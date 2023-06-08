package starter.stepdef.Admin.TrainCarriage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.TrainCarriage.UpdateTrainCarriagePage;

public class UpdateTrainCarriageSteps {

        @Steps
        UpdateTrainCarriagePage UpdateTrainCarriage;
        @Given("Enter Endpoint Login Valid Endpoint UTC")
        public void endpointLoginUTC(){
            UpdateTrainCarriage.setEndpointLoginUTC();
        }
        @When("Enter Request Login Valid Endpoint UTC")
        public void reqLoginUTC(){
            UpdateTrainCarriage.sendRequestLoginUTC();
        }
        @When("Enter Endpoint UTC Valid Endpoint")
        public void setValidEndpointUTC() {
            UpdateTrainCarriage.setValidEndpointUTC();
        }

        @When("Enter Request UTC Valid Endpoint")
        public void sendReqTC() {
            UpdateTrainCarriage.sendRequestUTC();
        }

        @Then("Receive 200 UTC response Valid Endpoint")
        public void receiveResponseTC() {
            UpdateTrainCarriage.validateResponse200UTC();
        }
        //=======================================================INVALID ENDPOINT==========================================

    @Given("Enter Endpoint Login Valid Endpoint UTC2")
    public void endpointLoginUTC2(){
        UpdateTrainCarriage.setEndpointLoginUTC2();
    }
    @When("Enter Request Login Valid Endpoint UTC2")
    public void reqLoginUTC2(){
        UpdateTrainCarriage.sendRequestLoginUTC2();
    }
    @When("Enter Endpoint UTC Invalid Endpoint")
    public void setInvalidEndpointUTC() {
        UpdateTrainCarriage.setInvalidEndpointUTC();
    }

    @When("Enter Request UTC Invalid Endpoint")
    public void sendInvalidEndpointReqTC() {
        UpdateTrainCarriage.sendInvalidEndpointRequestUTC();
    }

    @Then("Receive 404 UTC response Invalid Endpoint")
    public void receiveInvalidEndpointResponseTC() {
        UpdateTrainCarriage.validateResponse404UTC();
    }

    //======================================================INVALID REQUEST=============================================

    @Given("Enter Endpoint Login Valid Endpoint UTC3")
    public void endpointLoginUTC3(){
        UpdateTrainCarriage.setEndpointLoginUTC3();
    }
    @When("Enter Request Login Valid Endpoint UTC3")
    public void reqLoginUTC3(){
        UpdateTrainCarriage.sendRequestLoginUTC3();
    }
    @When("Enter Endpoint UTC Valid Endpoint for invalid request")
    public void setInvalidRequestValidEndpointUTC() {
        UpdateTrainCarriage.setInvalidRequestValidEndpointUTC();
    }

    @When("Enter Request UTC Valid Endpoint for invalid request")
    public void sendInvalidReqTC() {
        UpdateTrainCarriage.sendInvalidRequestUTC();
    }

    @Then("Receive 400 UTC response Valid Endpoint for invalid request")
    public void receiveInvalidRequestResponseTC() {
        UpdateTrainCarriage.validateResponse400UTC();
    }
//    @Given("Enter Endpoint Login Valid Endpoint TC2")
//    public void endpointLoginCreateTC2(){
//        UpdateTrainCarriage.setEndpointLogin2();
//    }
//    @When("Enter Request Login Valid Endpoint TC2")
//    public void reqLoginCreateTC2(){
//        UpdateTrainCarriage.sendRequestLogin2();
//    }
//    @When("Enter Endpoint TC Invalid Endpoint")
//    public void setInvalidEndpointCreateTC() {
//        UpdateTrainCarriage.setInvalidEndpointTC();
//    }
//
//    @When("Enter Request TC Invalid Endpoint")
//    public void sendInvalidEndpointReqCreateTC() {
//        UpdateTrainCarriage.sendInvalidEndpointRequestCreateTC();
//    }
//
//    @Then("Receive 404 response Invalid Endpoint")
//    public void receiveInvalidEndpointResponseCreateTC() {
//        UpdateTrainCarriage.validateInvalidEndpointResponse404TC();
//    }
////==========================================================INVALID REQUEST=============================================
//@Given("Enter Endpoint Login Valid Endpoint TC3")
//public void endpointLoginCreateTC3(){
//    UpdateTrainCarriage.setEndpointLogin3();
//}
//    @When("Enter Request Login Valid Endpoint TC3")
//    public void reqLoginCreateTC3(){
//        UpdateTrainCarriage.sendRequestLogin3();
//    }
//    @When("Enter Endpoint TC Valid Endpoint for invalid request")
//    public void setValidEndpointInvalidReqCreateTC() {
//        UpdateTrainCarriage.setValidEndpointInvalidReqTC();
//    }
//
//    @When("Enter Request TC Valid Endpoint for invalid request")
//    public void sendReqInvalidReqCreateTC() {
//        UpdateTrainCarriage.sendRequestCreateInvalidReqTC();
//    }
//
//    @Then("Receive 400 response Invalid Endpoint for invalid request")
//    public void receiveResponseInvalidReqCreateTC() {
//        UpdateTrainCarriage.validateResponse400TC();
//    }


























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
