package starter.stepdef.Admin.Dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Dashboard.DashboardPage;

public class DashboardSteps {
    @Steps

    DashboardPage dashboard;
    @Given("user set valid endpoint for login as admin")
    public void userSetValidEndpointForLoginAsAdmin() { dashboard.setLoginAdmin();
    }

    @When("user send request for login admin")
    public void userSendRequestForLoginAdmin() { dashboard.sendReqForLoginAdmin();
    }

    @When("user has endpoint to get dashboard")
    public void userHasEndpointToGetDashboard() { dashboard.setEndpointDashboard();
    }

    @And("user send request to endpoint dashboard")
    public void userSendRequestToEndpointDashboard() { dashboard.sendReqToEndpointDashboard();
    }

    @Then("user get all detail dashboard with status code {int}")
    public void userGetAllDetailDashboardWithStatusCode(int arg0) { dashboard.getDetailDashboardWithStatusCode();
    }

    @And("i validate data dashboard with message response")
    public void iValidateDataDashboardWithMessageResponse() { dashboard.validateDataDashboardWithMessageResponse();
    }

    @When("user has invalid endpoint to get dashboard")
    public void userHasInvalidEndpointToGetDashboard() { dashboard.setInvalidEndpoint();
    }

    @And("user send request to invalid endpoint dashboard")
    public void userSendRequestToInvalidEndpointDashboard() { dashboard.sendReqToInvalidEndpointDashboard();
    }

    @Then("user get cannot detail dashboard with status code {int}")
    public void userGetCannotDetailDashboardWithStatusCode(int arg0) { dashboard.validateResponseCode();
    }

    @And("i validate error with message response")
    public void iValidateErrorWithMessageResponse() { dashboard.validateErrorResponse();
    }

    @Given("user has valid endpoint to get dashboard")
    public void userHasValidEndpointToGetDashboard() { dashboard.setEndpointforDashboard();
    }

    @When("user send request to valid endpoint dashboard")
    public void userSendRequestToValidEndpointDashboard() { dashboard.sendReqToEndpointDas();
    }

    @Then("user validate response with status code {int}")
    public void userValidateResponseWithStatusCode(int arg0) { dashboard.validateStatusCode401();
    }

    @And("user validate error with message response")
    public void userValidateErrorWithMessageResponse() { dashboard.validateErrorResponseUnauth();
    }
}
