package starter.stepdef.Admin.Train;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Train.CreateNewTrainPost;


public class CreateNewTrain {

    @Steps
    CreateNewTrainPost createnewTrain;

    @Given("Enter Endpoint Login Valid Endpoint Train")
    public void endpointLoginCreateTrain(){
        createnewTrain.setEndpointLogin();
    }

    @When("Enter Request Login Valid Endpoint Train")
    public void reqLoginCreateTC(){
        createnewTrain.sendRequestLogin();
    }
    @When("user on the create new train endpoint")
    public void setValidEndpointCreatetrain() {
        createnewTrain.setValidEndpointTrain();
    }

    @When("user create request with POST method on endpoint")
    public void createReq() {
        createnewTrain.sendRequestCreateTrain();
    }
    @Then("the system responds with the status code 201 OK")
    public void theSystemRespondsWithTheStatusCodeOK() {
        createnewTrain.SuccesCreateTrain();
    }
}
