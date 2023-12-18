package tests;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverSingleton;
import utils.Costanti;

public class MagazzinoPageTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.out.println("istanzio il driver");
		DriverSingleton.getInstance(Costanti.CHROME);
		driver =  DriverSingleton.getDriver();
		driver.get(Costanti.MAGAZZINO_PAGE);

	}
	
	@Test
	public void testTitle() {
		String expectedTitle = "Magazzino Page";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testRigheTabella() {
		
		int numRigheAttese = 10;
		List<WebElement> righeTabella = driver.findElements(By.xpath("/html/body/div/table/tbody/tr"));
		Assertions.assertTrue(righeTabella.size() == numRigheAttese);
		
	}
	
	@Test
	public void testAjaxBtn() {
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		
		List<WebElement> imgProdotti = driver.findElements(By.tagName("img"));
		Assertions.assertTrue(imgProdotti.size() == 20);
		
	}
	
	@AfterAll
	public static void disconnect() {
		System.out.println("chiudo il driver");
		DriverSingleton.quitDriver();
	}
	

}
