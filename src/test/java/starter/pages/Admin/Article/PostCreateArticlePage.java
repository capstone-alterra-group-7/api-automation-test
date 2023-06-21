package starter.pages.Admin.Article;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateArticlePage {
    protected static String email="admin@gmail.com";
    protected static String password="qweqwe123";
    public String token ="";
    public String loginEndpoint = "https://capstone.hanifz.com/api/v1/login";
    public String setEndpointAuth() {
        return loginEndpoint;
    }

    public void sendReqToEndpointAuth() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    public String article = "https://capstone.hanifz.com/api/v1/admin/article";
    public String setEndpointArticle() {
        return article;
    }

    public void sendReqToEndpointArticle() {
        String description = "artikel aulia";
        String image = "artikel-aulia.png";
        String label = "Aulia Claudia Rahma";
        String title = "artikel aulia";

        String body = "{\n" +
                "    \"description\":" + description + ",\n" +
                "    \"image\":" + image + ",\n" +
                "    \"label\":" + label + ",\n" +
                "    \"title\":" + title + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "Bearer " + token).body(reqBody.toString()).post(setEndpointArticle());
    }

    public void getStatusCodeSuccessCreate() {
        restAssuredThat(response -> response.statusCode(201));
    }

    public void validateDataArticle() {
        Response response = SerenityRest.lastResponse();
        String description = response.getBody().jsonPath().get("description");
        Assert.assertEquals(description, "artikel aulia");
    }

    /* ======================================= TEST NEGATIVE (WITHOUT AUTH) =============================== */
    public String articleEndpoint = "https://capstone.hanifz.com/api/v1/admin/article";
    public String setEndpointNewArticle() {
        return articleEndpoint;
    }
    public void sendReqToNewArticle() {String description = "artikel aulia";
        String image = "artikel-aulia.png";
        String label = "Aulia Claudia Rahma";
        String title = "artikel aulia";

        String body = "{\n" +
                "    \"description\":" + description + ",\n" +
                "    \"image\":" + image + ",\n" +
                "    \"label\":" + label + ",\n" +
                "    \"title\":" + title + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointNewArticle());
    }
    public void userSeeStatusCode() {
        restAssuredThat(response -> response.statusCode(401));
    }

    public void userValidateDataArticle() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Unauthorized");
    }

}
