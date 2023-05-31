package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PatchUpdateInfoPage;

public class PatchUpdateInfoSteps {
    @Steps
    PatchUpdateInfoPage updateInfo;

    @Given("user has endpoint login")
    public void userHasEndpointLogin() { updateInfo.setEndpointLogin();
    }

    @When("user send request for get token")
    public void userSendRequestForGetToken() { updateInfo.SendReqToEndpointLogin();
    }
    @When("user has endpoint to update information")
    public void userHasEndpointToUpdateInformation() { updateInfo.setEndpointToUpdatInfo();
    }

    @And("user patch update information")
    public void userPatchUpdateInformation() { updateInfo.sendRequestToUpdateInfo();
    }

    @Then("user can update information with status code {int}")
    public void userCanUpdateInformationWithStatusCode(int arg0) { updateInfo.validateStatusCodeUpdate();
    }

    @And("i can validate data with message response")
    public void iCanValidateDataWithMessageResponse() { updateInfo.validateResponseMessageUpdate();
    }

}
