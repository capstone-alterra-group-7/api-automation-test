package starter.pages.Admin.TrainCarriage;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;


import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllTrainCarriagePage {
    public static String email="admin@gmail.com";
    public static String password="z";
    public static String token ="";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetAllTrainCarriage = "https://api.tripease.my.id/api/v1/public/train-carriage";
    public String InvalidEndpointGetAllTrainCarriage = "https://api.tripease.my.id/api/v1/public/train-carriagexx";


        @Step("I have endpoint post new login for Get All Train Carriage")
        public String setEndpointLogin() {
            return endpointLogin;
        }

        @Step("I send request to endpoint for Get All Train Carriage")
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
    public String setPostValidEndpointForGetAllTrainCarriage() {
        return ValidEndpointGetAllTrainCarriage;
    }

    @Step("user send GET HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForGetAllTrainCarriage() {
            SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetAllTrainCarriage());

    }

    @Step("user received valid GET HTTP response code 200")
    public void validateHTTPResponseCode200ForGetAllTrainCarriage() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I have invalid endpoint post new login for Get All Train Carriage")
    public String setInvalidEndpointLogin() {
        return endpointLogin;
    }

    @Step("I send invalid request to endpoint for Get All Train Carriage")
    public void sendInvalidRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("user set invalid GET valid endpoint")
    public String setPostInvalidEndpointForGetAllTrainCarriage() {
        return InvalidEndpointGetAllTrainCarriage;
    }

    @Step("user send invalid GET HTTP request with valid endpoint")
    public void sendPOSTInvalidHTTPRequestForGetAllTrainCarriage() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetAllTrainCarriage());

    }

    @Step("user received invalid GET HTTP response code 200")
    public void validateInvalidHTTPResponseCode404ForGetAllTrainCarriage() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
