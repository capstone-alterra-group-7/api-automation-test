package starter.stepdef.User.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Hotel.UpdateOrderHotelPage;

public class UpdateOrderHotelSteps {
    @Steps
    UpdateOrderHotelPage updateOrderHotelPage;

    @Given("Enter Endpoint Login Valid Endpoint PUOH")
    public void loginValidEndpointGetHotelOrderPUOH() {
        updateOrderHotelPage.setEndpointLoginPUOH();
    }

    @When("Enter Request Login Valid Endpoint PUOH")
    public void sendreqvalidLoginHotelOrderPUOH() {
        updateOrderHotelPage.sendRequestLoginPUOH();
    }

    @When("Enter Endpoint PUOH Valid Endpoint")
    public void validEndpointHotelOrderPUOH() {
        updateOrderHotelPage.setValidEndpointPUOH();
    }

    @When("Enter Request PUOH Valid Endpoint")
    public void enterRequestHotelOrderPUOH() {
        updateOrderHotelPage.sendRequestCreatePUOH();
    }

    @Then("Receive 201 response PUOH Valid Endpoint")
    public void getStatuscode201PUOH() {
        updateOrderHotelPage.validateResponse201PUOH();
    }

    @Then("Receive Data response PUOH Valid Endpoint")
    public void ValidatesuccessPostHotelOrderPUOH() {
        updateOrderHotelPage.validateValidDataResponseForPUOH();
    }

    //==============================================================================INVALID ENDPOINT==============================
//    @Given("Enter Endpoint Login PUOH2")
//    public void loginValidEndpointGetHotelOrderPUOH2() {
//        updateOrderHotelPage.setEndpointLoginPUOH();
//    }
//
//    @When("Enter Request Login PUOH2")
//    public void sendreqvalidLoginHotelOrderPUOH2() {
//        updateOrderHotelPage.sendRequestLoginPUOH();
//    }
//
//    @When("Enter Endpoint PUOH2")
//    public void invalidEndpointHotelOrderPUOH2() {
//        updateOrderHotelPage.setEndpointPUOH2();
//    }
//
//    @When("Enter Request PUOH2")
//    public void enterRequestHotelOrderPUOH2() {
//        updateOrderHotelPage.sendRequestCreatePUOH2();
//    }
//
//    @Then("Receive 404 response PUOH2")
//    public void getStatuscode404PUOH2() {
//        updateOrderHotelPage.validateResponsePUOH2();
//    }
//
//    @Then("Receive Data response PUOH2")
//    public void ValidateFailPostHotelOrderPUOH2() {
//        updateOrderHotelPage.validateResponseForPUOH2();
//    }
//    //==============================================================================INVALID REQUEST==============================
//
//    @Given("Enter Endpoint Login PUOH3")
//    public void loginValidEndpointGetHotelOrderPUOH3() {
//        updateOrderHotelPage.setEndpointLoginPUOH();
//    }
//
//    @When("Enter Request Login PUOH3")
//    public void sendreqvalidLoginHotelOrderPUOH3() {
//        updateOrderHotelPage.sendRequestLoginPUOH();
//    }
//
//    @When("Enter Endpoint PUOH3")
//    public void invalidEndpointHotelOrderPUOH3() {
//        updateOrderHotelPage.setValidEndpointPUOH();
//    }
//
//    @When("Enter Request PUOH3")
//    public void enterRequestHotelOrderPUOH3() {
//        updateOrderHotelPage.sendRequestCreatePUOH3();
//    }
//
//    @Then("Receive 404 response PUOH3")
//    public void getStatuscode400PUOH3() {
//        updateOrderHotelPage.validateResponsePUOH3();
//    }
//
//    @Then("Receive Data response PUOH3")
//    public void ValidateFailPostHotelOrderPUOH3() {
//        updateOrderHotelPage.validateResponseForPUOH3();
//    }
}
