package tests;

import helpers.FileUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("QA.GURU QA automation course")
@Story("Files content testing.")
@Tag("local_files_tests")
class LocalTxtFilesContentTests extends TestBase {


    @Test
    @Description("Read text file, compare content against expected string")
    @DisplayName("Check txt file content to have expected string")
    void succTxtFileTextMatch() {
        final String STREXPECTED = "AAABBBCCCDDDEEEFFFGGGHHH";
        String txtFromFile = new FileUtils().readStringFromFile("src/test/resources/files/test_file.txt");
        System.out.println("Actual text from file: \n" + txtFromFile);
            step("Check file content", () -> {
//                assertTrue(txtFromFile.contains(STREXPECTED), "Expected text: " + STREXPECTED + "vs. " + txtFromFile);
                assertThat(txtFromFile, containsString(STREXPECTED));
            });
    }


}//class

