package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		//setto la propr di sistema
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get("http://localhost:8080/selenium-web/home");
		
		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		
		driver.quit();
		
	}

}
