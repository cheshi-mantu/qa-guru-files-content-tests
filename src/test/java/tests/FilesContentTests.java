package tests;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("QA.GURU QA automation course")
@Story("Files content testing.")
@Tag("files_tests")
class FilesContentTests extends TestBase {
    @BeforeEach
    void MaxBrowserWindow(){
        Configuration.startMaximized = true;
    }

    @Test
    @Description("Description")
    @DisplayName("DisplayName")
    void succTxtFileTextMatch() {
//            step ("step desc", () -> open(url));
            step("Step desc", () -> {
                assertTrue(true);
            });
            }


}//class

