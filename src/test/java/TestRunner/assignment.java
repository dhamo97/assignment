package TestRunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.base;
import POM.pom;

public class assignment extends base {

@BeforeTest
private void lanuch() {
	
	browser("https://react-book-management-app.netlify.app/");

}


@Test(priority = 1)
private void create() {
	
	click(pom.add_book);
	enterText(pom.book_name, "The God of Small Things");
	enterText(pom.author_name, "Arundhati Roy");
	enterText(pom.book_quantity, "20");
	enterText(pom.book_price, "250");
	click(pom.submit);
	newPage.waitForTimeout(3000);
	
	click(pom.add_book);
	enterText(pom.book_name, "The White Tiger");
	enterText(pom.author_name, "Aravind Adiga");
	enterText(pom.book_quantity, "30");
	enterText(pom.book_price, "300");
	click(pom.submit);
	screenshot("screen1");
	newPage.waitForTimeout(3000);

}


@Test(priority = 2)
private void Read() {
	
	 click(pom.edit);
     read(pom.book_name);
     read(pom.author_name);
     read(pom.book_quantity);
     read(pom.book_price);
     click(pom.submit);
     newPage.waitForTimeout(3000);

}


@Test(priority = 3)
private void update() {
	
	click(pom.edit);
	Fill(pom.book_quantity, "40");
	Fill(pom.book_price, "250");
	click(pom.submit);
	screenshot("screen2");
	newPage.waitForTimeout(3000);
}


@Test(priority = 4)
private void delete() {
	
	click(pom.delete);
	screenshot("screen3");
	newPage.waitForTimeout(3000);
}


@AfterTest
private void teardown() {
	
	close();

}
}
