package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.GetCredentialPage;

public class GetCredentialsSteps {

    @Steps
    GetCredentialPage getCredential;
    @Given("user has valid endpoint auth login")
    public void userHasValidEndpointAuthLogin() { getCredential.setEndpointAuthLogin();

    }

    @When("user send request for get token from auth")
    public void userSendRequestForGetTokenFromAuth() { getCredential.sendReqToEndpointAuthLogin();
    }

    @When("user has endpoint to get credentials")
    public void userHasEndpointToGetCredentials() { getCredential.getEndpointGetCredential();
    }

    @And("user get credentials")
    public void userGetCredentials() { getCredential.getCredentials();
    }

    @Then("user get credentials with status code {int}")
    public void userGetCredentialsWithStatusCode(int arg0) { getCredential.validateStatusCode();
    }

    @And("i receive valid data message response")
    public void iReceiveValidDataMessageResponse() { getCredential.validateMessageResponse();
    }
}
