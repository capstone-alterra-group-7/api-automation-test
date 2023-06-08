package starter.stepdef.Admin.Train;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Train.GetAllTrain;


public class getAlltrain {

    @Steps
    GetAllTrain getAll;

    @Given("input Endpoint Login Valid Endpoint get all Train")
    public void loginValidEndpointGetAllTrain() {
        getAll.setEndpointLogin();
    }

    @When("input  Request Login Valid Endpoint get all Train")
    public void sendrewvalidLoginTrain() {
        getAll.sendRequestLogin();
    }

    @When("user on the get all train endpoint")
    public void validEndpointAllTrainTrain() {
        getAll.getEndpointAllTrain();
    }

    @When("user create request with GET method on endpoint")
    public void enterValidEndpointAllTrain() {
        getAll.getAllTrainData();
    }

    @Then("get status code {int} ok")
    public void getStatuscode200Ok(int arg0) {
        getAll.validateStatusCode();
    }

    @And("get valid data train")
    public void succesgetDataAllTrain() {
        getAll.succesGetAllTrain();
    }

}
