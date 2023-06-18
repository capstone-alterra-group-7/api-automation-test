package starter.pages.User.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTiketOrderById {
    protected static String email="nurset1@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODcxNjQ4MTksInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.OG1tG6S76208xpywmFAANFZ7r5HH9E60rUs9N2crhgU";
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

    public String gettiketOrder = "https://api.tripease.my.id/api/v1/user/order/ticket/detail?ticket_order_id=4&train_id=1";
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
        restAssuredThat(response -> response.body("data[0].train_id", equalTo( null)));
    }

    // TCN1 - ID TIDAK ADA
    public String gettiketOrderIDInvalid = "https://api.tripease.my.id/api/v1/user/ordr/ticket/detail?ticket_order_id=5&train_id=1";
    public String getEndpointTiketOrderIDInvalid() {
        return gettiketOrderIDInvalid;
    }

    public void getAllTiketOrderIDInvalid() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointTiketOrderIDInvalid());
    }

    public void validateStatusCodeTiketOrderIDInvalid() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void succesGetTiketOrderIDInvalid() {
        restAssuredThat(response -> response.body("data[4].ticket_order_id", equalTo( null)));
        restAssuredThat(response -> response.body("data[0].train_id", equalTo( null)));
    }

}
