package starter.stepdef.Admin.Train;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Train.PutTrain;

public class updateTrain {

    @Steps
    PutTrain updateTrain;
    @Given("user on Endpoint Login Valid Endpoint Train")
    public void userOnEndpointLoginValidEndpointTrain() {
        updateTrain.setEndpointLogin();
    }

    @When("user Request Login Valid Endpoint Train")
    public void userRequestLoginValidEndpointTrain() {
        updateTrain.sendRequestLogin();
    }

    @When("user on the update train endpoint")
    public void userOnTheUpdateTrainEndpoint() {
        updateTrain.setValidEndpointPutTrain();
    }

    @When("user update request with PUT method on endpoint")
    public void userUpdateRequestWithPUTMethodOnEndpoint() {
        updateTrain.sendRequestPutTrain();
    }

    @When("user send update request with PUT method on endpoint")
    public void sendUpdateRequestWithPUTMethodOnEndpoint() {
        updateTrain.PutRequest();
    }

    @Then("system responds with the status code {int}")
    public void systemRespondsWithTheStatusCode(int arg0) {
        updateTrain.SuccesPutTrain();
    }
}
