package starter.pages.Admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTicketOrderUserPage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetTicketOrderUserPage = "https://api.tripease.my.id/api/v1/admin/order/ticket";
    public String InvalidEndpointGetTicketOrderUserPage = "https://api.tripease.my.id/api/v1/admin/order/ticketxx";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE

    public String setPostValidEndpointForGetTicketOrderUserPageParams(String page, String limit, String search, String dateStart, String dateEnd, String orderBy, String filter) {
        String endpoint = ValidEndpointGetTicketOrderUserPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (search != null) {
            queryParams.append("search=").append(search).append("&");
        }
        if (dateStart != null) {
            queryParams.append("date_start=").append(dateStart).append("&");
        }
        if (dateEnd != null) {
            queryParams.append("date_end=").append(dateEnd).append("&");
        }
        if (orderBy != null) {
            queryParams.append("order_by=").append(orderBy).append("&");
        }
        if (filter != null) {
            queryParams.append("filter=").append(filter).append("&");
        }

        // Hapus karakter '&' terakhir jika ada
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }

        return endpoint + queryParams.toString();
    }
    public String setPostInvalidEndpointForGetTicketOrderUserPageParams(String page, String limit, String search, String dateStart, String dateEnd, String orderBy, String filter) {
        String endpoint = InvalidEndpointGetTicketOrderUserPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (search != null) {
            queryParams.append("search=").append(search).append("&");
        }
        if (dateStart != null) {
            queryParams.append("date_start=").append(dateStart).append("&");
        }
        if (dateEnd != null) {
            queryParams.append("date_end=").append(dateEnd).append("&");
        }
        if (orderBy != null) {
            queryParams.append("order_by=").append(orderBy).append("&");
        }
        if (filter != null) {
            queryParams.append("filter=").append(filter).append("&");
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
    public String setPostValidEndpointForGetTicketOrder() {
        String page = "";
        String limit = "";
        String search = "";
        String dateStart = "";
        String dateEnd = "";
        String orderBy = "";
        String filter = "";

        return setPostValidEndpointForGetTicketOrderUserPageParams(page, limit, search, dateStart, dateEnd, orderBy, filter);
    }
    @Step("")
    public String setPostInvalidEndpointForGetTicketOrder() {
        String page = "";
        String limit = "";
        String search = "";
        String dateStart = "";
        String dateEnd = "";
        String orderBy = "";
        String filter = "";

        return setPostInvalidEndpointForGetTicketOrderUserPageParams(page, limit, search, dateStart, dateEnd, orderBy, filter);
    }
    @Step("")
    public void sendPOSTHTTPRequestForGetTicketOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetTicketOrder());

    }
    @Step("")
    public void sendPOSTInvalidHTTPRequestForGetTicketOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetTicketOrder());

    }

    @Step("")
    public void validateHTTPResponseCode200ForGetTicketOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("")
    public void validateHTTPResponseCode400ForGetTicketOrder() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("")
    public void validateInvalidHTTPResponseCode404ForGetTicketOrder() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("")
    public void validateValidDataResponseForGetTicketOrder() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to get order tickets")));

    }
    @Step("")
    public void validateInvalidDataResponseForGetTicketOrder() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));

    }

    //=====================================================Invalid Endpoint========================================================

}
