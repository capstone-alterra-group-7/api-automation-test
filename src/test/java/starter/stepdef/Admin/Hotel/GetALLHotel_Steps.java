package starter.stepdef.Admin.Hotel;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel.GetAllHotel;

public class GetALLHotel_Steps {

    @Steps
    GetAllHotel getAllHotel;

    @Given("I set Hotel API api endpoints")
    public void SetHotelAPIEndpoint() {
        getAllHotel.SetHotelAPIEndpoint();
    }

    @When("I request to endpoint for Get All Hotel")
    public void RequestToEndpointForGetAllHotel() {
        getAllHotel.HotelSendRequestLogin();
    }

    @And("user set GET Hotel valid endpoints")
    public void HotelGetValidEndpoints() {
        getAllHotel.UserSetGetHotelValidEndpoints();
    }

    @And("user send GET Hotel HTTP request with valid endpoint")
    public void UserSendGetHotelHttpEndpoint() {
        getAllHotel.SendHttpRequestHotelGet();
    }


    @Then("I receive valid HTTP Get Hotel response code {int}")
    public void iReceiveValidHTTPGetHotelResponseCode(int arg0) {
        getAllHotel.ReceiveHttpGetHotel200();
    }


    @Given("I set Hotel API invalid endpoints")
    public void SetHotelApiInvalidEndpoints() {
        getAllHotel.SetHotelApiInvalidEndpoints();
    }


    @When("I request to invalid endpoint for Get All Hotel")
    public void RequestToInvalidEndpointForGetAllHotel() {
        getAllHotel.RequstInvalidloginGetAllHotel();
    }

    @And("user set GET Hotel invalid endpoints")
    public void UserSetGetHotelInvalidEndpoints() {
        getAllHotel.setPostInvalidEndpointForGetAllHotel();
    }

    @And("user send GET Hotel HTTP request with invalid endpoint")
    public void UserSendGetHotelHttpRequestWithInvalidEndpoint() {
        getAllHotel.sendPOSTInvalidHTTPRequestForGetAllHotel();
    }


    @Then("I receive invalid HTTP Get Hotel response code {int}")
    public void iReceiveInvalidHTTPGetHotelResponseCode(int arg0) {
        getAllHotel.validateInvalidHTTPResponseCode404ForGetAllHotel();
    }
}
