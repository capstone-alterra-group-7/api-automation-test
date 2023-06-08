package starter.pages.traincarriage;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.json.JSONArray;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateANewTrainCarriagePage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String ValidEndpointTC = "https://capstone.hanifz.com/api/v1/admin/train-carriage";
    public String InvalidEndpointTC = "https://capstone.hanifz.com/api/v1/admin/train-carriagexx";


    @Step("Enter Endpoint Login Valid Endpoint TC")
    public String setEndpointLogin() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint TC")
    public void sendRequestLogin() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint TC Valid Endpoint")
    public String setValidEndpointTC() {
        return ValidEndpointTC;
    }

    @Step("Enter Request TC Valid Endpoint")
    public void sendRequestCreateTC() {
        JSONObject trainCarriage = new JSONObject();
        trainCarriage.put("class", "Ekonomi");
        trainCarriage.put("name", "Gerbong 1");
        trainCarriage.put("price", 50000);
        trainCarriage.put("train_id", 3);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(trainCarriage);

        String body = jsonArray.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setValidEndpointTC());
    }

    @Step("Receive 201 response Valid Endpoint")
    public void validateResponse201TC() {
        restAssuredThat(response -> response.statusCode(201));
    }

    //==============================================================================INVALID ENDPOINT==============================


    @Step("Enter Endpoint Login Valid Endpoint TC2")
    public String setEndpointLogin2() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint TC2")
    public void sendRequestLogin2() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    @Step("Enter Endpoint TC Invalid Endpoint")
    public String setInvalidEndpointTC() {
        return InvalidEndpointTC;
    }

    @Step("Enter Request TC Invalid Endpoint")
    public void sendInvalidEndpointRequestCreateTC() {
        JSONObject trainCarriage = new JSONObject();
        trainCarriage.put("class", "Ekonomi");
        trainCarriage.put("name", "Gerbong 1");
        trainCarriage.put("price", 50000);
        trainCarriage.put("train_id", 3);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(trainCarriage);

        String body = jsonArray.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setInvalidEndpointTC());
    }
    @Step("Receive 404 response Invalid Endpoint")
    public void validateInvalidEndpointResponse404TC() {
        restAssuredThat(response -> response.statusCode(404));
    }


    //==============================================================================INVALID REQUEST==============================
    @Step("Enter Endpoint Login Valid Endpoint TC3")
    public String setEndpointLogin3() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint TC3")
    public void sendRequestLogin3() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint TC Valid Endpoint for invalid request")
    public String setValidEndpointInvalidReqTC() {
        return ValidEndpointTC;
    }

    @Step("Enter Request TC Valid Endpoint for invalid request")
    public void sendRequestCreateInvalidReqTC() {
        JSONObject trainCarriage = new JSONObject();
        trainCarriage.put("class", "Ekonomi");
        trainCarriage.put("name", "Gerbong 1");
        trainCarriage.put("price", 50000);
        trainCarriage.put("train_id", 10001);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(trainCarriage);

        String body = jsonArray.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .post(setValidEndpointTC());
    }

    @Step("Receive 400 response Invalid Endpoint for invalid request")
    public void validateResponse400TC() {
        restAssuredThat(response -> response.statusCode(400));
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
