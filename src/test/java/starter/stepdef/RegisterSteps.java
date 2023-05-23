import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.RegisterPage;

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
}
