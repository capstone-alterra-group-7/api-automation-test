package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.PutUpdatePhotoProfilePage;

public class PutUpdatePhotoProfileSteps {
    @Steps
    PutUpdatePhotoProfilePage updatePhotoProfile;
    @When("user set endpoint to update photo profile")
    public void userSetEndpointToUpdatePhotoProfile() { updatePhotoProfile.setEndpointPhotoProfile();
    }

    @And("user send request for update photo profile")
    public void userSendRequestForUpdatePhotoProfile() { updatePhotoProfile.uploadPhotoProfile();
    }

    @Then("user can update photo profile with status code {int}")
    public void userCanUpdatePhotoProfileWithStatusCode(int arg0) { updatePhotoProfile.validateResponseWithStatusCode();
    }

    @And("user see valid data photo profile with message response")
    public void userSeeValidDataPhotoProfileWithMessageResponse() { updatePhotoProfile.validateWithMessageResponse();
    }

    @Given("user set endpoint login user for update photo")
    public void userSetEndpointLoginUserForUpdatePhoto() { updatePhotoProfile.setEndpointLoginUserr();
    }

    @When("user send request to endpoint login user for update photo")
    public void userSendRequestToEndpointLoginUserForUpdatePhoto() { updatePhotoProfile.sendReqForLoginUserr();
    }
}
