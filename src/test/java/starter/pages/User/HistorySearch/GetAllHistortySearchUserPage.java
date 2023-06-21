package starter.pages.User.HistorySearch;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllHistortySearchUserPage {
    public static String email = "newuser2@gmail.com";
    public static String password = "newuser2";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetAllHistorySearch = "https://api.tripease.my.id/api/v1/user/history-search";
    public String InvalidEndpointGetAllHistorySearch = "https://api.tripease.my.id/api/v1/user/history-searchxx";


    @Step("I have endpoint post new login for get all history search")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for get all history search")
    public void sendRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("user set GET valid endpoint for get all history search")
    public String setPostValidEndpointForGetAllHistorySearch() {
        return ValidEndpointGetAllHistorySearch;
    }

    @Step("user send GET HTTP request with valid endpoint for get all history search")
    public void sendPOSTHTTPRequestForGetAllHistorySearch() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetAllHistorySearch());

    }

    @Step("user received valid GET HTTP response code 200 for get all history search")
    public void validateHTTPResponseCode200ForGetAllHistorySearch() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive valid data response for get all history search")
    public void validateValidDataResponseForGetAllHistorySearch() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully get all history search")));

    }

    //=====================================================Invalid Endpoint========================================================
    @Step("I have endpoint post new login for get all history search2")
    public String setInvalidEndpointLogin() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for get all history search2")
    public void sendInvalidRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("user set GET invalid endpoint for get all history search")
    public String setPostInvalidEndpointForGetAllHistorySearch() {
        return InvalidEndpointGetAllHistorySearch;
    }

    @Step("user send GET HTTP request with valid endpoint for invalid get all history search")
    public void sendPOSTInvalidHTTPRequestForGetAllHistorySearch() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetAllHistorySearch());

    }

    @Step("ser received valid GET HTTP response code 404 for invalid get all history search")
    public void validateInvalidHTTPResponseCode404ForGetAllHistorySearch() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("user receive valid data response for invalid get all history search")
    public void validateValidDataResponseForInvalidGetAllHistorySearch() {

        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
    }
}
