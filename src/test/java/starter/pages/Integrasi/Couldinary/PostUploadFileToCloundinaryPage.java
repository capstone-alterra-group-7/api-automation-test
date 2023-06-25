package starter.pages.Integrasi.Couldinary;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostUploadFileToCloundinaryPage {
    public String EndpointCloudinaryFileUpload = "https://api.tripease.my.id/api/v1/public/cloudinary/file-upload";

    public String setEndpointCloundinary() {
        return EndpointCloudinaryFileUpload;
    }


    public void sendReqUploadImageToCloundinary() {
        SerenityRest.given()
                .contentType("multipart/form-data")
                .multiPart("file", new File("D:\\D\\QE_Alta\\capstone\\api-automation-test\\src\\test\\resources\\features\\Integrasi\\Couldinary\\image.jpeg"))
                .when()
                .post(setEndpointCloundinary());
    }

    public void validateImageWithStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }


    public void validateNewImageWithMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully upload file to cloudinary");
    }
}
