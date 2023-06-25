package starter.stepdef.Admin.HotelRoom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel_Room.HR_Get;

public class HR_GetSteps {

    @Steps
    HR_Get hrGet;

    @Given("I set hotel room API api endpoints")
    public void ISetHotelRoomApiEndpoints() {
        hrGet.SetHotelRoomAPIEndpoint();
    }

    @When("I request to endpoint for Get All Hotel room")
    public void RequestToEndpointForGetAllHotelRoom() {
        hrGet.HotelRoomSendRequestLogin();
    }


    @And("user set GET Hotel room valid endpoints")
    public void SetGetHotelRoomValidEndpoints() {
        hrGet.UserSetGetHotelRoomValidEndpoints();
    }

    @And("user send GET Hotel room HTTP request with valid endpoint")
    public void SendGetHotelRoomHttpRequestWithValidEndpoints() {
        hrGet.SendHttpRequestHotelRoomGet();
    }


    @Then("I receive valid HTTP Get Hotel room response code {int}")
    public void iReceiveValidHTTPGetHotelRoomResponseCode(int arg0) {
        hrGet.ReceiveHttpGetHotelRoom200();
    }

    @Given("I set hotel room API invalid endpoints")
    public void iSetHotelRoomApiInvalidEndpoints() {
        hrGet.SetHotelRoomAPInvalidEndpoint();
    }

    @When("I request to endpoint for Get All Hotel room invalid")
    public void RequestToEndpointForGetAllHotelRoomInvalid() {
        hrGet.HotelRoomSendRequestLogin1();
    }

    @And("user set GET Hotel room invalid endpoints")
    public void UserSetGetHotelRoomInvalidEndpoints() {
        hrGet.UserSetGetHotelRoomInvalidEndpoints();
    }


    @And("user send GET invalid Hotel room HTTP  request with valid endpoint")
    public void UserSendGetInvalidHotelRoomHttpRequestWithValidEndpoint() {
        hrGet.SendHttpRequestHotelRoomGetInvalid();
    }

    @Then("I receive valid HTTP Get invalid Hotel room response code {int}")
    public void iReceiveInvalidHTTPGetHotelRoomResponseCode(int arg0) {
        hrGet.ReceiveHttpGetHotelRoom400();
    }

}
