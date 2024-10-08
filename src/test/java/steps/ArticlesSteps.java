package steps;

import implementation.ArticleServiceImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.ArticleService;

import static context.RunContext.RUN_CONTEXT;

public class ArticlesSteps {
    ArticleService articleService = new ArticleServiceImplementation();

    @Given("GET Articles by {string} request")
    public void getArticlesList(String url) {
        articleService.getArticles(url);
    }

    @Then("Response status code is {string}")
    public void verifyResponseCode(String statusCode) {
        ValidatableResponse response = (ValidatableResponse) RUN_CONTEXT.get("response");
        int actualStatus = response.extract().statusCode();
        int expectedStatus = Integer.parseInt(statusCode);
        Assert.assertEquals(expectedStatus, actualStatus);
    }
}
