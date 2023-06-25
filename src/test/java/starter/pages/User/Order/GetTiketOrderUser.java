package starter.pages.User.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTiketOrderUser {
    protected static String email="nurset1@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODY4NDYwMzIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjoxMX0.u6Bezai3RfFOYqxRyIzGpk4iDGFKL-bpLjpHMdO9KAE";
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

    public String gettiketOrder = "https://api.tripease.my.id/api/v1/user/order/ticket";
    public String getEndpointTiketOrder() {
        return gettiketOrder;
    }

    public void getAllTiketOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointTiketOrder());
    }

    public void validateStatusCodeTiketOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void succesGetTiketOrder() {
        restAssuredThat(response -> response.body("data[3].ticket_order_id", equalTo( null)));
    }
}
