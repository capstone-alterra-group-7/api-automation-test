package starter.pages.Admin.TrainCarriage;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetTrainCarriageByIdPage {
    public static String email="admin@gmail.com";
    public static String password="z";
    public static String token ="";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGTC = "https://api.tripease.my.id/api/v1/public/train-carriage/3";
    public String InvalidEndpointGTC = "https://api.tripease.my.id/api/v1/public/train-carriagexx/68";


        @Step("I have endpoint post new login for GTC")
        public String setEndpointLoginGTC() {
            return endpointLogin;
        }

        @Step("I send request to endpoint for GTCe")
        public void sendRequestLoginGTC() {


            String body = "{\n" +
                    "    \"email\":" + email + ",\n" +
                    "    \"password\":" + password + ",\n" +
                    "}";
            JSONObject reqBody = new JSONObject(body);

            SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginGTC());
            token = lastResponse().getBody().jsonPath().get("data.token");
        }
    @Step("user set GET valid endpoints")
    public String setPostValidEndpointForGTC() {
        return ValidEndpointGTC;
    }

    @Step("user send GET HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForGTC() {
            SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGTC());

    }

    @Step("user received valid GET HTTP response code 200")
    public void validateHTTPResponseCode200ForGTC() {
        restAssuredThat(response -> response.statusCode(200));
    }

    //====================================================================INVALID ENDPOINT=========================================
    @Step("I have endpoint post new login for GTC")
    public String setEndpointLoginGTC2() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for GTCe")
    public void sendRequestLoginGTC2() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginGTC());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("user set GET valid endpoints")
    public String setPostInvalidEndpointForGTC() {
        return InvalidEndpointGTC;
    }

    @Step("user send GET HTTP request with valid endpoint")
    public void sendPOSTInvalidEndpointHTTPRequestForGTC() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGTC());

    }

    @Step("user received valid GET HTTP response code 404")
    public void validateHTTPInvalidEndpointResponseCode404ForGTC() {
        restAssuredThat(response -> response.statusCode(404));
    }
//    @Step("I have invalid endpoint post new login for Get All Train Carriage")
//    public String setInvalidEndpointLogin() {
//        return endpointLogin;
//    }
//
//    @Step("I send invalid request to endpoint for Get All Train Carriage")
//    public void sendInvalidRequestLogin() {
//
//
//        String body = "{\n" +
//                "    \"email\":" + email + ",\n" +
//                "    \"password\":" + password + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
//        token = lastResponse().getBody().jsonPath().get("data.token");
//    }
//    @Step("user set invalid GET valid endpoint")
//    public String setPostInvalidEndpointForGetAllTrainCarriage() {
//        return InvalidEndpointGetAllTrainCarriage;
//    }
//
//    @Step("user send invalid GET HTTP request with valid endpoint")
//    public void sendPOSTInvalidHTTPRequestForGetAllTrainCarriage() {
//        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetAllTrainCarriage());
//
//    }
//
//    @Step("user received invalid GET HTTP response code 200")
//    public void validateInvalidHTTPResponseCode404ForGetAllTrainCarriage() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
}
