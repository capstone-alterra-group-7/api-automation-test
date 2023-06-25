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

    /* ============================================= TEST CASE POSITIVE (GET ARTICLE BY ID) ============================== */

    public String articleByID = "https://capstone.hanifz.com/api/v1/public/article";
    public String setEndpointArticleByID() {
        return articleByID + "/1";
    }

    public void sendReqToEndpointArticleByID() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointArticleByID());
    }

    public void validateStatusCodeArticleByID() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateDataWithMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully to get article by id");
    }

    /* ============================================= TEST CASE NEGATIVE (GET ARTICLE WITH INVALID ID) ============================== */
    public String articleInvalidID = "https://capstone.hanifz.com/api/v1/public/article";
    public String setEndpointArticleInvalidID() {
        return articleInvalidID + "/999";
    }

    public void sendReqToEndpointArticleWithInvalidID() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointArticleInvalidID());
    }

    public void seeStatusCode() {
        restAssuredThat(response -> response.statusCode(400));
    }

    public void validateErrorResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        String errors = response.getBody().jsonPath().get("errors");
        Assert.assertEquals(message, "Failed to get article by id");
        Assert.assertEquals(errors, "record not found");
    }

    /* ============================================= TEST CASE NEGATIVE (GET ARTICLE WITH INVALID ENDPOINT) ============================== */
    public String articleInvalidEndpointID = "https://capstone.hanifz.com/api/v1/public/articles";
    public String setInvalidEndpointByID() {
        return articleInvalidEndpointID + "/999";
    }
    public void sendReqToInvEndpointByID() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setInvalidEndpointByID());
    }

    public void statusCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void seeErrorResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Not Found");
    }
}
