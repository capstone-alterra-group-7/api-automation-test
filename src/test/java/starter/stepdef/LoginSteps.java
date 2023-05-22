package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;

public class LoginSteps {

    @Steps
    LoginPage login;
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
}
