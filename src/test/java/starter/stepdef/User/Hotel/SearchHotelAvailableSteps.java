package starter.stepdef.User.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Hotel.SearchHotelAvailablePage;


public class SearchHotelAvailableSteps {
    @Steps
    SearchHotelAvailablePage searchHotelAvailablePage;

    @Given("Enter Endpoint Login Valid Endpoint SHA")
    public void loginValidEndpointGetHotelOrderSHA() {
        searchHotelAvailablePage.setEndpointLoginSHA();
    }

    @When("Enter Request Login Valid Endpoint SHA")
    public void sendreqvalidLoginHotelOrderSHA() {
        searchHotelAvailablePage.sendRequestLoginSHA();
    }

    @When("Enter Endpoint SHA Valid Endpoint")
    public void validEndpointHotelOrderSHA() {
        searchHotelAvailablePage.setValidEndpointSHA();
    }

    @When("Enter Request SHA Valid Endpoint")
    public void enterRequestHotelOrderSHA() {
        searchHotelAvailablePage.sendRequestCreateSHA();
    }

    @Then("Receive 201 response SHA Valid Endpoint")
    public void getStatuscode201SHA() {
        searchHotelAvailablePage.validateResponse201SHA();
    }

    @Then("Receive Data response SHA Valid Endpoint")
    public void ValidatesuccessPostHotelOrderSHA() {
        searchHotelAvailablePage.validateValidDataResponseForSHA();
    }

    //==============================================================================INVALID ENDPOINT==============================
//    @Given("Enter Endpoint Login SHA2")
//    public void loginValidEndpointGetHotelOrderSHA2() {
//        searchHotelAvailablePage.setEndpointLoginSHA();
//    }
//
//    @When("Enter Request Login SHA2")
//    public void sendreqvalidLoginHotelOrderSHA2() {
//        searchHotelAvailablePage.sendRequestLoginSHA();
//    }
//
//    @When("Enter Endpoint SHA2")
//    public void invalidEndpointHotelOrderSHA2() {
//        searchHotelAvailablePage.setEndpointSHA2();
//    }
//
//    @When("Enter Request SHA2")
//    public void enterRequestHotelOrderSHA2() {
//        searchHotelAvailablePage.sendRequestCreateSHA2();
//    }
//
//    @Then("Receive 404 response SHA2")
//    public void getStatuscode404SHA2() {
//        searchHotelAvailablePage.validateResponseSHA2();
//    }
//
//    @Then("Receive Data response SHA2")
//    public void ValidateFailPostHotelOrderSHA2() {
//        searchHotelAvailablePage.validateResponseForSHA2();
//    }
    //==============================================================================INVALID REQUEST==============================

//    @Given("Enter Endpoint Login SHA3")
//    public void loginValidEndpointGetHotelOrderSHA3() {
//        searchHotelAvailablePage.setEndpointLoginSHA();
//    }
//
//    @When("Enter Request Login SHA3")
//    public void sendreqvalidLoginHotelOrderSHA3() {
//        searchHotelAvailablePage.sendRequestLoginSHA();
//    }
//
//    @When("Enter Endpoint SHA3")
//    public void invalidEndpointHotelOrderSHA3() {
//        searchHotelAvailablePage.setValidEndpointSHA();
//    }
//
//    @When("Enter Request SHA3")
//    public void enterRequestHotelOrderSHA3() {
//        searchHotelAvailablePage.sendRequestCreateSHA3();
//    }
//
//    @Then("Receive 404 response SHA3")
//    public void getStatuscode400SHA3() {
//        searchHotelAvailablePage.validateResponseSHA3();
//    }
//
//    @Then("Receive Data response SHA3")
//    public void ValidateFailPostHotelOrderSHA3() {
//        searchHotelAvailablePage.validateResponseForSHA3();
//    }
}
