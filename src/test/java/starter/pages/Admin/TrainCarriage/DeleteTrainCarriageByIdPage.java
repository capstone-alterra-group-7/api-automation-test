package starter.pages.Admin.TrainCarriage;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteTrainCarriageByIdPage {
    public static String email="admin@gmail.com";
    public static String password="z";
    public static String token ="";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointDTC = "https://api.tripease.my.id/api/v1/admin/train-carriage/8";
    public String InvalidEndpointDTC = "https://api.tripease.my.id/api/v1/admin/train-carriagexx/8";
    public String InvalidRequestEndpointGTC = "https://api.tripease.my.id/api/v1/admin/train-carriagexx/101";

        @Step("I have endpoint post new login for GTC")
        public String setEndpointLoginDTC() {
            return endpointLogin;
        }

        @Step("I send request to endpoint for GTC")
        public void sendRequestLoginDTC() {


            String body = "{\n" +
                    "    \"email\":" + email + ",\n" +
                    "    \"password\":" + password + ",\n" +
                    "}";
            JSONObject reqBody = new JSONObject(body);

            SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDTC());
            token = lastResponse().getBody().jsonPath().get("data.token");
        }
    @Step("user set DELETE valid endpoints")
    public String setDeleteValidEndpointForDTC() {
        return ValidEndpointDTC;
    }

    @Step("user send DELETE HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForDTC() {
            SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForDTC());

    }

    @Step("user received valid DELETE HTTP response code 200")
    public void validateHTTPResponseCode200ForDTC() {
        restAssuredThat(response -> response.statusCode(200));
    }

    //====================================================================INVALID ENDPOINT=========================================

    @Step("I have endpoint post new login for GTC2")
    public String setEndpointLoginDTC2() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for GTC2")
    public void sendRequestLoginDTC2() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDTC());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("user set DELETE invalid endpoint")
    public String setDeleteInvalidEndpointForDTC() {
        return InvalidEndpointDTC;
    }

    @Step("user send DELETE HTTP request with invalid endpoint")
    public void sendPOSTInvalidEndpointHTTPRequestForDTC() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteInvalidEndpointForDTC());

    }

    @Step("user received valid GET HTTP response code 404")
    public void validateInvalidEndpointHTTPResponseCode404ForDTC() {
        restAssuredThat(response -> response.statusCode(404));
    }

//    @Step("I have endpoint post new login for GTC")
//    public String setEndpointLoginDTC2() {
//        return endpointLogin;
//    }
//
//    @Step("I send request to endpoint for GTCe")
//    public void sendRequestLoginDTC2() {
//
//
//        String body = "{\n" +
//                "    \"email\":" + email + ",\n" +
//                "    \"password\":" + password + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDTC());
//        token = lastResponse().getBody().jsonPath().get("data.token");
//    }
//    @Step("user set GET valid endpoints")
//    public String setPostInvalidEndpointForDTC() {
//        return InvalidEndpointDTC;
//    }
//
//    @Step("user send GET HTTP request with valid endpoint")
//    public void sendPOSTInvalidEndpointHTTPRequestForDTC() {
//        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForDTC());
//
//    }
//
//    @Step("user received valid GET HTTP response code 404")
//    public void validateHTTPInvalidEndpointResponseCode404ForDTC() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
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
