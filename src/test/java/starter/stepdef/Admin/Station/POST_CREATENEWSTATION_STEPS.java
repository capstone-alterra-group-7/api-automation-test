package starter.stepdef.Admin.Station;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Station.POST_CREATENEWSTATION;

public class POST_CREATENEWSTATION_STEPS {

    @Steps
    POST_CREATENEWSTATION postCreatenewstation;

    @Given("Admin want to set post api endpoints")
    public void AdminWantToSetPostApiEndpoints() {
        postCreatenewstation.SetPostApiEndpoints();
    }


    @When("admin request to endpoint for Create A New Station")
    public void adminRequestToEndpointForCreateANewStation() {
        postCreatenewstation.AdminWantLogin();
    }

    @And("admin set POST valid endpoints")
    public void adminSetPOSTValidEndpoints() {
        postCreatenewstation.setPostValidEndpointPOSTCrateNewStation();
    }

    @And("Admin create a new station")
    public void CreateANewStation () {
        postCreatenewstation.PostCreateANewStation();
    }


    @And("admin send POST HTTP request with valid endpoint")
    public void adminSendPOSTHTTPRequestWithValidEndpoint() {
        postCreatenewstation.PostHttpRequest();
    }

    @Then("admin receive valid POST response code {int}")
    public void adminReceiveValidPOSTResponseCode(int arg0) {
        postCreatenewstation.validateHTTPResponseCode201ForCreateNewStation();
    }
}
