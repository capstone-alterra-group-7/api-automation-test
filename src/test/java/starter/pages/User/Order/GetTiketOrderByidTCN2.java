package starter.pages.userOrder;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTiketOrderByidTCN2 {
    protected static String email="nurset1@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODcxNjc5NjQsInJvbGUiOiJ1c2VyIiwidXNlcklkIjozNn0.ZAIeeAk4ANZH25kKA8h672EQglBwDve93kRvOUpZAB";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }
    @Step("input  request Login Valid Endpoint get tiket order user by id")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("send  request Login Valid Endpoint get tiket order user by id ")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    // TCN2 - INALID TOKEN
    public String gettiketOrderInvalidToken = "https://api.tripease.my.id/api/v1/user/ordr/ticket/detail?ticket_order_id=5&train_id=1";
    public String getEndpointTiketOrderInvalidToken() {
        return gettiketOrderInvalidToken;
    }

    public void getAllTiketOrderInvalidToken() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointTiketOrderInvalidToken());
    }

    public void validateStatusCodeTiketOrderInvalidToken() {
        restAssuredThat(response -> response.statusCode(401));
    }

    public void succesGetTiketOrderInvalidToken() {
        restAssuredThat(response -> response.body("data[4].ticket_order_id", equalTo( null)));
        restAssuredThat(response -> response.body("data[0].train_id", equalTo( null)));
    }
}
