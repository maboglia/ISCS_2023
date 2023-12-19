package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.HomePage;
import driver.DriverSingleton;
import utils.Costanti;
import utils.Utile;

public class HomePageTest {
	
	static WebDriver driver;
	static HomePage homePage;
	
	@BeforeAll
	public static void init() {
		System.out.println("istanzio il driver");
		DriverSingleton.getInstance(Costanti.CHROME);
		driver =  DriverSingleton.getDriver();
		driver.get(Costanti.HOME_PAGE);
		homePage = new HomePage();

	}
	
	@Test
	public void testTitle() {
		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testTitoloPagina() {
		
		System.out.println("Il titolo h1 della pagina è: " + homePage.getTitoloPagina().getText());
		Assertions.assertTrue(Utile.printScreen());
	}
	
	@Test
	public void testMainButton() {
		homePage.getBtnMainAction().click();
		System.out.println(homePage.getBtnMainAction().getText());
	}
	
	
	@AfterAll
	public static void disconnect() {
		System.out.println("chiudo il driver");
		DriverSingleton.quitDriver();
	}
	

}
