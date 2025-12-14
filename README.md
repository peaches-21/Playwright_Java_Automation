# 🎭 Playwright with Java – Beginner Guide

This repository is a **beginner‑friendly guide to Playwright with Java**, covering:
- Installation & setup
- Project structure
- Locators (with clear explanations)
- Common user actions (click, type, select, wait, etc.)

This README is ideal for **QA Automation Engineers** and **Java beginners** who want to start UI automation using Playwright.

---

## 📌 What is Playwright?

**Playwright** is a modern end‑to‑end automation framework developed by Microsoft. It supports automation across:
- Chromium (Chrome, Edge)
- Firefox
- WebKit (Safari)

### ✅ Why Playwright?
- Fast and reliable
- Auto‑waits for elements
- Powerful locators
- Supports parallel execution
- Works well with CI/CD

---

## 🛠 Prerequisites

Before installing Playwright with Java, make sure you have:

| Tool | Version |
|-----|--------|
| Java JDK | 11 or higher |
| Maven | 3.6+ |
| IDE | IntelliJ / Eclipse |
| Node.js | Comes with Playwright (auto‑installed) |

Verify installations:
```bash
java -version
mvn -version
```

---

## 🚀 Create Playwright Java Project

### Step 1: Create Maven Project

```bash
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=playwright-java \
  -DarchetypeArtifactId=maven-archetype-quickstart
```

### Step 2: Add Playwright Dependency

Add this to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.microsoft.playwright</groupId>
        <artifactId>playwright</artifactId>
        <version>1.44.0</version>
    </dependency>
</dependencies>
```

---

## 📦 Install Playwright Browsers

Run the following command **once**:

```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

🔹 This installs Chromium, Firefox, and WebKit locally.

---

## 🧱 Basic Project Structure

```
playwright-java
 ├── src
 │   ├── main
 │   │   └── java
 │   │       └── pages
 │   └── test
 │       └── java
 │           └── tests
 ├── pom.xml
 └── README.md
```

---

## ▶️ First Playwright Test

```java
import com.microsoft.playwright.*;

public class FirstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate("https://example.com");
            System.out.println(page.title());
        }
    }
}
```

### 🔍 Explanation
- `Playwright.create()` → starts Playwright
- `chromium().launch()` → launches browser
- `newPage()` → opens a new tab
- `navigate()` → opens URL

---

## 🎯 Locators in Playwright (Most Important)

Locators are used to **find elements on a webpage**.

Playwright locators are **auto‑waiting** and **retry automatically**.

---

### 1️⃣ Locate by ID

```java
page.locator("#username").fill("Admin");
```

✔ Uses CSS selector
✔ Fast and reliable

---

### 2️⃣ Locate by Name

```java
page.locator("[name='password']").fill("secret");
```

---

### 3️⃣ Locate by Class

```java
page.locator(".login-button").click();
```

⚠ Avoid if class is dynamic

---

### 4️⃣ Locate by Text

```java
page.locator("text=Login").click();
```

✔ Very readable
✔ Best for buttons & links

---

### 5️⃣ Locate by XPath

```java
page.locator("//input[@type='email']").fill("test@email.com");
```

⚠ Use only when CSS is not possible

---

### 6️⃣ Playwright Recommended: getBy*

```java
page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
page.getByPlaceholder("Username").fill("Admin");
page.getByLabel("Password").fill("secret");
```

✔ Stable
✔ Accessibility‑friendly

---

## 🖱 Common Actions with Explanation

### Click

```java
page.locator("#submit").click();
```
Clicks on a button or link.

---

### Type / Fill Input

```java
page.locator("#email").fill("user@test.com");
```
Clears existing text and types new value.

---

### Press Keyboard Key

```java
page.keyboard().press("Enter");
```
Simulates keyboard action.

---

### Select Dropdown

```java
page.locator("#country").selectOption("Germany");
```
Selects value from `<select>` dropdown.

---

### Check Checkbox

```java
page.locator("#agree").check();
```
Ensures checkbox is checked.

---

### Hover

```java
page.locator("#menu").hover();
```
Moves mouse over element.

---

### Get Text

```java
String message = page.locator("#success").textContent();
```
Reads visible text.

---

### Wait for Element

```java
page.locator("#dashboard").waitFor();
```
Waits until element appears.

✔ No Thread.sleep needed

---

## ⏱ Auto Waiting (Important Concept)

Playwright automatically waits for:
- Element to be visible
- Element to be enabled
- Page load & navigation

👉 This reduces flaky tests significantly.

---

## 📌 Best Practices

✅ Use `getByRole`, `getByLabel`
✅ Avoid hard waits (`Thread.sleep`)
✅ Use Page Object Model (POM)
✅ Keep locators clean & readable

---

## 📂 Next Steps

- Implement Page Object Model (POM)
- Add TestNG / JUnit
- Add reporting (Extent / Allure)
- Integrate with CI/CD
