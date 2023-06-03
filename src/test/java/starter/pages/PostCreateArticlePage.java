package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateArticlePage {
    public String endpointArticle = "https://capstone.hanifz.com/api/v1/admin/article";
    public String setEndpointForCreateArticle() {
    return endpointArticle;
    }

    public void sendReqForCreateArticle() {
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

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointForCreateArticle());
    }


    public void userSeeStatusCode() {
        restAssuredThat(response -> response.statusCode(201));
    }

    public void userValidateDataArticle() {
        Response response = SerenityRest.lastResponse();
        String description = response.getBody().jsonPath().get("data.description");
        Assert.assertEquals(description, "artikel aulia");
    }
}
