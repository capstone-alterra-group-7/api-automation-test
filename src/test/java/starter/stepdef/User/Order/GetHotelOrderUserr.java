package starter.stepdef.User.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import starter.pages.User.Order.GetHotelOrder;

public class GetHotelOrderUserr {
    @Steps
    GetHotelOrder getHotel;

    @Given("input endpoint Login Valid Endpoint get hotel order user")
    public void loginValidEndpointGetHotelOrder() {
        getHotel.setEndpointLogin();
    }

    @When("input  request Login Valid Endpoint get hotel order user")
    public void sendreqvalidLoginHotelOrder() {
        getHotel.sendRequestLogin();
    }

    @When("user on the get hotel order user endpoint")
    public void validEndpointHotelOrder() {
        getHotel.getEndpointHotelOrder();
    }

    @When("user create request with GET method endpoint")
    public void enterValidEndpointAllHotelOrder() {
        getHotel.getAllHotelOrderData();
    }

    @Then("get status code {int} OKE")
    public void getStatuscode200(int arg0) {
        getHotel.validateStatusCode();
    }

    @And("get valid data hotel order user")
    public void succesgetDataAllHotelOrder() {
        getHotel.succesGetHotelOrder();
    }
}
