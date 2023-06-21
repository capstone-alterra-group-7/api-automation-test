package starter.stepdef.Admin.HotelRoom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel_Room.Update_HR;

public class Update_HRSteps {

    @Steps
    Update_HR updateHr;

    @Given("Enter Endpoint Login Valid Endpoint update hotel room")
    public void EnterEndpointLoginValidEndpointUpdateHotelRoom() {
        updateHr.SetUpdateApiNewHR();
    }

    @When("Enter Request Login Valid Endpoint update hotel room")
    public void enterRequestLoginValidEndpointUpdateHotelRoom() {
        updateHr.RequestLoginUpdateHR();
    }

    @And("Enter Endpoint update hotel room Valid Endpoint")
    public void enterEndpointUpdateHotelRoomValidEndpoint() {
        updateHr.setValidEndpointUpdateHR();
    }

    @And("Enter Request update hotel room Valid Endpoint")
    public void enterRequestUpdateHotelRoomValidEndpoint() {
        updateHr.PutUpdateHREndpoints();
    }

    @Then("Receive response code Update hotel room {int}")
    public void receiveResponseCodeUpdateHotelRoom(int arg0) {
        updateHr.SuccessUpdateHR();
    }


}
