package playwrightproject;


import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class project  {
	public static Browser launch;
	public static BrowserContext Page;
	public static Page newPage;
	
@BeforeTest
public static void lanuch() {
		 Playwright display = Playwright.create();
		 launch = display.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		 Page = launch.newContext();
		 newPage = Page.newPage();
		 newPage.navigate("https://react-book-management-app.netlify.app/");
	}
@Test(priority = 0)
public static void createBook() {
	
	newPage.click("//a[text()='Add Book']");
	newPage.getByText("Add Book").click();
	newPage.type("//input[@id='name']", "War and Peace");
	newPage.locator("//input[@id='author']").type("Leo Tolstoy");

	newPage.type("//input[@id='quantity']","20", new TypeOptions().setDelay(500));
	newPage.type("//input[@id='price']", "200");
	newPage.click("//button[@type='submit']");
	newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot1.png")));


}



@Test(priority = 1,dependsOnMethods ="createBook")
private static void updateBook() throws InterruptedException {
	newPage.click("//a[text()='Add Book']");
	newPage.type("//input[@id='name']", "Pride and Prejudice");
	newPage.locator("//input[@id='author']").type("Jane Austen");

	newPage.type("//input[@id='quantity']","20", new TypeOptions().setDelay(500));
	newPage.type("//input[@id='price']", "200");
	newPage.click("//button[@type='submit']");
	newPage.waitForTimeout(1000);
	newPage.click("//button[@type='button']");
	newPage.fill("//input[@id='name']", "1894");
	newPage.fill("//input[@id='author']", "George Orwell");
	
	newPage.click("//button[@type='submit']");
	newPage.waitForTimeout(1000);
	newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot2.png")));
	
	
}
@Test(priority = 2,dependsOnMethods ="updateBook")
private static void readBook() {
	newPage.click("//button[text()='Edit']");
	String attribute = newPage.getAttribute("//input[@id='name']", "value");
    System.out.println(attribute);
    newPage.click("//button[@type='submit']");
	newPage.waitForTimeout(1000);
    
}

@Test(priority = 3,dependsOnMethods ="readBook")
private static void deleteBookDetails() {
	newPage.click("//*[text()='Delete']");
	newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot3.png")));
	
	
}
@AfterTest
private void teardown() {
	newPage.close();

}

}
 