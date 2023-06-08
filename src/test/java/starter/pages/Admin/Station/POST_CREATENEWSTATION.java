package starter.pages.Admin.Station;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;



import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class POST_CREATENEWSTATION {

    public static String email="admin@gmail.com";
    public static String password="z";
    public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU3MTcxMDAsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.IYXuZlINqoLodHZM5kAiPu_CPKLD0jg-0_LcP0nCW7c";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";

    public String ValidEndpointPost = "https://capstone.hanifz.com/api/v1/admin/station";



    @Step("Admin want to set post api endpoints")
    public String SetPostApiEndpoints() {
        return endpointLogin ;
    }

    @Step("admin request to endpoint for Create A New Station")
    public void AdminWantLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetPostApiEndpoints());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }


    @Step("admin set POST valid endpoints")
    public String setPostValidEndpointPOSTCrateNewStation () {
        return ValidEndpointPost;

    }

    @Step("Admin create a new station")
    public void PostCreateANewStation () {

        JSONObject data = new JSONObject();
        data.put(" initial", "Sby-Pasar Turi");
        data.put("name", "Surabaya-gubeng");
        data.put("origin", "Surabaya");

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").header("Content-Type", "application/json").body(data.toString()).when().post(ValidEndpointPost);

    }



    @Step("admin send POST HTTP request with valid endpoint")
    public void PostHttpRequest() {
        SerenityRest.given().header("Authorization", "Bearer " + token).post(setPostValidEndpointPOSTCrateNewStation());
    }

    @Step("admin receive valid POST response code 201")
    public void validateHTTPResponseCode201ForCreateNewStation () {
        restAssuredThat(response -> response.statusCode(201));
    }


    }