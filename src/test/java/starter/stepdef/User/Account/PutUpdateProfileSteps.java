package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.PutUpdateProfilePage;

public class PutUpdateProfileSteps {
    @Steps
    PutUpdateProfilePage updateProfile;
    @Given("user set endpoint login user")
    public void userSetEndpointLoginUser() { updateProfile.setEndpointLogin();
    }

    @When("user send request to endpoint login user")
    public void userSendRequestToEndpointLoginUser() { updateProfile.sendReqEndpointLogin();
    }

    @When("user set endpoint to update profile")
    public void userSetEndpointToUpdateProfile() { updateProfile.setEndpointUpdateProfile();
    }

    @And("user send request for update profile")
    public void userSendRequestForUpdateProfile() { updateProfile.sendReqForUpdateProfile();
    }

    @Then("user can update profile with status code {int}")
    public void userCanUpdateProfileWithStatusCode(int arg0) { updateProfile.canSeeStatusCode();
    }

    @And("user see valid data with message response")
    public void userSeeValidDataWithMessageResponse() { updateProfile.seeValidDataResponse();
    }
}
