package starter.stepdef.Admin.Hotel;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel.UpdateHotel_Put;

public class UpdateHotel_Steps {

    @Steps
    UpdateHotel_Put updateHotelPut;

    @Given("Enter Endpoint Login Valid Endpoint update hotel")
    public void EnterEndpointLoginValidEndpointUpdateHotel() {
        updateHotelPut.EndpointLoginUpdateHotel();
    }

    @When("Enter Request Login Valid Endpoint update hotel")
    public void RequestLoginValidEndpointUpdateHotel () {
        updateHotelPut.RequestLoginUpdateHotel();
    }

    @And("Enter Endpoint update hotel Valid Endpoint")
    public void EnterEndpointUpdateHotelValidEndpoint() {
        updateHotelPut.setValidEndpointUpdateHotel();
    }

    @And("Enter Request update hotel Valid Endpoint")
    public void EnterRequestUpdateHotelValidEndpoint() {
        updateHotelPut.PostUpdateHotelEndpoints();
    }


    @Then("Receive response code Update hotel {int}")
    public void receiveResponseCodeUpdateHotel(int arg0) {
        updateHotelPut.SuccessUpdateHotel();
    }
}
