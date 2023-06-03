package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.PutUpdatePasswordPage;

public class PutUpdatePasswordSteps {
    @Steps
    PutUpdatePasswordPage UpdatePassword;
    @Given("user has endpoint login user")
    public void userHasEndpointLoginUser() { UpdatePassword.setEndpointLoginUser();
    }

    @When("user send request to endpoint login user for get token")
    public void userSendRequestToEndpointLoginUserForGetToken() { UpdatePassword.sendReqToEndpointLoginuser();
    }

    @When("user set endpoint to update password")
    public void userSetEndpointToUpdatePassword() { UpdatePassword.setEndpointForUpdatePassword();
    }

    @And("user send request for update password")
    public void userSendRequestForUpdatePassword() { UpdatePassword.sendEndpointForUpdatePassword();
    }

    @Then("user can update password with status code {int}")
    public void userCanUpdatePasswordWithStatusCode(int arg0) { UpdatePassword.seeStatusCodeForUpdatePassword();
    }

    @And("user can validate data with message response")
    public void userCanValidateDataWithMessageResponse() { UpdatePassword.validateMessageForUpdatePassword();
    }
}
