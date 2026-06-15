package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String path =
                "screenshots/"
                + testName
                + "_"
                + timestamp
                + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE);

        try {

            FileUtils.copyFile(
                    source,
                    new File(path));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}