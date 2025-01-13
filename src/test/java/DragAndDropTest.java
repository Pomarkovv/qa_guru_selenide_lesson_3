import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    private static final SelenideElement boxA = $("#column-a");
    private static final SelenideElement boxB = $("#column-b");

    @Test
    void dragAndDropMethodSuccessfully() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        boxA.dragAndDropTo($("#column-b"));

        boxA.shouldHave(text("B"));
        boxB.shouldHave(text("A"));
    }

    @Test
    void actionsMethodSuccessfully() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().moveToElement(boxA)
                .clickAndHold()
                .moveToElement(boxB)
                .release()
                .build()
                .perform();

        boxA.shouldHave(text("B"));
        boxB.shouldHave(text("A"));
    }
}
