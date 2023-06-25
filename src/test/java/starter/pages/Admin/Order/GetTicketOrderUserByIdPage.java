package starter.pages.Admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTicketOrderUserByIdPage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetTicketOrderUserByIdPage = "https://api.tripease.my.id/api/v1/admin/order/ticket/detail";
    public String InvalidEndpointGetTicketOrderUserByIdPage = "https://api.tripease.my.id/api/v1/admin/order/ticketxx/detail";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE

    public String setPostValidEndpointForGetTicketOrderUserByIdPageParams(String ticketorderid, String trainid) {
        String endpoint = ValidEndpointGetTicketOrderUserByIdPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (ticketorderid != null) {
            queryParams.append("ticket_order_id=").append(ticketorderid).append("&");
        }
        if (trainid != null) {
            queryParams.append("train_id=").append(trainid).append("&");
        }

        // Hapus karakter '&' terakhir jika ada
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }

        return endpoint + queryParams.toString();
    }
    public String setPostInvalidEndpointForGetTicketOrderUserByIdPageParams(String ticketorderid, String trainid) {
        String endpoint = InvalidEndpointGetTicketOrderUserByIdPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (ticketorderid != null) {
            queryParams.append("ticket_order_id=").append(ticketorderid).append("&");
        }
        if (trainid != null) {
            queryParams.append("train_id=").append(trainid).append("&");
        }
        // Hapus karakter '&' terakhir jika ada
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }

        return endpoint + queryParams.toString();
    }
    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
    @Step("")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("")
    public void sendRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("")
    public String setPostValidEndpointForGetTicketOrderById() {
        String ticketorderid = "1";
        String trainid = "1";

        return setPostValidEndpointForGetTicketOrderUserByIdPageParams(ticketorderid, trainid);
    }
    @Step("")
    public String setPostInvalidEndpointForGetTicketOrderById() {
        String ticketorderid = "1";
        String trainid = "1";

        return setPostInvalidEndpointForGetTicketOrderUserByIdPageParams(ticketorderid, trainid);
    }
    @Step("")
    public void sendGETHTTPRequestForGetTicketOrderById() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetTicketOrderById());

    }
    @Step("")
    public void sendGETInvalidHTTPRequestForGetTicketOrderById() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetTicketOrderById());

    }

    @Step("")
    public void validateHTTPResponseCode200ForGetTicketOrderById() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("")
    public void validateHTTPResponseCode400ForGetTicketOrderById() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("")
    public void validateInvalidHTTPResponseCode404ForGetTicketOrderById() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("")
    public void validateValidDataResponseForGetTicketOrderById() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to get order hotels")));

    }
    @Step("")
    public void validateInvalidDataResponseForGetTicketOrderById() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));

    }
    @Step("")
    public void validateInvalidDataResponse400ForGetTicketOrderById() {
        restAssuredThat(response -> response.body("message", equalTo("Failed to get a ticket order")));

    }

    //=====================================================Invalid Endpoint========================================================

}
