package implementation;

import api.Article;
import config.ConfigLoader;
import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import service.ArticleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static io.restassured.RestAssured.given;

@Log4j2
public class ArticleServiceImplementation implements ArticleService {
    private final ConfigLoader configLoader = new ConfigLoader();

    @Override
    public List<Article> getArticles(String url) {
        String baseUrl = configLoader.getProperty("server.url");
        String fullUrl = baseUrl + url;

        List<Article> articles = new ArrayList<>();

        ValidatableResponse response = given().log().everything().
                get(fullUrl).then().log().ifError();
        RUN_CONTEXT.put("response", response);
        try {
            articles = response.extract().jsonPath().getList("articles.", Article.class);
        } catch (Exception e) {
            log.error("Articles Got Exception : " + Arrays.toString(e.getStackTrace()));
        }
        return articles;
    }
}
