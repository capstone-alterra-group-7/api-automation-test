package starter.pages.Admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetHotelOrderUserByIdPage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointGetHotelOrderUserByIdPage = "https://api.tripease.my.id/api/v1/admin/order/hotel";
    public String InvalidEndpointGetHotelOrderUserByIdPage = "https://api.tripease.my.id/api/v1/admin/order/hotels";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE

    public String setPostValidEndpointForGetHotelOrderUserByIdPageParams(String hotelorderid) {
        String endpoint = ValidEndpointGetHotelOrderUserByIdPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (hotelorderid != null) {
            queryParams.append("hotel_order_id=").append(hotelorderid).append("&");
        }

        // Hapus karakter '&' terakhir jika ada
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }

        return endpoint + queryParams.toString();
    }
    public String setPostInvalidEndpointForGetHotelOrderUserByIdPageParams(String hotelorderid) {
        String endpoint = InvalidEndpointGetHotelOrderUserByIdPage;
        StringBuilder queryParams = new StringBuilder("?");

        if (hotelorderid != null) {
            queryParams.append("hotel_order_id=").append(hotelorderid).append("&");
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
    public String setPostValidEndpointForGetHotelOrderById() {
        String hotelorderid = "6";

        return setPostValidEndpointForGetHotelOrderUserByIdPageParams(hotelorderid);
    }
    @Step("")
    public String setPostInvalidEndpointForGetHotelOrderById() {
        String hotelorderid = "6";

        return setPostInvalidEndpointForGetHotelOrderUserByIdPageParams(hotelorderid);
    }
    @Step("")
    public void sendGETHTTPRequestForGetHotelOrderById() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForGetHotelOrderById());

    }
    @Step("")
    public void sendGETInvalidHTTPRequestForGetHotelOrderById() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetHotelOrderById());

    }

    @Step("")
    public void validateHTTPResponseCode200ForGetHotelOrderById() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("")
    public void validateHTTPResponseCode400ForGetHotelOrderById() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("")
    public void validateInvalidHTTPResponseCode404ForGetHotelOrderById() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("")
    public void validateValidDataResponseForGetHotelOrderById() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to get order hotels")));

    }
    @Step("")
    public void validateInvalidDataResponseForGetHotelOrderById() {
        restAssuredThat(response -> response.body("message", equalTo("Failed to get a hotel order")));
        restAssuredThat(response -> response.body("errors", equalTo("record not found")));

    }
    @Step("")
    public void validateInvalidDataResponse404ForGetHotelOrderById() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));

    }

    //=====================================================Invalid Endpoint========================================================

}
