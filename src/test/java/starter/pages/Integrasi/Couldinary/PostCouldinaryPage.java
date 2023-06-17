package starter.pages.Integrasi.Couldinary;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCouldinaryPage {
    public String endpointCouldinary = "https://capstone.hanifz.com/api/v1/public/cloudinary/url-upload";
    public String setEndpointCouldinary() { return endpointCouldinary;
    }


    public void sendReqURL() {
        String url = "https://res.cloudinary.com/dt3wofhpk/image/upload/v1686715556/go-cloudinary/xezstfsladfco61jpfg9.png";

        String body = "{\n" +
                "    \"url\":" + url + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointCouldinary());
    }

    public void validateImage() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String data = response.getBody().jsonPath().get("data");
        Assert.assertEquals(data, "https://res.cloudinary.com/dt3wofhpk/image/upload/v1686715556/go-cloudinary/xezstfsladfco61jpfg9.png");
    }
}
