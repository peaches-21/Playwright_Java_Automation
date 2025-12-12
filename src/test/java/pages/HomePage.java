package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final String timeLink = "a[href='/web/index.php/time/viewTimeModule']";

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickTimeLink() {
        page.click(timeLink);
    }
}
