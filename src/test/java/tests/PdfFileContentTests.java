package tests;

import com.codeborne.pdftest.PDF;
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
@Story("Sample PDF File tests")
@Tag("files_tests")
class PdfFileContentTests {

    @Test
    @Description("Local Sample PDF file test against test string")
    @DisplayName("Local sample PDF file test. Must contain test string.")
    void successfulSearchForTextInPdfFile() throws IOException {
        String expectedFileText = "AAABBBCCCDDDEEEFFFGGG";
        String sampleFilePath = "src/test/resources/files/sample_pdf.pdf";

        File sampleFile = new File(sampleFilePath);
        PDF pdfFile = new PDF(sampleFile);

        assertThat(pdfFile, PDF.containsText(expectedFileText));
            }

}