package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    //Locators
    private final String usernameInput = "input[name='username']";
    private final String passwordInput = "input[name='password']";
    private final String loginButton = "button[type='submit']";
    //Constructor
    public LoginPage(Page page) {
        this.page = page;
    }
    //Page Actions
    public void navigateToLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }
    public void enterUsername(String username) {
        page.fill(usernameInput, username);
    }
    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }
    public void clickLoginButton() {
        page.click(loginButton);
    }
//    public void login(String username, String password) {
//        page.fill(usernameInput, username);
//        page.fill(passwordInput, password);
//        page.click(loginButton);
//    }
}
