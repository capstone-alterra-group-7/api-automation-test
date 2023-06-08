package starter.stepdef.Admin.Train;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Train.getTrainbyID;

public class GetTrainByID {

    @Steps
    getTrainbyID getTrainID;
    @And("input Endpoint Login Valid Endpoint get Train By ID")
    public void enpointLogin() { getTrainID.setEndpointLogin();
    }

    @And("input  Request Login Valid Endpoint get Train By ID")
    public void reqendpointLogin() { getTrainID.sendRequestLogin();
    }

    @When("user on the get Train By ID endpoint")
    public void getTrainIDenpoint() { getTrainID.getEndpointAllTrainbyID();
    }

    @When("user create request with GET method on endpoint get Train By ID")
    public void reqEndpointTrainByID() { getTrainID.getAllTrainDatabyID();
    }

    @Then("get status code 200 OK")
    public void getStatusCode200() { getTrainID.validateStatusCode200();
    }

    @And("get valid data Train By ID")
    public void userGetCredentials() { getTrainID.succesGetAllTrainbyID();
    }



}
