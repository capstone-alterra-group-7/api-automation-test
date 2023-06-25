package starter.stepdef.Admin.HotelRoom;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel_Room.HR_GetById;

public class HR_GetByIDSteps {

    @Steps
    HR_GetById hrGetById;

    @Given("I have endpoint post new login for Id Hotel room")
    public void HaveEndpointPostNewLoginForIdHotelRoom () {
        hrGetById.SetHotelRoomAPIEndpointForId();
    }

    @When("I send request to endpoint for Id Hotel room")
    public void SendRequestToEndpointForIdHotelRoom () {
        hrGetById.HotelRoomSendRequestLoginForId();
    }

    @And("user set GET valid endpoint for Id Hotel room")
    public void SetGetValidEndpointForIdHotelRoom ()  {
        hrGetById.UserSetGetIdHotelRoomValidEndpoints();
    }

    @And("user send GET HTTP request with valid endpoint for Id Hotel room")
    public void SendGetHttpRequestWithValidEndpointForIdHotelRoom() {
        hrGetById.SendHttpRequestHotelRoomGetId();
    }

    @Then("user received valid Get By Id hr HTTP response code {int}")
    public void UserReceivedValidGetByIdHrHttpResponseCode(int arg0) {
        hrGetById.ReceiveHttpGetIdHotelRoom200();
    }

    @Given("I have endpoint post new login for Id Invalid Hotel room")
    public void HaveEndpointPostNewLoginForIdInvalidHotelRoom () {
        hrGetById.InvalidHotelRoomAPIEndpointForId();
    }

    @When("I send request to endpoint for Id Invalid Hotel room")
    public void SendRequestToEndpointForIdInvalidHotelRoom () {
        hrGetById.HotelRoomSendRequestLoginForId1();
    }

    @And("user set GET valid endpoint for Id Invalid Hotel room")
    public void UserSetGetValidEndpointForIdInvalidHotelRoom() {
        hrGetById.UserSetGetIdHotelRoomInvalidEndpoints();
    }

    @And("user send GET HTTP request with invalid endpoint for Id Hotel room")
    public void UserSendGetHttpRequestWithInvalidEndpointForIdHotelRoom () {
        hrGetById.InvalidSendHttpRequestHotelRoomGetId();
    }

    @Then("user received invalid Get By Id hr HTTP response code {int}")
    public void UserReceivedInvalidGetByIdHrHttpResponseCode (int arg0) {
        hrGetById.InvalidReceiveHttpGetIdHotelRoom400();
    }

}
