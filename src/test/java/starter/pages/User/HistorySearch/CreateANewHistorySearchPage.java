package starter.pages.User.HistorySearch;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateANewHistorySearchPage {
    public static String email = "newuser2@gmail.com";
    public static String password = "newuser2";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointCHS = "https://api.tripease.my.id/api/v1/user/history-search";
    public String InvalidEndpointCHS = "https://api.tripease.my.id/api/v1/user/history-searchxx";


    @Step("Enter Endpoint Login Valid Endpoint CHS")
    public String setEndpointLoginCHS() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint CHS")
    public void sendRequestLoginCHS() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginCHS());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint CHS Valid Endpoint")
    public String setValidEndpointCHS() {
        return ValidEndpointCHS;
    }

    @Step("Enter Request CHS Valid Endpoint")
    public void sendRequestCreateCHS() {
        JSONObject historySearch = new JSONObject();
        historySearch.put("name", "newuser1");


        String body = historySearch.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setValidEndpointCHS());
    }


    @Step("Receive 201 response CHS Valid Endpoint")
    public void validateResponse201CHS() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("Receive Data response CHS Valid Endpoint")
    public void validateValidDataResponseForCHS() {
        restAssuredThat(response -> response.body("status_code", equalTo(201)));
        restAssuredThat(response -> response.body("message", equalTo("Successfully create history")));
    }
    //==============================================================================INVALID ENDPOINT==============================


    @Step("Enter Endpoint Login Valid Endpoint CHS2")
    public String setEndpointLoginCHS2() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint CHS2")
    public void sendRequestLoginCHS2() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginCHS2());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("Enter Endpoint CHS Invalid Endpoint")
    public String setInvalidEndpointCHS() {
        return InvalidEndpointCHS;
    }

    @Step("Enter Request CHS Invalid Endpoint")
    public void sendInvalidEndpointRequestCreateCHS() {
        JSONObject historySearch = new JSONObject();
        historySearch.put("name", "newuser1");


        String body = historySearch.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setInvalidEndpointCHS());
    }
    @Step("Receive 404 response CHS Invalid Endpoint")
    public void validateInvalidEndpointResponse404CHS() {
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("Receive Data response CHS Valid Endpoint")
    public void validateInvalidDataResponseForCHS() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
    }

    //==============================================================================INVALID REQUEST==============================
    @Step("Enter Endpoint Login Valid Endpoint CHS3")
    public String setEndpointLoginCHS3() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint CHS3")
    public void sendRequestLoginCHS3() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginCHS3());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint CHS Invalid Request")
    public String setValidEndpointInvalidReqCHS() {
        return ValidEndpointCHS;
    }

    @Step("Enter Request CHS Invalid Request")
    public void sendRequestCreateInvalidReqCHS() {
        JSONObject historySearch = new JSONObject();
        historySearch.put("name", 991);


        String body = historySearch.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setValidEndpointCHS());
    }

    @Step("Receive 400 response CHS Invalid Request")
    public void validateResponse400CHS() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("Receive Data response CHS Invalid Request")
    public void validateInvalidDataResponseInvalidReqForCHS() {
        restAssuredThat(response -> response.body("status_code", equalTo(400)));
        restAssuredThat(response -> response.body("message", equalTo("Failed to create history search data")));
    }
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
