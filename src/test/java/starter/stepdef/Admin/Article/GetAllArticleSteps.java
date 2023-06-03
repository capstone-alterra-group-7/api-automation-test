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

    @When("user has endpoint to get article by id")
    public void userHasEndpointToGetArticleById() { getAllArticles.setEndpointArticleByID();
    }

    @And("user send request to endpoint article by id")
    public void userSendRequestToEndpointArticleById() { getAllArticles.sendReqToEndpointArticleByID();
    }

    @Then("user get detail article by id with status code {int}")
    public void userGetDetailArticleByIdWithStatusCode(int arg0) { getAllArticles.validateStatusCodeArticleByID();
    }

    @And("i validate data article by id with message response")
    public void iValidateDataArticleByIdWithMessageResponse() { getAllArticles.validateDataWithMessageResponse();
    }

    @When("user has endpoint to get article with invalid id")
    public void userHasEndpointToGetArticleWithInvalidId() { getAllArticles.setEndpointArticleInvalidID();
    }

    @And("user send request to endpoint article with invalid id")
    public void userSendRequestToEndpointArticleWithInvalidId() { getAllArticles.sendReqToEndpointArticleWithInvalidID();
    }

    @Then("user cannot get detail article cause invalid id and see status code {int}")
    public void userCannotGetDetailArticleCauseInvalidIdAndSeeStatusCode(int arg0) { getAllArticles.seeStatusCode();
    }

    @And("i validate error response")
    public void iValidateErrorResponse() { getAllArticles.validateErrorResponse();
    }

    @When("user has invalid endpoint to get article")
    public void userHasInvalidEndpointToGetArticle() { getAllArticles.setInvalidEndpointByID();
    }

    @And("user send request to invalid endpoint article")
    public void userSendRequestToInvalidEndpointArticle() { getAllArticles.sendReqToInvEndpointByID();
    }

    @Then("user cannot get detail article cause invalid endpoint and see status code {int}")
    public void userCannotGetDetailArticleCauseInvalidEndpointAndSeeStatusCode(int arg0) { getAllArticles.statusCode();
    }

    @And("user see error response")
    public void userSeeErrorResponse() { getAllArticles.seeErrorResponse();
    }
}
