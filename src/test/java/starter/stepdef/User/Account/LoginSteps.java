package starter.stepdef.User.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Account.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage login;

    @Steps
    LoginPage invalidEndpointLogin;

    @Steps
    LoginPage invalidRequestLogin;

    @Given("user has endpoint post new user login")
    public void userHasEndpointPostNewUserLogin() {
        login.setEndpointLogin();
    }

    @When("user send request for create new user login")
    public void userSendRequestForCreateNewUserLogin() {
        login.sendRequestLogin();
    }

    @Then("login user get status code {int}")
    public void loginUserGetStatusCode(int arg0) {
        login.validateResponseCodeLogin();
    }

    @And("I receive valid data for new login")
    public void iReceiveValidDataForNewLogin() {
        login.validateDataLogin();
    }

    @Given("user has invalid endpoint post new user login")
    public void userHasInvalidEndpointPostNewUserLogin() { invalidEndpointLogin.setInvalidEndpointLogin();
    }

    @When("user send request to invalid endpoint for create new user login")
    public void userSendRequestToInvalidEndpointForCreateNewUserLogin() { invalidEndpointLogin.sendRequestToInvalidEndpoint();
    }

    @Then("user get error status code {int}")
    public void userGetErrorStatusCode(int arg0) { invalidEndpointLogin.validateErrorStatus();
    }

    @Given("user has valid endpoint post new user login")
    public void userHasValidEndpointPostNewUserLogin() { invalidRequestLogin.setValidEndpoint();
    }

    @When("user send invalid request to for create new user login")
    public void userSendInvalidRequestToForCreateNewUserLogin() { invalidRequestLogin.sendInvalidRequest();
    }

    @Then("user see error status code {int}")
    public void userSeeErrorStatusCode(int arg0) { invalidRequestLogin.validateErrorCode();
    }

    @And("I receive valid response message")
    public void iReceiveValidResponseMessage() { invalidRequestLogin.validateResponseMessage();
    }
}
