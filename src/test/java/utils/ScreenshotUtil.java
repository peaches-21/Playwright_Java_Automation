package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class ScreenshotUtil {
    public static String captureScreenshot(Page page, String testName) {
        // Placeholder for screenshot capture logic
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";
        // Actual screenshot capture code would go here
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(true));
        return screenshotPath;
    }
}
