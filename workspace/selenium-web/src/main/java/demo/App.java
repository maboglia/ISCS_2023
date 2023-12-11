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

public class App {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//setto la propr di sistema
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get("http://localhost:8080/selenium-web/logindemo");
		
		WebElement usernameTxt = driver.findElement(By.cssSelector("body > form > input[type=text]:nth-child(1)"));
		WebElement passwordTxt = driver.findElement(By.cssSelector("body > form > input[type=password]:nth-child(3)"));
		WebElement bottone = driver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(5)"));

		
		usernameTxt.sendKeys("mauro");
		passwordTxt.sendKeys("1234");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		bottone.click();
		

		
		driver.quit();
		
	}

}
