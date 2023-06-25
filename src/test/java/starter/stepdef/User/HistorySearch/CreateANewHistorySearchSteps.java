package starter.stepdef.User.HistorySearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.HistorySearch.CreateANewHistorySearchPage;

public class CreateANewHistorySearchSteps {

    @Steps
    CreateANewHistorySearchPage CreateANewHistorySearch;

    @Given("Enter Endpoint Login Valid Endpoint CHS")
    public void endpointLoginCreateCHS() {
        CreateANewHistorySearch.setEndpointLoginCHS();
    }

    @When("Enter Request Login Valid Endpoint CHS")
    public void reqLoginCreateCHS() {
        CreateANewHistorySearch.sendRequestLoginCHS();
    }

    @When("Enter Endpoint CHS Valid Endpoint")
    public void setValidEndpointCreateCHS() {
        CreateANewHistorySearch.setValidEndpointCHS();
    }

    @When("Enter Request CHS Valid Endpoint")
    public void sendReqCreateCHS() {
        CreateANewHistorySearch.sendRequestCreateCHS();
    }

    @Then("Receive 201 response CHS Valid Endpoint")
    public void receiveResponseCreateCHS() {
        CreateANewHistorySearch.validateResponse201CHS();
    }

    @Then("Receive Data response CHS Valid Endpoint")
    public void receiveDataResponseCreateCHS() {
        CreateANewHistorySearch.validateValidDataResponseForCHS();
    }
        //=======================================================INVALID ENDPOINT==========================================

        @Given("Enter Endpoint Login Valid Endpoint CHS2")
        public void endpointLoginCreateCHS2 () {
            CreateANewHistorySearch.setEndpointLoginCHS2();
        }

        @When("Enter Request Login Valid Endpoint CHS2")
        public void reqLoginCreateCHS2 () {
            CreateANewHistorySearch.sendRequestLoginCHS2();
        }

        @When("Enter Endpoint CHS Invalid Endpoint")
        public void setInvalidEndpointCreateCHS () {
            CreateANewHistorySearch.setInvalidEndpointCHS();
        }

        @When("Enter Request CHS Invalid Endpoint")
        public void sendInvalidEndpointReqCreateCHS () {
            CreateANewHistorySearch.sendInvalidEndpointRequestCreateCHS();
        }

        @Then("Receive 404 response CHS Invalid Endpoint")
        public void receiveInvalidEndpointResponseCreateCHS () {
            CreateANewHistorySearch.validateInvalidEndpointResponse404CHS();
        }
        @Then("Receive Data response CHS Invalid Endpoint")
        public void receiveDataResponseInvalidCreateCHS () {
            CreateANewHistorySearch.validateInvalidDataResponseForCHS();
        }


//==========================================================INVALID REQUEST=============================================
        @Given("Enter Endpoint Login Valid Endpoint CHS3")
        public void endpointLoginCreateCHS3 () {
            CreateANewHistorySearch.setEndpointLoginCHS3();
        }
        @When("Enter Request Login Valid Endpoint CHS3")
        public void reqLoginCreateCHS3 () {
            CreateANewHistorySearch.sendRequestLoginCHS3();
        }
        @When("Enter Endpoint CHS Invalid Request")
        public void setValidEndpointInvalidReqCreateCHS () {
            CreateANewHistorySearch.setValidEndpointInvalidReqCHS();
        }

        @When("Enter Request CHS Invalid Request")
        public void sendReqInvalidReqCreateCHS () {
            CreateANewHistorySearch.sendRequestCreateInvalidReqCHS();
        }

        @Then("Receive 400 response CHS Invalid Request")
        public void receiveResponseInvalidReqCreateCHS () {
            CreateANewHistorySearch.validateResponse400CHS();
        }
        @Then("Receive Data response CHS Invalid Request")
        public void receiveDataResponseInvalidReqCreateCHS() {
            CreateANewHistorySearch.validateInvalidDataResponseInvalidReqForCHS();
        }

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

