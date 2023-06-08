package starter.pages.Admin.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PutTrain {

        public static String email="admin@gmail.com";
        public static String password="qweqwe123";
        public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU4OTQyMDUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.l9rkBtoVX-HDWbdWO0Jygof9saO5ok-gOIqlwC5Lf9I";
        public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";

        public String ValidEndpointPutTrain = "https://capstone.hanifz.com/api/v1/admin/train/2";

    @Step("user on Endpoint Login Valid Endpoint Train")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("user Request Login Valid Endpoint Train")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint TC Valid Endpoint")
    public String setValidEndpointPutTrain() {
        return ValidEndpointPutTrain;
    }

        @Step("Enter Request Train Valid Endpoint")
        public void sendRequestPutTrain() {
            JSONObject data = new JSONObject();
            data.put("code_train", "TRAIN001");
            data.put("name", "Bengawan");
            data.put("arrive_time", "00:00");
            data.put("station_id", "1");
            data.put("status", "available");

            SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").header("Content-Type", "application/json").body(data.toString()).when().put(ValidEndpointPutTrain);
        }

        @Step("admin send put HTTP request with valid endpoint")
        public void PutRequest() {
            SerenityRest.given().header("Authorization", "Bearer " + token).put(setValidEndpointPutTrain());
        }

        @Step("the system responds with the status code 200 ")
        public void SuccesPutTrain() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
