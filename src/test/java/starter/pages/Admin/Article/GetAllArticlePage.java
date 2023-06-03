package starter.pages.Admin.Article;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllArticlePage {
    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="";

    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";
    public String setEndpointForLoginAdmin() {
        return endpointLogin;
    }

    public void sendReqToEndpointLoginAdmin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointForLoginAdmin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String endpointArticles = "https://capstone.hanifz.com/api/v1/public/article";
    public String setEndpointForGetAllArticles() {
        return endpointArticles;
    }

    public void sendReqToEndpointArticles() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointForGetAllArticles());
    }

    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateData() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully get all article");
    }

    /* ============================================= TEST CASE NEGATIVE (INVALID ENDPOINT) ============================== */

    public String invalidEndpointArticles = "https://capstone.hanifz.com/api/v1/public/articles";
    public String setInvalidEndpointArticles() {
        return invalidEndpointArticles;
    }

    public void sendReqToInvEndpointArticles() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setInvalidEndpointArticles());
    }

    public void seeErrorCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void seeResponseError() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Not Found");
    }
}
