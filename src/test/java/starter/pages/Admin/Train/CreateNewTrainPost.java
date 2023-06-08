package starter.pages.Admin.Train;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewTrainPost {
    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String endpointCreateTrain = "https://capstone.hanifz.com/api/v1/admin/train";
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
    public String setValidEndpointTrain() {
        return endpointCreateTrain;
    }
    @Step("Enter Request Train Valid Endpoint")
    public void sendRequestCreateTrain() {
    JSONObject train = new JSONObject();
        train.put("code_train", "TRAIN001");
        train.put("name", "Bengawan");

    JSONArray routeArray = new JSONArray();
    JSONObject routeObject = new JSONObject();
        routeObject.put("arrive_time", "00:00");
        routeObject.put("station_id", 1);
        routeArray.put(routeObject);

        train.put("route", routeArray);
        train.put("status", "available");
    JSONArray jsonArray = new JSONArray();
        jsonArray.put(train);

    JSONObject requestBody = new JSONObject();
        requestBody.put("data", jsonArray);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setValidEndpointTrain());
}



    @Step("the system responds with the status code 201 OK")
    public void SuccesCreateTrain() {
        restAssuredThat(response -> response.statusCode(201));
    }

}

