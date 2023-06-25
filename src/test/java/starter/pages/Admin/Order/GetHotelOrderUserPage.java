package starter.pages.Admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetHotelOrderUserPage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetHotelOrderUserPage = "https://api.tripease.my.id/api/v1/admin/order/hotel";
    public String InvalidEndpointGetHotelOrderUserPage = "https://api.tripease.my.id/api/v1/admin/order/hotelxx";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE

    public String setPostValidEndpointForGetHotelOrderUserPageParams(String page, String limit, String ratingClass, String search, String dateStart, String dateEnd, String orderBy, String status) {
        String endpoint = ValidEndpointGetHotelOrderUserPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (ratingClass != null) {
            queryParams.append("rating_class=").append(ratingClass).append("&");
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
        if (status != null) {
            queryParams.append("status=").append(status).append("&");
        }

        // Hapus karakter '&' terakhir jika ada
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }

        return endpoint + queryParams.toString();
    }
    public String setPostInvalidEndpointForGetHotelOrderUserPageParams(String page, String limit, String ratingClass, String search, String dateStart, String dateEnd, String orderBy, String status) {
        String endpoint = InvalidEndpointGetHotelOrderUserPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (ratingClass != null) {
            queryParams.append("rating_class=").append(ratingClass).append("&");
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
        if (status != null) {
            queryParams.append("status=").append(status).append("&");
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
    public String setPostValidEndpointForGetHotelOrder() {
        String page = "";
        String limit = "";
        String ratingClass = "";
        String search = "";
        String dateStart = "";
        String dateEnd = "";
        String orderBy = "";
        String status = "";

        return setPostValidEndpointForGetHotelOrderUserPageParams(page, limit, ratingClass, search, dateStart, dateEnd, orderBy, status);
    }
    @Step("")
    public String setPostInvalidEndpointForGetHotelOrder() {
        String page = "";
        String limit = "";
        String ratingClass = "";
        String search = "";
        String dateStart = "";
        String dateEnd = "";
        String orderBy = "";
        String status = "";

        return setPostInvalidEndpointForGetHotelOrderUserPageParams(page, limit, ratingClass, search, dateStart, dateEnd, orderBy, status);
    }
    @Step("")
    public void sendPOSTHTTPRequestForGetHotelOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetHotelOrder());

    }
    @Step("")
    public void sendPOSTInvalidHTTPRequestForGetHotelOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetHotelOrder());

    }

    @Step("")
    public void validateHTTPResponseCode200ForGetHotelOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("")
    public void validateHTTPResponseCode400ForGetHotelOrder() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("")
    public void validateInvalidHTTPResponseCode404ForGetHotelOrder() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("")
    public void validateValidDataResponseForGetHotelOrder() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to get order hotels")));

    }
    @Step("")
    public void validateInvalidDataResponseForGetHotelOrder() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));

    }

    //=====================================================Invalid Endpoint========================================================

}
