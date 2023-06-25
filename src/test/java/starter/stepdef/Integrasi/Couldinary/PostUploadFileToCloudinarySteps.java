package starter.stepdef.Integrasi.Couldinary;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Integrasi.Couldinary.PostUploadFileToCloundinaryPage;

public class PostUploadFileToCloudinarySteps {
    @Steps
    PostUploadFileToCloundinaryPage uploadFileToCouldinary;
    @Given("user set valid endpoint for create new image to cloudinary")
    public void userSetValidEndpointForCreateNewImageToCloudinary() { uploadFileToCouldinary.setEndpointCloundinary();
    }

    @When("user send request with upload image from cloudinary")
    public void userSendRequestUploadImageFromCloudinary() { uploadFileToCouldinary.sendReqUploadImageToCloundinary();
    }

    @Then("user can see image data from cloudinary with status code {int}")
    public void userCanSeeImageDataFromCloudinaryWithStatusCode(int arg0) { uploadFileToCouldinary.validateImageWithStatusCode();
    }

    @And("i validate new image with message response")
    public void iValidateNewImageWithMessageResponse() { uploadFileToCouldinary.validateNewImageWithMessageResponse();
    }
}
