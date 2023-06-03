package starter.stepdef.Admin.Article;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Article.GetAllArticlePage;

public class GetAllArticleSteps {
    @Steps
    GetAllArticlePage getAllArticles;
    @Given("user has valid endpoint for login admin")
    public void userHasValidEndpointForLoginAdmin() { getAllArticles.setEndpointForLoginAdmin();
    }

    @When("user send request for get token admin")
    public void userSendRequestForGetTokenAdmin() { getAllArticles.sendReqToEndpointLoginAdmin();
    }

    @When("user has endpoint to get articles")
    public void userHasEndpointToGetArticles() { getAllArticles.setEndpointForGetAllArticles();
    }

    @And("user send request to endpoint articles")
    public void userSendRequestToEndpointArticles() { getAllArticles.sendReqToEndpointArticles();
    }

    @Then("user get all detail articles with status code {int}")
    public void userGetAllDetailArticlesWithStatusCode(int arg0) { getAllArticles.validateStatusCode();
    }

    @And("i validate data with message response")
    public void iValidateDataWithMessageResponse() { getAllArticles.validateData();
    }

    @When("user has invalid endpoint for get articles")
    public void userHasInvalidEndpointForGetArticles() { getAllArticles.setInvalidEndpointArticles();
    }

    @And("user send request to invalid endpoint articles")
    public void userSendRequestToInvalidEndpointArticles() { getAllArticles.sendReqToInvEndpointArticles();
    }

    @Then("user cannot get all detail articles with status code {int}")
    public void userCannotGetAllDetailArticlesWithStatusCode(int arg0) { getAllArticles.seeErrorCode();
    }

    @And("i validate data with error message response")
    public void iValidateDataWithErrorMessageResponse() { getAllArticles.seeResponseError();
    }
}
