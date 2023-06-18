package starter.stepdef.User.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Order.GetTiketOrderById;
import starter.pages.userOrder.GetTiketOrderByidTCN2;


public class getTiketOrderByID {
    @Steps
    GetTiketOrderById getTiketbyID;

    @Steps
    GetTiketOrderByidTCN2 getTiketbyIDIntoken;

    @Given("input endpoint Login Valid Endpoint get tiket order user by id")
    public void loginValidEndpointGetTiketOrder() {
        getTiketbyID.setEndpointLogin();
    }

    @When("input  request Login Valid Endpoint get tiket order user by id")
    public void sendreqvalidLoginTiketOrder() {
        getTiketbyID.sendRequestLogin();
    }

    @When("user on the get tiket order user by id endpoint")
    public void validEndpointTiketOrder() {
        getTiketbyID.getEndpointTiketOrder();
    }

    @When("user create request with GET Endpoint")
    public void enterValidEndpointAllTiketOrder() {
        getTiketbyID.getAllTiketOrder();
    }

    @Then("user get status code {int} OK")
    public void getStatuscode200(int arg0) {
        getTiketbyID.validateStatusCodeTiketOrder();
    }

    @And("get valid data tiket order user by id")
    public void succesgetDataAllTiketOrder() {
        getTiketbyID.succesGetTiketOrder();
    }

    //    TCN1- ID TIKET TIDAK ADA

    @When("user on the get tiket order user by id endpoint with invalid id")
    public void validEndpointTiketOrderIDInvalid() {
        getTiketbyID.getEndpointTiketOrderIDInvalid();
    }

    @When("user create request with GET Endpoint tiket order by id")
    public void enterValidEndpointTiketOrderIDInvalid() {
        getTiketbyID.getAllTiketOrderIDInvalid();
    }

    @Then("user get status code {int} not found")
    public void getStatuscode400(int arg0) {
        getTiketbyID.validateStatusCodeTiketOrderIDInvalid();
    }

    @And("get get message Failed to get a ticket order")
    public void succesgetDataTiketOrderIDInvalid() {
        getTiketbyID.succesGetTiketOrderIDInvalid();
    }

    //    TCN2- INVALID TOKEN

    @When("user on the get tiket order user by id endpoint with  invalid token")
    public void validEndpointTiketOrderInvalidToken() {
        getTiketbyIDIntoken.getAllTiketOrderInvalidToken();
    }

    @When("user create request with GET Endpoint tiket order by id using  invalid token")
    public void enterValidEndpointTiketOrderInvalidToken() {
        getTiketbyIDIntoken.getAllTiketOrderInvalidToken();
    }

    @Then("user get status code {int} unautorized")
    public void getStatuscode401(int arg0) {
        getTiketbyIDIntoken.validateStatusCodeTiketOrderInvalidToken();
    }

    @And("get get message token signature is invalid")
    public void succesgetDataTiketOrderInvalidToken() {
        getTiketbyIDIntoken.succesGetTiketOrderInvalidToken();
    }

}
