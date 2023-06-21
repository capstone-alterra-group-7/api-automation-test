package starter.stepdef.User.Notification;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.Notification.NotificationPage;

public class NotificationSteps {
    @Steps
    NotificationPage notification;
    @Given("user has valid endpoint for login")
    public void userHasValidEndpointForLogin() {
        notification.setEndpointLoginUser();
    }

    @When("user send request for for login")
    public void userSendRequestForForLogin() {
        notification.sendReqForLoginUser();
    }

    @And("user set endpoint for get notification")
    public void userSetEndpointForGetNotification() {
        notification.setEndpointForGetNotification();
    }

    @Then("user get notification with status code {int}")
    public void userGetNotificationWithStatusCode(int arg0) {
        notification.validateStatusCode();
    }

    @And("i receive valid data notification with message response")
    public void iReceiveValidDataNotificationWithMessageResponse() {
        notification.validateMessageResponse();
    }

    @And("user send request for get notification")
    public void userSendRequestForGetNotification() {
        notification.sendReqForGetNotification();
    }
}
