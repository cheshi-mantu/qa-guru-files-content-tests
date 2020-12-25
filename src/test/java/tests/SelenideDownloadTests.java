package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("selenide_downloads")
public class SelenideDownloadTests {
    File txtFileToDownload;
    @Test
    @Description("Download text file by href link text, assert name and length")
    void selenideDownloadByHrefLink() throws FileNotFoundException {
        step("Open web-page with href links to files", () -> {
            open("http://the-internet.herokuapp.com/download");
        });
        step("Download text file by href link text", () -> {
            txtFileToDownload = $(By.linkText("some-file.txt")).download();
        });
        step("Assert downloaded file name and length", () -> {
            assertEquals("some-file.txt", txtFileToDownload.getName());
            assertEquals(307, txtFileToDownload.length());
        });

    }
    @Test
    @Description("Download text file by button click and get action")
    //this test requires     testImplementation "com.browserup:browser-proxy-core:2.1.1"
    void selenideDownloadByButtonGetAction() throws FileNotFoundException {
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = FileDownloadMode.PROXY;
        step("Open web-page with buttons that will start download", () -> {
            open("https://jsfiddle.net/qL2csxn3/15");
            switchTo().frame("result"); // buttons are in the iframe with name "result"
        });
        step("Download text file by href link text", () -> {
            txtFileToDownload = $("#external-download").download();
        });
        step("Assert downloaded file name and length", () -> {
            assertEquals("some-file.txt", txtFileToDownload.getName());
            assertEquals(307, txtFileToDownload.length());
        });

    }

}


