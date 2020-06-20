package tests;

import helpers.FileUtils;
import helpers.ZipHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


@Epic("QA.GURU QA automation course")
@Story("Files content testing after unzip.")
@Tag("local_files_tests")
class LocalZipFilesContentTests extends TestBase {

    @Test
    @Description("Unzip zip archive without password, read text file, compare content against expected string")
    @DisplayName("Unzip and check txt file content to have expected string")
    void succUnzipTxtFileTextMatch() {
        String source = "src/test/resources/files/zip_archive_3files.zip";
        String destination = "src/test/resources/files/unzip/";
        final String STREXPECTED = "AAABBBCCCDDDEEEFFFGGGHHH";

        ZipHelper.unzip(source, destination);
        String txtFromFile = new FileUtils().readStringFromFile(destination + "/test_file.txt");
        System.out.println("Actual text from file: \n" + txtFromFile);
        step("Check file content", () -> {
            assertThat(txtFromFile, containsString(STREXPECTED));
        });
    }
    @Test
    @Description("Unzip zip archive with password, read text file, compare content against expected string")
    @DisplayName("Unzip protected zip and check txt file content to have expected string")
    void succUnzipWithPasswordTxtFileTextMatch() {
        String source = "src/test/resources/files/zip_archive_3files_pass_zaza.zip";
        String destination = "src/test/resources/files/unzip_pass/";
        String password = "zaza";
        final String STREXPECTED = "AAABBBCCCDDDEEEFFFGGGHHH";

        ZipHelper.unzip(source, destination, password);
        String txtFromFile = new FileUtils().readStringFromFile(destination + "/test_file.txt");
        System.out.println("Actual text from file: \n" + txtFromFile);
        step("Check file content", () -> {
            assertThat(txtFromFile, containsString(STREXPECTED));
        });
    }
}

