package starter.pages.User.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateOrderHotelPage {
    public static String email = "newuser2@gmail.com";
    public static String password = "newuser2";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointPUOH = "https://api.tripease.my.id/api/v1/user/hotel/order";
    public String InvalidEndpointPUOH = "https://api.tripease.my.id/api/v1/user/hotel/orderXX";

    ////////////////////////////////////////==============PARAMS========================///////////////////////////////
//              YOU CAN SET YOUR OWN PARAMS UNDER HERE
    public String setParamsValidEndpointPUOH(String hotelorderid, String status) {
        String endpoint = ValidEndpointPUOH;
        StringBuilder queryParams = new StringBuilder("?");

        if (hotelorderid != null) {
            queryParams.append("hotel_order_id=").append(hotelorderid).append("&");
        }
        if (status != null) {
            queryParams.append("status=").append(status).append("&");
        }
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }
        return endpoint + queryParams.toString();
    }
    public String setParamsInvalidEndpointPUOH(String hotelorderid, String status) {
        String endpoint = InvalidEndpointPUOH;
        StringBuilder queryParams = new StringBuilder("?");

        if (hotelorderid != null) {
            queryParams.append("page=").append(hotelorderid).append("&");
        }
        if (status != null) {
            queryParams.append("limit=").append(status).append("&");
        }
        if (queryParams.charAt(queryParams.length() - 1) == '&') {
            queryParams.deleteCharAt(queryParams.length() - 1);
        }
        return endpoint + queryParams.toString();
    }
    ////////////////////////////////////////==============PARAMS========================///////////////////////////////

    @Step("")
    public String setEndpointLoginPUOH() {
        return endpointLogin;
    }

    @Step("")
    public void sendRequestLoginPUOH() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginPUOH());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("")
    public String setValidEndpointPUOH() {
        String hotelorderid = "79";
        String status = "paid";

        return setParamsValidEndpointPUOH(hotelorderid, status);
    }

    @Step("")
    public void sendRequestCreatePUOH() {


        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .patch(setValidEndpointPUOH());
    }


    @Step("")
    public void validateResponse201PUOH() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("")
    public void validateValidDataResponseForPUOH() {
        restAssuredThat(response -> response.body("status_code", equalTo(201)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully to update a hotel order")));
    }
    //==============================================================================INVALID ENDPOINT==============================
//    @Step("")
//    public String setInvalidEndpointPUOH() {
//        String hotelorderid = "74";
//        String status = "paid";
//
//        return setParamsInvalidEndpointPUOH(hotelorderid, status);
//    }
//    @Step("")
//    public void sendRequestCreatePUOH2() {
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
//                .post(setEndpointPUOH2());
//    }
//
//
//    @Step("")
//    public void validateResponsePUOH2() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
//
//    @Step("")
//    public void validateResponseForPUOH2() {
//        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
//    }
//
//
//    //==============================================================================INVALID REQUEST==============================
//    @Step("")
//    public String setEndpointPUOH3() {
//        return ValidEndpointPUOH;
//    }
//    @Step("")
//    public void sendRequestCreatePUOH3() {
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
//                .post(setValidEndpointPUOH());
//    }
//
//
//    @Step("")
//    public void validateResponsePUOH3() {
//        restAssuredThat(response -> response.statusCode(400));
//    }
//
//    @Step("")
//    public void validateResponseForPUOH3() {
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
