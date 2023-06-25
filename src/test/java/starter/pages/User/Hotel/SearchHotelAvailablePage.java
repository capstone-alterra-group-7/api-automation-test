package starter.pages.User.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchHotelAvailablePage {
    public static String email = "newuser2@gmail.com";
    public static String password = "newuser2";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointSHA = "https://api.tripease.my.id/api/v1/user/hotel/search";
    public String InvalidEndpointSHA = "https://api.tripease.my.id/api/v1/user/hotel/searchXX";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE
    public String setParamsValidEndpointSHA(String page, String limit, String minimumprice, String maximumprice, String ratingclass, String address, String name, String sortbyprice) {
        String endpoint = ValidEndpointSHA;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (limit != null) {
            queryParams.append("minimum_price=").append(minimumprice).append("&");
        }
        if (limit != null) {
            queryParams.append("maximum_price=").append(maximumprice).append("&");
        }
        if (limit != null) {
            queryParams.append("rating_class=").append(ratingclass).append("&");
        }
        if (limit != null) {
            queryParams.append("address=").append(address).append("&");
        }
        if (limit != null) {
            queryParams.append("name=").append(name).append("&");
        }
        if (limit != null) {
            queryParams.append("sort_by_price=").append(sortbyprice).append("&");
        }
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }
        return endpoint + queryParams.toString();
    }
    public String setParamsInvalidEndpointSHA(String page, String limit, String minimumprice, String maximumprice, String ratingclass, String address, String name, String sortbyprice) {
        String endpoint = InvalidEndpointSHA;
        StringBuilder queryParams = new StringBuilder("?");

        if (page != null) {
            queryParams.append("page=").append(page).append("&");
        }
        if (limit != null) {
            queryParams.append("limit=").append(limit).append("&");
        }
        if (limit != null) {
            queryParams.append("minimum_price=").append(minimumprice).append("&");
        }
        if (limit != null) {
            queryParams.append("maximum_price=").append(maximumprice).append("&");
        }
        if (limit != null) {
            queryParams.append("rating_class=").append(ratingclass).append("&");
        }
        if (limit != null) {
            queryParams.append("address=").append(address).append("&");
        }
        if (limit != null) {
            queryParams.append("name=").append(name).append("&");
        }
        if (limit != null) {
            queryParams.append("sort_by_price=").append(sortbyprice).append("&");
        }
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }
        return endpoint + queryParams.toString();
    }
    ////////////////////////////////////////==============PARAMS========================///////////////////////////////

    @Step("")
    public String setEndpointLoginSHA() {
        return endpointLogin;
    }

    @Step("")
    public void sendRequestLoginSHA() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginSHA());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("")
    public String setValidEndpointSHA() {
        String page = "";
        String limit = "";
        String minimumprice = "";
        String maximumprice = "";
        String ratingclass = "";
        String address = "";
        String name = "";
        String sortbyprice = "";

        return setParamsValidEndpointSHA(page, limit, minimumprice, maximumprice, ratingclass, address, name, sortbyprice);
    }

    @Step("")
    public void sendRequestCreateSHA() {


        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .get(setValidEndpointSHA());
    }


    @Step("")
    public void validateResponse201SHA() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("")
    public void validateValidDataResponseForSHA() {
        restAssuredThat(response -> response.body("status_code", equalTo(200)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully get all hotels")));
    }
    //==============================================================================INVALID ENDPOINT==============================
//    @Step("")
//    public String setInvalidEndpointSHA() {
//        String hotelorderid = "74";
//        String status = "paid";
//
//        return setParamsInvalidEndpointSHA(hotelorderid, status);
//    }
//    @Step("")
//    public void sendRequestCreateSHA2() {
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("date_end", "2023-05-02");
//        requestBody.put("date_start", "2023-05-01");
//        requestBody.put("email_order", "me@hanifz.com");
//        requestBody.put("hotel_room_id", 1);
//        requestBody.put("name_order", "Mochammad Hanif");
//        requestBody.put("payment_id", 1);
//        requestBody.put("phone_number_order", "085115151515");
//        requestBody.put("quantity_adult", 1);
//        requestBody.put("quantity_infant", 0);
//        requestBody.put("special_request", "Tambah 1 Bed");
//
//        JSONObject travelerDetail = new JSONObject();
//        travelerDetail.put("full_name", "Mochammad Hanif");
//        travelerDetail.put("id_card_number", "1902389012801211");
//        travelerDetail.put("title", "Saudara");
//
//        requestBody.put("traveler_detail", new JSONObject[]{travelerDetail});
//
//        String body = requestBody.toString();
//
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + token)
//                .contentType("application/json")
//                .body(body)
//                .post(setEndpointSHA2());
//    }
//
//
//    @Step("")
//    public void validateResponseSHA2() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
//
//    @Step("")
//    public void validateResponseForSHA2() {
//        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
//    }
//
//
//    //==============================================================================INVALID REQUEST==============================
//    @Step("")
//    public String setEndpointSHA3() {
//        return ValidEndpointSHA;
//    }
//    @Step("")
//    public void sendRequestCreateSHA3() {
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("date_end", "2023-05-02");
//        requestBody.put("date_start", "2023-05-01");
//        requestBody.put("email_order", "me@hanifz.com");
//        requestBody.put("hotel_room_id", -99);
//        requestBody.put("name_order", "Mochammad Hanif");
//        requestBody.put("payment_id", 1);
//        requestBody.put("phone_number_order", "085115151515");
//        requestBody.put("quantity_adult", 1);
//        requestBody.put("quantity_infant", 0);
//        requestBody.put("special_request", "Tambah 1 Bed");
//
//        JSONObject travelerDetail = new JSONObject();
//        travelerDetail.put("full_name", "Mochammad Hanif");
//        travelerDetail.put("id_card_number", "1902389012801211");
//        travelerDetail.put("title", "Saudara");
//
//        requestBody.put("traveler_detail", new JSONObject[]{travelerDetail});
//
//        String body = requestBody.toString();
//
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + token)
//                .contentType("application/json")
//                .body(body)
//                .post(setValidEndpointSHA());
//    }
//
//
//    @Step("")
//    public void validateResponseSHA3() {
//        restAssuredThat(response -> response.statusCode(400));
//    }
//
//    @Step("")
//    public void validateResponseForSHA3() {
//        restAssuredThat(response -> response.body("status_code", equalTo(400)));
//        restAssuredThat(response -> response.body("message", equalTo("Failed to created a hotel order")));
//        restAssuredThat(response -> response.body("errors", equalTo("Failed to create hotel order")));
//    }


}
































//    @Step("I have invalid endpoint post new login for create a new Train Carriage2")
//    public String setInvalidEndpointLogin() {
//        return endpointLogin;
//    }
//
//    @Step("I send valid request to endpoint for create a new Train Carriage2")
//    public void sendInvalidRequestLogin() {
//
//
//        String body = "{\n" +
//                "    \"email\":" + email + ",\n" +
//                "    \"password\":" + password + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
//        token = lastResponse().getBody().jsonPath().get("data.token");
//    }
//    @Step("user set POST invalid endpoint for create a new Train Carriage")
//    public String setPostInvalidEndpointForGetAllTrainCarriage() {
//        return InvalidEndpointTC;
//    }
//
//    @Step("user send valid POST HTTP request for create a new Train Carriage with invalid endpoint")
//    public void sendPOSTInvalidHTTPRequestForGetAllTrainCarriage() {
//        JSONObject trainCarriage = new JSONObject();
//        trainCarriage.put("class", "Ekonomi");
//        trainCarriage.put("name", "Gerbong 1");
//        trainCarriage.put("price", 50000);
//        trainCarriage.put("train_id", 68);
//
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(trainCarriage);
//
//        String body = jsonArray.toString();
//
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + token)
//                .contentType("application/json")
//                .body(body)
//                .post(setPostValidEndpointForGetAllTrainCarriage());
//    }
//
//    @Step("user received invalid POST HTTP for create a new Train Carriage response code 404")
//    public void validateInvalidHTTPResponseCode404ForGetAllTrainCarriage() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
//    //==============================================================================INVALID REQ==============================
//    @Step("I have invalid endpoint post new login for create a new Train Carriage1")
//    public String setInvalidEndpointLoginReq() {
//        return endpointLogin;
//    }
//
//    @Step("I send invalid request to endpoint for create a new Train Carriage1")
//    public void sendInvalidRequestLoginReq() {
//
//
//        String body = "{\n" +
//                "    \"email\":" + email + ",\n" +
//                "    \"password\":" + password + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
//        token = lastResponse().getBody().jsonPath().get("data.token");
//    }
//    @Step("user set GET invalid endpoint for create a new Train Carriage1")
//    public String setPostInvalidEndpointForGetAllTrainCarriageReq() {
//        return ValidEndpointTC;
//    }
//
//    @Step("user send invalid GET HTTP request for create a new Train Carriage with valid endpoint1")
//    public void sendPOSTInvalidHTTPRequestForGetAllTrainCarriageReq() {
//        JSONObject trainCarriage = new JSONObject();
//        trainCarriage.put("class", "Ekonomi");
//        trainCarriage.put("name", "Gerbong 1");
//        trainCarriage.put("price", 50000);
//        trainCarriage.put("train_id", 61);
//
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(trainCarriage);
//
//        String body = jsonArray.toString();
//
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + token)
//                .contentType("application/json")
//                .body(body)
//                .post(setPostValidEndpointForGetAllTrainCarriage());
//
//    }
//
//    @Step("user received invalid Req GET HTTP for create a new Train Carriage response code 400")
//    public void validateInvalidHTTPResponseCode404ForGetAllTrainCarriageReq() {
//        restAssuredThat(response -> response.statusCode(400));
//    }
//}
