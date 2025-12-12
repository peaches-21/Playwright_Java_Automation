package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {
    //All are Interface
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    //Browser initialization or set up Runs before every test method
    @BeforeMethod
    public void setUp(Method method) {
        //report initialization
        extentReports = ExtentManager.getInstance();
        extentTest = extentReports.createTest(method.getName());
        /* This starts Playwright.
           Think of this as "turning ON the testing engine".
           Playwright is a tool that can control browsers (Chrome, Firefox, Safari).
           Like switching on your computer before using any app. */
        playwright = Playwright.create();
        /* Opens Chromium browser
           (Chromium = the open-source version of Chrome)
           launch() means start/open the browser
           setHeadless(false)
           Headless = browser runs in background (not visible)
           By setting false, we tell Playwright:
           👉 "Show the browser window"
           setSlowMo(1000)
           SlowMo = make Playwright actions slow down
           1000 means 1 second delay for every action
           Example:
           Click button → wait 1 second
           Type text → wait 1 second
           Navigate URL → wait 1 second */
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        /* Opens a new browser tab.
           Every test usually needs a page to interact with.
           Example: Like opening Chrome → then opening a new tab to enter a website. */
        page = browser.newPage();
    }

    //Close browser Runs After every test method
    @AfterMethod
    public void tearDown(ITestResult result) {
        //report logic
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.fail("Test Failed");
            extentTest.fail(result.getThrowable());
            String screenshotPath = ScreenshotUtil.captureScreenshot(page, result.getName());
            extentTest.addScreenCaptureFromBase64String(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Skipped");
            extentTest.skip(result.getThrowable());
        }
        //if you don't flush, the report will not be created it will be empty
        extentReports.flush();
        /* If browser was successfully opened → close it.
           This prevents too many browser windows from staying open.
           Simple Idea:
           Like closing Chrome browser after you finish browsing. */
        if (browser != null) browser.close();
        /* Completely shuts down the Playwright engine.
           Frees memory and system resources.
           Think of it as:
           “Turn OFF the engine after the test is done.” */
        if (playwright != null) playwright.close();
        /* Your browser processes will keep running in background
           Memory leak issues (RAM increases continuously) */
    }
}
