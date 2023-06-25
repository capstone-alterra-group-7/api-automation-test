package starter.stepdef.Admin.Train;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Train.delTrain;


public class DeleteSteps {

    @Steps
    delTrain deleteTrain;

    @Given("Enter Endpoint Login Valid Endpoint delTrain")
    public void enterEndpointLoginValidEndpointTrain() {
        deleteTrain.setEndpointLogin();
    }

    @When("Enter Request Login Valid Endpoint delTrain")
    public void enterRequestLoginValidEndpointTrain() {
       deleteTrain.sendRequestLogin();
    }

    @When("user on the delete train endpoint with id 16")
    public void userOnTheDeleteTrainEndpointWithId() {
        deleteTrain.setValidEndpointDelTrain();
    }

    @When("user create request with DEL method on endpoint")
    public void userCreateRequestWithDELMethodOnEndpoint() {
        deleteTrain.sendDelTrain();
    }

    @Then("get status code 200")
    public void getStatusCode() {
        deleteTrain.SuccesDelTrain();
    }

    @Then("get valid data")
    public void ReceiveValidData() {
        deleteTrain.iReceivedValidData();
    }
}
