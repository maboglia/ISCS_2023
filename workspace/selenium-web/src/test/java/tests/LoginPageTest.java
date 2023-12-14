package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import driver.DriverSingleton;
import utils.Costanti;

public class LoginPageTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.out.println("istanzio il driver");
		DriverSingleton.getInstance(Costanti.CHROME);
		driver =  DriverSingleton.getDriver();
		driver.get(Costanti.LOGIN_PAGE);

	}
	
	@Test
	public void testTitle() {
		String expectedTitle = "Login Page";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	
	
	@AfterAll
	public static void disconnect() {
		System.out.println("chiudo il driver");
		DriverSingleton.quitDriver();
	}
	

}
