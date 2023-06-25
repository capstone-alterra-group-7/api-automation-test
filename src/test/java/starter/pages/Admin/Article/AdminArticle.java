package starter.pages.Admin.Article;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AdminArticle {

    public static String email="admin@gmail.com";
    public static String password="qweqwe123";

    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODYxMDAxMDUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.AfZIn0ws-oU0Z4qC_TqL0lM8V4pgX1bW39e56KtcxRc";

    public String endpointLogin = "https://capstone.hanifz.com/api/v1/login";

    public String EndpointPostArticle = "https://capstone.hanifz.com/api/v1/admin/article";


    @Step("Admin set put api article endpoints")
    public String PutApiArticle() {
        return endpointLogin;
    }

    @Step("admin request to endpoint for Update Article")
    public void RequestLoginforUpdateArticle() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(reqBody.toString())
                .post(PutApiArticle());
        token = lastResponse().getBody().jsonPath().get("data.token");


    }

    @Step("Admin update Article")
    public void adminUpdateArticle() {

        JSONObject Article = new JSONObject();
        Article.put("description", "jpg");
        Article.put("image", "jpg");
        Article.put("label", "jpg");
        Article.put("title", "jpg");

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").header("Content-Type", "application/json").body(Article.toString()).when().put(EndpointPostArticle);
    }


    @Step("admin set put valid endpoints article")
    public String setPostUpdateArticle () {
        return EndpointPostArticle;
    }


    @Step("admin send put HTTP request with valid endpoint article")
    public void PostCreateArticle () {
        SerenityRest.given().header("Authorization", "Bearer " + token).put(setPostUpdateArticle());
    }

    @Step("admin receive valid put response code 201")
    public void validateHTTPResponseCode200ForPostArticle () {
        restAssuredThat(response -> response.statusCode(201));
    }


}
