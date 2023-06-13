package starter.pages.Admin.Dashboard;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DashboardPage {

    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="";

    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String setLoginAdmin() {
        return endpointLogin;
    }

    public void sendReqForLoginAdmin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setLoginAdmin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String endpointDashboard = "https://capstone.hanifz.com/api/v1/admin/dashboard";
    public String setEndpointDashboard() {
        return endpointDashboard;
    }

    public void sendReqToEndpointDashboard() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointDashboard());
    }

    public void getDetailDashboardWithStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateDataDashboardWithMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully get all dashboards");
    }

    // ==================================================== TEST CASE NEGATIF / INVALID ENDPOINT ===================================================================
    public String invalidEndpointDashboard = "https://capstone.hanifz.com/api/v1/admin/dashboardS";
    public String setInvalidEndpoint() { return invalidEndpointDashboard;
    }

    public void sendReqToInvalidEndpointDashboard() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setInvalidEndpoint());
    }

    public void validateResponseCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void validateErrorResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Not Found");
}

    // ==================================================== TEST CASE NEGATIF / VALID ENDPOINT WITHOUT AUTH ===================================================================
    public String setEndpointforDashboard() { return endpointDashboard;
    }


    public void sendReqToEndpointDas() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointforDashboard());
    }

    public void validateStatusCode401() {
        restAssuredThat(response -> response.statusCode(401));
    }

    public void validateErrorResponseUnauth() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Unauthorized");
    }
}
