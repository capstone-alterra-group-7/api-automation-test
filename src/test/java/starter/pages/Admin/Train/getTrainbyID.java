package starter.pages.Admin.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class getTrainbyID {
    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU5Nzc0ODQsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.xQJzn27ccfq270fRUla-kaPoflzZjHk8EuYBfYX3YcQ";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }
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

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String getAllTrainValid = "https://capstone.hanifz.com/api/v1/public/train/1";
    public String getEndpointAllTrainbyID() {
        return getAllTrainValid;
    }


    public void getAllTrainDatabyID() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointAllTrainbyID());
    }

    public void validateStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void succesGetAllTrainbyID() {
        restAssuredThat(response -> response.body("data[1].train_id", equalTo(null)));
    }
}
