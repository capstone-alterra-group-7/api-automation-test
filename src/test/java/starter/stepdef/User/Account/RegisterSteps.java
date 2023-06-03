package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.RegisterPage;

public class RegisterSteps {
    @Steps
    RegisterPage register;

    @Given("user has endpoint post new user register")
    public void userHasEndpointPostNewUserRegister() {
        register.setEndpointRegister();
    }

    @When("user send request for create new user register")
    public void userSendRequestForCreateNewUserRegister() {
        register.sendReqToEndpointRegister();
    }

    @Then("user get status code {int}")
    public void userGetStatusCode(int arg0) {
        register.validateStatusCode();
    }

    @And("i receive valid data for new account")
    public void iReceiveValidDataForNewAccount() {
        register.validateDataNewAccount();
    }

    @When("user send request with existing email")
    public void userSendRequestWithExistingEmail() { register.sendReqWithExistingEmail();
    }

    @Then("user see status code {int}")
    public void userSeeStatusCode(int arg0) { register.seeErrorCode();
    }

    @And("i receive valid error message")
    public void iReceiveValidErrorMessage() { register.validateMessageError();
    }
}
