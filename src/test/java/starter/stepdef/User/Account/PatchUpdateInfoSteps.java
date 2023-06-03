package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.PatchUpdateInfoPage;

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

    @Given("user set endpoint login")
    public void userSetEndpointLogin() { updateInfo.setEndpointForLogin();
    }

    @When("user send request to endpoint login for get token")
    public void userSendRequestToEndpointLoginForGetToken() { updateInfo.sendReqForGetToken();
    }

    @When("user has valid endpoint for update information")
    public void userHasValidEndpointForUpdateInformation() { updateInfo.setEndpointForUpdate();
    }

    @And("user send request to endpoint update information")
    public void userSendRequestToEndpointUpdateInformation() { updateInfo.sendReqForUpdate();
    }

    @Then("user can see status code {int}")
    public void userCanSeeStatusCode(int arg0) { updateInfo.userSeeStatusCode();
    }

    @And("i can see validate data with message response")
    public void iCanSeeValidateDataWithMessageResponse() { updateInfo.userSeeMessageResponse();
    }

}
