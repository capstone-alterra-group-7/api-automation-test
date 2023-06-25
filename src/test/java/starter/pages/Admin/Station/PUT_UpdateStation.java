package starter.pages.Admin.Station;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PUT_UpdateStation {

    public static String email="admin@gmail.com";
    public static String password="qweqwe123";
    public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODU3MTcxMDAsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.IYXuZlINqoLodHZM5kAiPu_CPKLD0jg-0_LcP0nCW7c";
    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";

    public String ValidEndpointPut = "https://capstone.hanifz.com/api/v1/admin/station/1";


    @Step("Admin want to set put api endpoints")
    public String SetPutApi() {
        return endpointLogin;
    }

    @Step("admin request to endpoint for Update Station")
    public void AdminRequestLogin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetPutApi());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }


    @Step("Admin update station")
    public void PutUpdateStation () {

        JSONObject data = new JSONObject();
        data.put(" initial", "PSE");
        data.put("name", "Pasar Senen");
        data.put("origin", "Jakarta");

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").header("Content-Type", "application/json").body(data.toString()).when().put(ValidEndpointPut);


    }

    @Step("admin set put valid endpoints")
    public String setPostValidEndpointPutUpdateStation () {

      return ValidEndpointPut ;
    }


   @Step("admin send put HTTP request with valid endpoint")
    public void PutRequest() {
       SerenityRest.given().header("Authorization", "Bearer " + token).put(setPostValidEndpointPutUpdateStation());
   }

   @Step("admin receive valid put response code 200")
   public void validateHTTPResponseCode200ForUpdateStation () {
       restAssuredThat(response -> response.statusCode(200));
   }


}










