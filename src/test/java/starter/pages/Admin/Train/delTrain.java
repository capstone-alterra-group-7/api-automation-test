package starter.pages.Admin.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class delTrain {
    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU4OTQyMDUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.l9rkBtoVX-HDWbdWO0Jygof9saO5ok-gOIqlwC5Lf9I";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";

    @Step("Enter Endpoint Login Valid Endpoint delete train")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint delete train")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String endpointDelTrain = "https://capstone.hanifz.com/api/v1/admin/train/77";
    @Step("Enter Endpoint delelete train  Valid Endpoint")
    public String setValidEndpointDelTrain() {
        return endpointDelTrain;
    }


    @Step("I send delete a category HTTP request")
    public void sendDelTrain() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .delete(setValidEndpointDelTrain());
    }

    @Step("I received valid HTTP response code 200 for delete a category")
    public void SuccesDelTrain() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received valid data for delete a category")
    public void iReceivedValidData() {
        restAssuredThat(response -> response.body("data", equalTo(null)));
    }
}


