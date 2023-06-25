package starter.pages.Admin.TrainCarriage;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateTrainCarriagePage {
    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public static String token = "";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    public String ValidEndpointUTC = "https://api.tripease.my.id/api/v1/admin/train-carriage/3";
    public String InvalidEndpointUTC = "https://api.tripease.my.id/api/v1/admin/train-carriagexx/3";


    @Step("Enter Endpoint Login Valid Endpoint UTC")
    public String setEndpointLoginUTC() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint UTC")
    public void sendRequestLoginUTC() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginUTC());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint UTC Valid Endpoint")
    public String setValidEndpointUTC() {
        return ValidEndpointUTC;
    }

    @Step("Enter Request UTC Valid Endpoint")
    public void sendRequestUTC() {
        String body = "{\n" +
                "    \"class\":" + "Ekonomi" + ",\n" +
                "    \"name\":" + "Gerbong 1" + ",\n" +
                "    \"price\":" + 50000 + ",\n" +
                "    \"train_id\":" + 3 +
                "}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(reqBody.toString())
                .put(setValidEndpointUTC());
    }

    @Step("Receive 200 UTC response Valid Endpoint")
    public void validateResponse200UTC() {
        restAssuredThat(response -> response.statusCode(200));
    }


    //==============================================================================INVALID ENDPOINT==============================
    @Step("Enter Endpoint Login Valid Endpoint UTC2")
    public String setEndpointLoginUTC2() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint UTC2")
    public void sendRequestLoginUTC2() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginUTC());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint UTC Invalid Endpoint")
    public String setInvalidEndpointUTC() {
        return InvalidEndpointUTC;
    }

    @Step("Enter Request UTC Invalid Endpoint")
    public void sendInvalidEndpointRequestUTC() {
        String body = "{\n" +
                "    \"class\":" + "Ekonomi" + ",\n" +
                "    \"name\":" + "Gerbong 1" + ",\n" +
                "    \"price\":" + 50000 + ",\n" +
                "    \"train_id\":" + 68 +
                "}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(reqBody.toString())
                .put(setInvalidEndpointUTC());
    }

    @Step("Receive 200 UTC response Invalid Endpoint")
    public void validateResponse404UTC() {
        restAssuredThat(response -> response.statusCode(404));
    }


//=================================================INVALID REQUEST======================================================

    @Step("Enter Endpoint Login Valid Endpoint UTC3")
    public String setEndpointLoginUTC3() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint UTC3")
    public void sendRequestLoginUTC3() {


        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginUTC());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    @Step("Enter Endpoint UTC Valid Endpoint for invalid request")
    public String setInvalidRequestValidEndpointUTC() {
        return ValidEndpointUTC;
    }

    @Step("Enter Request UTC Valid Endpoint for invalid request")
    public void sendInvalidRequestUTC() {
        String body = "{\n" +
                "    \"class\":" + "Ekonomi" + ",\n" +
                "    \"name\":" + "Gerbong 1" + ",\n" +
                "    \"price\":" + 50000 + ",\n" +
                "    \"train_id\":" + 1001 +
                "}";

        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(reqBody.toString())
                .put(setValidEndpointUTC());
    }

    @Step("Receive 400 UTC response Valid Endpoint for invalid request")
    public void validateResponse400UTC() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
//    @Step("Enter Endpoint Login Valid Endpoint TC2")
//    public String setEndpointLogin2() {
//        return endpointLogin;
//    }
//
//    @Step("Enter Request Login Valid Endpoint TC2")
//    public void sendRequestLogin2() {
//        String body = "{\n" +
//                "    \"email\":" + email + ",\n" +
//                "    \"password\":" + password + ",\n" +
//                "}";
//        JSONObject reqBody = new JSONObject(body);
//
//        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLogin());
//        token = lastResponse().getBody().jsonPath().get("data.token");
//    }
//    @Step("Enter Endpoint TC Invalid Endpoint")
//    public String setInvalidEndpointTC() {
//        return InvalidEndpointTC;
//    }
//
//    @Step("Enter Request TC Invalid Endpoint")
//    public void sendInvalidEndpointRequestCreateTC() {
//        JSONObject trainCarriage = new JSONObject();
//        trainCarriage.put("class", "Ekonomi");
//        trainCarriage.put("name", "Gerbong 1");
//        trainCarriage.put("price", 50000);
//        trainCarriage.put("train_id", 60);
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
//                .post(setInvalidEndpointTC());
//    }
//    @Step("Receive 404 response Invalid Endpoint")
//    public void validateInvalidEndpointResponse404TC() {
//        restAssuredThat(response -> response.statusCode(404));
//    }
//
//
//    //==============================================================================INVALID REQUEST==============================
//    @Step("Enter Endpoint Login Valid Endpoint TC3")
//    public String setEndpointLogin3() {
//        return endpointLogin;
//    }
//
//    @Step("Enter Request Login Valid Endpoint TC3")
//    public void sendRequestLogin3() {
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
//
//    @Step("Enter Endpoint TC Valid Endpoint for invalid request")
//    public String setValidEndpointInvalidReqTC() {
//        return ValidEndpointTC;
//    }
//
//    @Step("Enter Request TC Valid Endpoint for invalid request")
//    public void sendRequestCreateInvalidReqTC() {
//        JSONObject trainCarriage = new JSONObject();
//        trainCarriage.put("class", "Ekonomi");
//        trainCarriage.put("name", "Gerbong 1");
//        trainCarriage.put("price", 50000);
//        trainCarriage.put("train_id", 10001);
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
//                .post(setValidEndpointTC());
//    }
//
//    @Step("Receive 400 response Invalid Endpoint for invalid request")
//    public void validateResponse400TC() {
//        restAssuredThat(response -> response.statusCode(400));
//    }
//}
































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
