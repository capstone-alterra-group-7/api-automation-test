package starter.pages.Admin.Station;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteStation {

    public static String email="admin@gmail.com";
    public static String password="qweqwe123";
    public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU4OTU4MDIsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.Szwc-UNcdx2_JgAnSBUD9dTqmXDuAd2eEXaq7IK1rFs";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";


    public String ValidEndpointDeleteStation = "https://capstone.hanifz.com/api/v1/admin/station/13";


    @Step("Admin want to set delete api endpoints")
    public String AdminEndpointLogin() {
        return endpointLogin ;
    }

    @Step("admin request to endpoint for delete Station")
    public void AdminRequestDeleteHTTPRequest() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(AdminEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }


    @Step("Admin delete station")
    public String AdminDeleteStation() {
        return ValidEndpointDeleteStation;
    }

    @Step("admin set delete valid endpoints")
    public void DeleteValidEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").delete(AdminDeleteStation());

    }


    @Step("admin receive valid delete response code 200")
    public void validateHTTPResponseCode200ForDeleteStation() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("data", equalTo(null)));
    }






}






