package starter.stepdef.Admin.HotelRoom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel_Room.CreateNewHR;

public class CreateNewHR_Steps {


    @Steps
    CreateNewHR createNewHR;

    @Given("Enter Endpoint Login Valid Endpoint New hotel room")
    public void EnterEndpointLoginValidEndpointNewHotelRoom() {
        createNewHR.SetPostApiNewHotelRoom();
    }


    @When("Enter Request Login Valid Endpoint New hotel room")
    public void enterRequestLoginValidEndpointNewHotelRoom() {
        createNewHR.RequestCreateNewHR();
    }

    @And("Enter Endpoint New Hotel room Valid Endpoint")
    public void enterEndpointNewHotelRoomValidEndpoint() {
        createNewHR.setPostValidEndpointPOSTCrateNewHR();
    }

    @And("Enter Request New Hotel room Valid Endpoint")
    public void enterRequestNewHotelRoomValidEndpoint() {
        createNewHR.PostNewHREndpoints();
    }

    @Then("Receive Valid Http Create New Hotel room response code {int}")
    public void receiveValidHttpCreateNewHotelRoomResponseCode(int arg0) {
        createNewHR.receiveValidHttpCreateNewHotelRoomResponseCode201();
    }
}
