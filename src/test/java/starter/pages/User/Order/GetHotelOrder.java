package starter.pages.User.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetHotelOrder {
    protected static String email="nurset1@gmail.com";
    protected static String password="qweqwe123";
    public String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODY4MjQyMzEsInJvbGUiOiJ1c2VyIiwidXNlcklkIjoxMX0.TMKFlt5wIKzely4BPjQSvJM7G77vB8FYG6I7zumDjgs";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }
    @Step("Enter Endpoint Login Valid Endpoint delete train")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint delete train")
    public void sendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String getHotelOrder = "https://api.tripease.my.id/api/v1/user/order/hotel";
    public String getEndpointHotelOrder() {
        return getHotelOrder;
    }


    public void getAllHotelOrderData() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointHotelOrder());
    }

    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void succesGetHotelOrder() {
        restAssuredThat(response -> response.body("data[5].hotel_order_id", equalTo( 6)));
    }

}

