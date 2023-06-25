package starter.stepdef.User.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Order.GetHotelOrder;
import starter.pages.User.Order.GetHotelOrderUserById;

public class getHotelOrderByID {
    @Steps
    GetHotelOrderUserById getHotelorderbyid;

    @Given("input endpoint Login Valid Endpoint get hotel order user by id")
    public void loginValidEndpointGetHotelOrderbyId() {
        getHotelorderbyid.setEndpointLogin();
    }

    @When("input  request Login Valid Endpoint get hotel order user by id")
    public void sendreqvalidLoginHotelOrderbyId() {
        getHotelorderbyid.sendRequestLogin();
    }

    @When("user on the get hotel order by id user endpoint")
    public void validEndpointHotelOrderbyId() {
        getHotelorderbyid.getEndpointHotelOrderbyId();
    }

    @When("user create request with GET method valid endpoint")
    public void enterValidEndpointAllHotelOrderbyId() {
        getHotelorderbyid.getAllHotelOrderDatabyId();
    }

    @Then("get status code {int} Okk")
    public void getStatuscode200(int arg0) {
        getHotelorderbyid.validateStatusCodebyId();
    }

    @And("get valid data hotel order user by id")
    public void succesgetDataAllHotelOrderbyId() {
        getHotelorderbyid.succesGetHotelOrderbyId();
    }
}

