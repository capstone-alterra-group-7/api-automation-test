package starter.pages.userOrder;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTiketOrderUserTCN2 {
    protected static String email="nurset1@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODcxNjc5NjQsInJvbGUiOiJ1c2VyIiwidXNlcklkIjozNn0.ZAIeeAk4ANZH25kKA8h672EQglBwDve93kRvOUpZAB";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }
    @Step("input  request Login Valid Endpoint get tiket order user")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("send  request Login Valid Endpoint get tiket order user ")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String gettiketOrderIntoken = "https://api.tripease.my.id/api/v1/user/order/ticket";
    public String getEndpointTiketOrderIntoken() {
        return gettiketOrderIntoken;
    }

    public void getAllTiketOrderIntoken() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointTiketOrderIntoken());
    }

    public void validateStatusCodeTiketOrderIntoken() {
        restAssuredThat(response -> response.statusCode(401));
    }

    public void succesGetTiketOrderIntoken() {
        restAssuredThat(response -> response.body("data[3].ticket_order_id", equalTo( null)));
    }
}
