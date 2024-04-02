import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.desktop.OpenURIEvent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class lesson4 {

    @BeforeAll
    static void before(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1980x1080";
        Configuration.holdBrowserOpen = true;
    }



    @Test
    void lesson4(){
    open("https://github.com/");
    $(byText("Search or jump to...")).click();

    $("#query-builder-test").setValue("Selenide").pressEnter();

    //sleep(7000);


        $(".Box-sc-g0xbh4-0.bBwPjs").click();

    //    sleep(7000);
        $("#wiki-tab").click();
    //    sleep(7000);



        $("#wiki-pages-filter").setValue("SoftAssertions");

        $(byText("SoftAssertions")).click();


        $("#wiki-body").shouldHave(text("JUnit5 extension"));

        $("#wiki-body").shouldHave(text("""
               @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));








}
}
