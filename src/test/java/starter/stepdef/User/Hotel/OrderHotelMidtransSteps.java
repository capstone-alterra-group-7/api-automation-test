package starter.stepdef.User.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Hotel.OrderHotelMidtransPage;


public class OrderHotelMidtransSteps {
    @Steps
    OrderHotelMidtransPage orderHotelMidtransPage;

    @Given("Enter Endpoint Login Valid Endpoint UOHMD")
    public void loginValidEndpointGetHotelOrderUOHMD() {
        orderHotelMidtransPage.setEndpointLoginUOHMD();
    }

    @When("Enter Request Login Valid Endpoint UOHMD")
    public void sendreqvalidLoginHotelOrderUOHMD() {
        orderHotelMidtransPage.sendRequestLoginUOHMD();
    }

    @When("Enter Endpoint UOHMD Valid Endpoint")
    public void validEndpointHotelOrderUOHMD() {
        orderHotelMidtransPage.setValidEndpointUOHMD();
    }

    @When("Enter Request UOHMD Valid Endpoint")
    public void enterRequestHotelOrderUOHMD() {
        orderHotelMidtransPage.sendRequestCreateUOHMD();
    }

    @Then("Receive 201 response UOHMD Valid Endpoint")
    public void getStatuscode201UOHMD() {
        orderHotelMidtransPage.validateResponse201UOHMD();
    }

    @Then("Receive Data response UOHMD Valid Endpoint")
    public void ValidatesuccessPostHotelOrderUOHMD() {
        orderHotelMidtransPage.validateValidDataResponseForUOHMD();
    }

    //==============================================================================INVALID ENDPOINT==============================
    @Given("Enter Endpoint Login UOHMD2")
    public void loginValidEndpointGetHotelOrderUOHMD2() {
        orderHotelMidtransPage.setEndpointLoginUOHMD();
    }

    @When("Enter Request Login UOHMD2")
    public void sendreqvalidLoginHotelOrderUOHMD2() {
        orderHotelMidtransPage.sendRequestLoginUOHMD();
    }

    @When("Enter Endpoint UOHMD2")
    public void invalidEndpointHotelOrderUOHMD2() {
        orderHotelMidtransPage.setEndpointUOHMD2();
    }

    @When("Enter Request UOHMD2")
    public void enterRequestHotelOrderUOHMD2() {
        orderHotelMidtransPage.sendRequestCreateUOHMD2();
    }

    @Then("Receive 404 response UOHMD2")
    public void getStatuscode404UOHMD2() {
        orderHotelMidtransPage.validateResponseUOHMD2();
    }

    @Then("Receive Data response UOHMD2")
    public void ValidateFailPostHotelOrderUOHMD2() {
        orderHotelMidtransPage.validateResponseForUOHMD2();
    }
    //==============================================================================INVALID REQUEST==============================

    @Given("Enter Endpoint Login UOHMD3")
    public void loginValidEndpointGetHotelOrderUOHMD3() {
        orderHotelMidtransPage.setEndpointLoginUOHMD();
    }

    @When("Enter Request Login UOHMD3")
    public void sendreqvalidLoginHotelOrderUOHMD3() {
        orderHotelMidtransPage.sendRequestLoginUOHMD();
    }

    @When("Enter Endpoint UOHMD3")
    public void invalidEndpointHotelOrderUOHMD3() {
        orderHotelMidtransPage.setValidEndpointUOHMD();
    }

    @When("Enter Request UOHMD3")
    public void enterRequestHotelOrderUOHMD3() {
        orderHotelMidtransPage.sendRequestCreateUOHMD3();
    }

    @Then("Receive 404 response UOHMD3")
    public void getStatuscode400UOHMD3() {
        orderHotelMidtransPage.validateResponseUOHMD3();
    }

    @Then("Receive Data response UOHMD3")
    public void ValidateFailPostHotelOrderUOHMD3() {
        orderHotelMidtransPage.validateResponseForUOHMD3();
    }
}
