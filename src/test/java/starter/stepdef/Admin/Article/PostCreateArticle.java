package starter.stepdef.Admin.Article;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Article.PostCreateArticlePage;

public class PostCreateArticle {
    @Steps
    PostCreateArticlePage createArticle;

    @Given("user set valid endpoint for login admin")
    public void userSetValidEndpointForLoginAdmin() { createArticle.setEndpointAuth();
    }

    @When("user send request to auth admin")
    public void userSendRequestToAuthAdmin() { createArticle.sendReqToEndpointAuth();
    }

    @When("user set endpoint for create a new article")
    public void userSetEndpointForCreateANewArticle() { createArticle.setEndpointArticle();
    }

    @And("user send request to request url for create a new article")
    public void userSendRequestToRequestUrlForCreateANewArticle() { createArticle.sendReqToEndpointArticle();
    }

    @Then("user success create article and see status code {int}")
    public void userSuccessCreateArticleAndSeeStatusCode(int arg0) { createArticle.getStatusCodeSuccessCreate();
    }

    @And("i validate data article")
    public void iValidateDataArticle() { createArticle.validateDataArticle();
    }

    @Given("user has endpoint for create a new article")
    public void userHasEndpointForCreateANewArticle() { createArticle.setEndpointNewArticle();
    }

    @When("user send request for create a new article")
    public void userSendRequestForCreateANewArticle() { createArticle.sendReqToNewArticle();
    }

    @Then("user cannot create article and see status code {int}")
    public void userCannotCreateArticleAndSeeStatusCode(int arg0) { createArticle.userSeeStatusCode();
    }

    @And("i validate data article with message unatuhorized")
    public void iValidateDataArticleWithMessageUnathorized() { createArticle.userValidateDataArticle();
    }
}
