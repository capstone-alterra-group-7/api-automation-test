package starter.pages.Admin.Station;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class Station {

    public static String email="admin@gmail.com";
    public static String password="z";
    public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU3MTcxMDAsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.IYXuZlINqoLodHZM5kAiPu_CPKLD0jg-0_LcP0nCW7c";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String ValidEndpointGetAllStation = "https://capstone.hanifz.com/api/v1/public/train?page=1&limit=2";


    @Step("I set GET api endpoints")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("I request to endpoint for Get All Train")
    public void sendRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("user set GET valid endpoints")
    public String setPostValidEndpointForGetAllStation() {
        return ValidEndpointGetAllStation;
    }

    @Step("user send GET HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForGetAllStation() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetAllStation());

    }

    @Step("user received valid GET HTTP response code 200")
    public void validateHTTPResponseCode200ForGetAllStation() {
        restAssuredThat(response -> response.statusCode(200));
    }



}
