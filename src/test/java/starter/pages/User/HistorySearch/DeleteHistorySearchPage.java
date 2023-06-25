package starter.pages.User.HistorySearch;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteHistorySearchPage {
    public static String email = "newuser2@gmail.com";
    public static String password = "newuser2";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointDHS = "https://api.tripease.my.id/api/v1/user/history-search/15";
    public String InvalidEndpointDHS = "https://api.tripease.my.id/api/v1/user/history-searchxx/8";
    public String InvalidRequestEndpointDHS = "https://api.tripease.my.id/api/v1/user/history-search/101";

    @Step("I have endpoint post new login for DHS")
    public String setEndpointLoginDHS() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for DHS")
    public void sendRequestLoginDHS() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDHS());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("user set DELETE valid endpoint for DHS")
    public String setDeleteValidEndpointForDHS() {
        return ValidEndpointDHS;
    }

    @Step("user send DELETE HTTP request with valid endpoint for DHS")
    public void sendPOSTHTTPRequestForDHS() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForDHS());

    }

    @Step("user received valid DELETE HTTP response code 200 for DHS")
    public void validateHTTPResponseCode200ForDHS() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user received data response for DHS")
    public void validateDataResponseForDHS() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully delete history")));
        restAssuredThat(response -> response.body("data", equalTo(null)));
    }

    //====================================================================INVALID ENDPOINT=========================================

    @Step("I have endpoint post new login for DHS2")
    public String setEndpointLoginDHS2() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for DHS2")
    public void sendRequestLoginDHS2() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDHS());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("user set DELETE invalid endpoint for DHS")
    public String setDeleteInvalidEndpointForDHS() {
        return InvalidEndpointDHS;
    }

    @Step("user send DELETE HTTP request with invalid endpoint for DHS")
    public void sendPOSTInvalidEndpointHTTPRequestForDHS() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteInvalidEndpointForDHS());

    }

    @Step("user received invalid endpoint DELETE HTTP response code 404 for DHS")
    public void validateInvalidEndpointHTTPResponseCode404ForDHS() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("user received data response for invalid endpoint DHS")
    public void validateDataResponseForInvalidEndpointDHS() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));

    }
    //===========================================================Invalid ID=============================================

    @Step("I have endpoint post new login for DHS3")
    public String setEndpointLoginDHS3() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for DHS3")
    public void sendRequestLoginDHS3() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginDHS());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("user set DELETE valid endpoint for invalid id DHS")
    public String setDeleteValidEndpointForInvalidRequestDHS() {
        return InvalidRequestEndpointDHS;
    }

    @Step("user send DELETE HTTP request with valid endpoint for invalid id DHS")
    public void sendPOSTValidEndpointHTTPRequestForInvalidRequestDTC() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForInvalidRequestDHS());

    }

    @Step("user received valid endpoint DELETE HTTP response code 400 for invalid id DHS")
    public void validateInvalidEndpointHTTPResponseCode400ForInvalidReqDHS() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user received data response for invalid id DHS")
    public void validateDataResponseForInvalidRequestDHS() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully delete history")));
        restAssuredThat(response -> response.body("data", equalTo(null)));


    }
}
