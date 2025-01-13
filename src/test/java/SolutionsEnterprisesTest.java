import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprisesTest {

    @Test
    void openEnterprisesFromSolutionsSuccessfully() {
        open("https://github.com/");

        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();

        $("#hero-section-brand-heading").shouldBe(visible)
                .shouldHave(text("The AI-powered developer platform"));
    }
}
