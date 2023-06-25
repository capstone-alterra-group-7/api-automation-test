package starter.stepdef.Integrasi.Couldinary;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Integrasi.Couldinary.PostCouldinaryPage;

public class PostCouldinarySteps {
    @Steps
    PostCouldinaryPage postImageToCouldinary;

    @Given("user set valid endpoint for create new image to couldinary")
    public void userSetValidEndpointForCreateNewImageToCouldinary() { postImageToCouldinary.setEndpointCouldinary();
    }

    @When("user send request url image from couldinary")
    public void userSendRequestUrlImageFromCouldinary() { postImageToCouldinary.sendReqURL();
    }

    @Then("user can see image data from cloundinary with status code {int}")
    public void userCanSeeImageDataFromCloundinaryWithStatusCode(int arg0) { postImageToCouldinary.validateImage();
    }

    @And("i validate data image with message response")
    public void iValidateDataImageWithMessageResponse() { postImageToCouldinary.validateMessageResponse();
    }
}
