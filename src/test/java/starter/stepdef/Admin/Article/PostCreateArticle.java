package starter.stepdef.Admin.Article;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostCreateArticlePage;

public class PostCreateArticle {
    @Steps
    PostCreateArticlePage createArticle;
    @Given("user has endpoint for create a new article")
    public void userHasEndpointForCreateANewArticle() { createArticle.setEndpointForCreateArticle();
    }

    @When("user send request for create a new article")
    public void userSendRequestForCreateANewArticle() { createArticle.sendReqForCreateArticle();
    }

    @Then("user success create article and see status code {int}")
    public void userSuccessCreateArticleAndSeeStatusCode(int arg0) { createArticle.userSeeStatusCode();
    }

    @And("i validate data article")
    public void iValidateDataArticle() { createArticle.userValidateDataArticle();
    }
}
