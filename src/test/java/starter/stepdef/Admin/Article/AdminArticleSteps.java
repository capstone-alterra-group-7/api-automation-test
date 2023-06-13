package starter.stepdef.Admin.Article;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Admin.Article.AdminArticle;

public class AdminArticleSteps {

    @Steps
    AdminArticle adminArticle;

    @Given("Admin set put api article endpoints")
    public void AdminSetPutApiArticleEndpoints() {
        adminArticle.PutApiArticle();
    }


    @When("admin request to endpoint for Update Article")
    public void adminRequestToEndpointForUpdateArticle() {
        adminArticle.RequestLoginforUpdateArticle();
    }

    @And("Admin update Article")
    public void adminUpdateArticle() {
        adminArticle.adminUpdateArticle();
    }

    @And("admin set put valid endpoints article")
    public void adminSetPutValidEndpointsArticle() {
        adminArticle.setPostUpdateArticle();
    }

    @And("admin send put HTTP request with valid endpoint article")
    public void adminSendPutHTTPRequestWithValidEndpointArticle() {
        adminArticle.PostCreateArticle();
    }

    @Then("admin receive valid put article response code {int}")
    public void adminReceiveValidPutArticleResponseCode(int arg0) {
    }



}
