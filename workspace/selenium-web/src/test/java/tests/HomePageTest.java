package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.out.println("istanzio il driver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/selenium-web/home");

	}
	
	@Test
	public void testTitle() {
		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	
	
	@AfterAll
	public static void disconnect() {
		System.out.println("chiudo il driver");
		driver.quit();
	}
	

}
