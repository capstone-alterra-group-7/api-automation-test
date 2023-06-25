package starter.stepdef.User.Hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import starter.pages.User.Hotel.OrderHotelPage;

public class OrderHotelSteps {
    @Steps
    OrderHotelPage orderHotelPage;

    @Given("Enter Endpoint Login Valid Endpoint UOH")
    public void loginValidEndpointGetHotelOrderUOH() {
        orderHotelPage.setEndpointLoginUOH();
    }

    @When("Enter Request Login Valid Endpoint UOH")
    public void sendreqvalidLoginHotelOrderUOH() {
        orderHotelPage.sendRequestLoginUOH();
    }

    @When("Enter Endpoint UOH Valid Endpoint")
    public void validEndpointHotelOrderUOH() {
        orderHotelPage.setValidEndpointUOH();
    }

    @When("Enter Request UOH Valid Endpoint")
    public void enterRequestHotelOrderUOH() {
        orderHotelPage.sendRequestCreateUOH();
    }

    @Then("Receive 201 response UOH Valid Endpoint")
    public void getStatuscode201UOH() {
        orderHotelPage.validateResponse201UOH();
    }

    @Then("Receive Data response UOH Valid Endpoint")
    public void ValidatesuccessPostHotelOrderUOH() {
        orderHotelPage.validateValidDataResponseForUOH();
    }

    //==============================================================================INVALID ENDPOINT==============================
    @Given("Enter Endpoint Login UOH2")
    public void loginValidEndpointGetHotelOrderUOH2() {
        orderHotelPage.setEndpointLoginUOH();
    }

    @When("Enter Request Login UOH2")
    public void sendreqvalidLoginHotelOrderUOH2() {
        orderHotelPage.sendRequestLoginUOH();
    }

    @When("Enter Endpoint UOH2")
    public void invalidEndpointHotelOrderUOH2() {
        orderHotelPage.setEndpointUOH2();
    }

    @When("Enter Request UOH2")
    public void enterRequestHotelOrderUOH2() {
        orderHotelPage.sendRequestCreateUOH2();
    }

    @Then("Receive 404 response UOH2")
    public void getStatuscode404UOH2() {
        orderHotelPage.validateResponseUOH2();
    }

    @Then("Receive Data response UOH2")
    public void ValidateFailPostHotelOrderUOH2() {
        orderHotelPage.validateResponseForUOH2();
    }
    //==============================================================================INVALID REQUEST==============================

    @Given("Enter Endpoint Login UOH3")
    public void loginValidEndpointGetHotelOrderUOH3() {
        orderHotelPage.setEndpointLoginUOH();
    }

    @When("Enter Request Login UOH3")
    public void sendreqvalidLoginHotelOrderUOH3() {
        orderHotelPage.sendRequestLoginUOH();
    }

    @When("Enter Endpoint UOH3")
    public void invalidEndpointHotelOrderUOH3() {
        orderHotelPage.setValidEndpointUOH();
    }

    @When("Enter Request UOH3")
    public void enterRequestHotelOrderUOH3() {
        orderHotelPage.sendRequestCreateUOH3();
    }

    @Then("Receive 404 response UOH3")
    public void getStatuscode400UOH3() {
        orderHotelPage.validateResponseUOH3();
    }

    @Then("Receive Data response UOH3")
    public void ValidateFailPostHotelOrderUOH3() {
        orderHotelPage.validateResponseForUOH3();
    }
}
