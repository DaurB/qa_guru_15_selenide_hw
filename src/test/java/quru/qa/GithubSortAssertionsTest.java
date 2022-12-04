package quru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSortAssertionsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void sortAssertionsTest() {
        open("https://github.com/");
        $(".header-search-input").setValue("selenide").submit();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".wiki-pages-box .wiki-more-pages-link button").click();
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").shouldHave(text("Using JUnit5 extend test class:"));
    }

}
