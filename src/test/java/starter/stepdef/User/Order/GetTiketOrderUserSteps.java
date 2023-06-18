package starter.stepdef.User.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Order.GetTiketOrderUser;
import starter.pages.userOrder.GetTiketOrderUserTCN2;

public class GetTiketOrderUserSteps {
    @Steps
    GetTiketOrderUser getTiket;

    @Steps
    GetTiketOrderUserTCN2 getTiketTCN2;

    @Given("input endpoint Login Valid Endpoint get tiket order user")
    public void loginValidEndpointGetTiketOrder() {
        getTiket.setEndpointLogin();
    }

    @When("input  request Login Valid Endpoint get tiket order user")
    public void sendreqvalidLoginTiketOrder() {
        getTiket.sendRequestLogin();
    }



//    TCN1- ID TIKET TIDAK ADA
    @When("user on the get tiket order user endpoint with  invalid token")
    public void validEndpointTiketOrder() {
        getTiketTCN2.getEndpointTiketOrderIntoken();
    }

    @When("user create request with GET Endpoint tiket order using  invalid token")
    public void enterValidEndpointAllTiketOrder() {
        getTiketTCN2.getAllTiketOrderIntoken();
    }

    @Then("user get status code {int} unautorizedd")
    public void getStatuscode200(int arg0) {
        getTiketTCN2.validateStatusCodeTiketOrderIntoken();
    }

    @And("get message token signature is invalid:")
    public void succesgetDataAllTiketOrder() {
        getTiketTCN2.succesGetTiketOrderIntoken();
    }

}

