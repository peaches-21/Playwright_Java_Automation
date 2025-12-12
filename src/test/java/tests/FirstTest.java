package tests;

import base.BaseTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            // Browser is Interface
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            //Page is interface
//            Page page = browser.newPage();
//            page.navigate("https://google.com");
//            //Class.function.method
//            System.out.println(page.title());
//            browser.close();
//        }
//    }

    @Test
    public void verifyTitle() {
        page.navigate("https://google.com/ncr");
        if (page.isVisible("button:has-text('Accept all')")) {
            page.click("button:has-text('Accept all')");
        }
        System.out.println("Google NCR opened Successfully");
        System.out.println("Page title: " + page.title());

    }
}
