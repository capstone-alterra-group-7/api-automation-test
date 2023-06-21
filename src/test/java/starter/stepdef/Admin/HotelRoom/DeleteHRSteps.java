package starter.stepdef.Admin.HotelRoom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel_Room.Delete_HR;

public class DeleteHRSteps {

    @Steps
    Delete_HR deleteHr;

    @Given("I have endpoint post new login for delete hotel room")
    public void iHaveEndpointPostNewLoginForDeleteHotelRoom() {
        deleteHr.SetEndpointLoginDeleteHR();
    }

    @When("I send request to endpoint for delete hotel room")
    public void iSendRequestToEndpointForDeleteHotelRoom() {
        deleteHr.sendRequestLoginForDeleteHR();
    }

    @When("user set DELETE valid endpoint for delete hotel room")
    public void userSetDELETEValidEndpointForDeleteHotelRoom() {
        deleteHr.setDeleteValidEndpointForDeleteHR();
    }

    @When("user send DELETE hotel room HTTP request with valid endpoint")
    public void userSendDELETEHotelRoomHTTPRequestWithValidEndpoint() {
        deleteHr.sendPOSTHTTPRequestForDeleteHR();
    }

    @Then("user received valid DELETE hotel room HTTP response code {int}")
    public void userReceivedValidDELETEHotelRoomHTTPResponseCode(int arg0) {
        deleteHr.validateHTTPResponseCode200ForDeleteHR();
    }

}
