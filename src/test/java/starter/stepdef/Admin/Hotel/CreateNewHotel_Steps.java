package starter.stepdef.Admin.Hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Hotel.CreateNewHotel_Post;

public class CreateNewHotel_Steps {


    @Steps
    CreateNewHotel_Post createNewHotelPost;

    @Given("Enter Endpoint Login Valid Endpoint New Hotel")
    public void EnterEndpointLoginValidEndpointNewHotel() {
        createNewHotelPost.SetPostApiNewHotel();
    }

    @When("Enter Request Login Valid Endpoint New Hotel")
    public void EnterRequestLoginValidEndpointNewHotel() {
        createNewHotelPost.RequestCreateNewHotel();
    }

    @And("Enter Endpoint New Hotel Valid Endpoint")
    public void EnterEndpointNewHotelValidEndpoint() {
        createNewHotelPost.setPostValidEndpointPOSTCrateNewHotel();
    }


    @And("Enter Request New Hotel Valid Endpoint")
    public void EnterRequestNewHotelValidEndpoint () {
        createNewHotelPost.PostNewHotelEndpoints();
    }


    @Then("Receive Valid Http Create New Hotel response code {int}")
    public void receiveValidHttpCreateNewHotelResponseCode(int arg0) {
        createNewHotelPost.SuccessCreateNewHotel();
    }
}
