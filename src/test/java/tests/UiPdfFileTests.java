package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import helpers.Environment;
import helpers.FileReadHelper;
import helpers.FileUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("PDF File tests with download from site UI")
@Tag("ui_files_tests")
class UiPdfFileTests {

    @Test
    @Description("Log-in, change URL, locate file, downlowad file, check content against test string")
    @DisplayName("Text file web UI test")
    void successfulSearchForTextInFile()  throws IOException {
//        Configuration.reportsFolder = <desired location for downloaded files>; чтобы поменять путь скачанных файлов

        String expectedFileText = "AAABBBCCCDDDEEEFFF";

        String jenkinsLogin = FileReadHelper.getStringFromFile("jusername.secret");
        String jenkinsPassword = FileReadHelper.getStringFromFile("jpassword.secret");
        String jUrl =  FileReadHelper.getStringFromFile("jurl.secret");

        if (Environment.url != null) {
            jUrl = Environment.url;
        }
        if (Environment.jUserName != null) {
            jenkinsLogin = Environment.jUserName;
        }
        if (Environment.jPassword != null) {
            jenkinsPassword = Environment.jPassword;
        }

        open(jUrl+"/login?from=/");
        $(byName("j_username")).val(jenkinsLogin);
        $(byName("j_password")).val(jenkinsPassword).pressEnter();
        $(withText(jenkinsLogin)).shouldBe(Condition.visible);

        open(jUrl + "/job/cheshi_mantu_files_testing_tlg_bot_via_curl/ws/src/test/resources/files/");

        File sampleFile = $("[href='sample_pdf.pdf']").download();

        PDF pdfFile = new PDF(sampleFile);
        assertThat(pdfFile, PDF.containsText(expectedFileText));

    }

}