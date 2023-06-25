package starter.stepdef.Admin.Hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel.DeleteHotel;

public class DeleteHotel_Steps {

    @Steps
    DeleteHotel deleteHotel;

    @Given("I have endpoint post new login for delete hotel")
    public void HaveEndpointPostNewLoginForDeleteHotel() {
        deleteHotel.SetEndpointLoginDeleteHotel();
    }

    @When("I send request to endpoint for delete hotel")
    public void iSendRequestToEndpointForDeleteHotel() {
        deleteHotel.sendRequestLoginForDeleteHotel();
    }

    @When("user set DELETE valid endpoint for delete hotel")
    public void userSetDELETEValidEndpointForDeleteHotel() {
        deleteHotel.setDeleteValidEndpointForDeleteHotel();
    }

    @When("user send DELETE hotel HTTP request with valid endpoint")
    public void userSendDELETEHotelHTTPRequestWithValidEndpoint() {
        deleteHotel.sendPOSTHTTPRequestForDeleteHotel();
    }

    @Then("user received valid DELETE hotel HTTP response code {int}")
    public void userReceivedValidDELETEHotelHTTPResponseCode(int arg0) {
        deleteHotel.validateHTTPResponseCode200ForDeleteHotel();
    }

    @Given("I have invalid endpoint post new login for delete hotel")
    public void iHaveInvalidEndpointPostNewLoginForDeleteHotel() {
        deleteHotel.SetEndpointLoginDeleteHotel1();
    }

    @When("I send request to endpoint invalid for delete hotel")
    public void iSendRequestToEndpointInvalidForDeleteHotel() {
        deleteHotel.sendRequestLoginForDeleteHotel1();
    }

    @When("user set DELETE invalid endpoint for delete hotel")
    public void userSetDELETEInvalidEndpointForDeleteHotel() {
        deleteHotel.setDeleteValidEndpointForDeleteHotel1();
    }

    @When("user send DELETE hotel HTTP request with invalid endpoint")
    public void userSendDELETEHotelHTTPRequestWithInvalidEndpoint() {
        deleteHotel.sendPOSTHTTPRequestForDeleteHotel1();
    }

    @Then("user received invalid DELETE hotel HTTP response code {int}")
    public void userReceivedInvalidDELETEHotelHTTPResponseCode(int arg0) {
        deleteHotel.validateHTTPResponseCode400ForDeleteHotel();
    }
}
