package tests;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.DriverSingleton;
import utils.Costanti;

public class ProdottiPageTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.out.println("istanzio il driver");
		DriverSingleton.getInstance(Costanti.CHROME);
		driver =  DriverSingleton.getDriver();
		driver.get(Costanti.PRODOTTI_PAGE);

	}
	
	@Test
	public void testTitle() {
		String expectedTitle = "Prodotti Page";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void testZuRigheTabella() {
		
		int numRigheAttese = 20;
		List<WebElement> righeTabella = driver.findElements(By.xpath("//*[@id=\"tabella\"]/tbody/tr"));
		System.out.println(righeTabella.size());
		Assertions.assertTrue(righeTabella.size() == numRigheAttese);
		
	}
	
	@Test
	public void testTendina() {
		String voceAttesa = "men's clothing";
		WebElement tendina = driver.findElement(By.id("tendina"));
		
		//uso la classe select di selenium
		Select select = new Select(tendina);
		
		select.selectByIndex(2);
		
		WebElement primo = select.getFirstSelectedOption();
		System.out.println(primo.getText());
		Assertions.assertTrue(voceAttesa.equals(primo.getText()));
	}
	
	@AfterAll
	public static void disconnect() {
		System.out.println("chiudo il driver");
		DriverSingleton.quitDriver();
	}
	

}
