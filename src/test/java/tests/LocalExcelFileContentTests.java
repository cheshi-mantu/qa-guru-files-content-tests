package tests;

import com.codeborne.xlstest.XLS;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("Sample Excel file tests")
@Tag("local_files_tests")
class LocalExcelFileContentTests {

    @Test
    @Description("Local Sample XL file test against test string")
    @DisplayName("Local sample XL file test. Must contain test string.")
    void successfulSearchForTextInExcelFile() throws IOException {
        String expectedFileText = "AAABBBCCCDDDEEEFFFGGG";
        String sampleFilePath = "src/test/resources/files/sample_xl.xlsx";

        File sampleFile = new File(sampleFilePath);
        XLS xlFile = new XLS(sampleFile);

        assertThat(xlFile, XLS.containsText(expectedFileText));
    }
}