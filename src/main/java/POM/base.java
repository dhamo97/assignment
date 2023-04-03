package POM;



import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class base {
	
	public static Browser launch;
	public static BrowserContext Page;
	public static Page newPage;
	

public static void browser (String search) {
	
	   Playwright display = Playwright.create();
		 launch = display.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		 Page = launch.newContext();
		  newPage = Page.newPage();
		  newPage.navigate(search);
		 
}


public static  void click(String option) {
	
	newPage.click(option);

}
	
public static  void enterText(String element , String inputs) {
	
	newPage.locator(element).type(inputs);

}
public static  void read(String element) {
	
	String bookname = newPage.getAttribute(element, "value");
    System.out.println(bookname);
    

}
public static  void screenshot(String name) {
	
	newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(name+".png")));

}

public static void Fill(String element,String inputs) {
	
	newPage.fill(element,inputs);

}

public static  void close() {
	
	newPage.close();

}
}
