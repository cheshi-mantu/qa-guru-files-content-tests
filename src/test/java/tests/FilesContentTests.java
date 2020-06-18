package tests;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static helpers.Environment.*;
import static io.qameta.allure.Allure.step;

@Epic("QA.GURU QA automation course")
@Story("Files content testing.")
@Tag("files_tests")
class FilesContentTests extends TestBase {
    @BeforeEach
    void MaxBrowserWindow(){
        Configuration.startMaximized = true;
    }

    @Test
    @Description("")
    @DisplayName("")
    void pageOpenButtonClickClosestA() {
            step ("step desc", () -> open(url));
            step("Step desc", () -> {
                $(byText("Вклады")).closest("a").click();
                $("h1").shouldHave(text("Откройте вклад"));
            });
            }


}//class

