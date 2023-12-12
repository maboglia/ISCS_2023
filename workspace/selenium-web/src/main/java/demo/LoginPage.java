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

public class LoginPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//setto la propr di sistema
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get("http://localhost:8080/selenium-web/logindemo");
		
		WebElement usernameTxt = driver.findElement(By.cssSelector("body > div.container > form > input[type=text]:nth-child(1)"));
		WebElement passwordTxt = driver.findElement(By.cssSelector("body > div.container > form > input[type=password]:nth-child(3)"));
		WebElement bottone = driver.findElement(By.cssSelector("body > div.container > form > input[type=submit]:nth-child(5)"));

		System.out.println(driver.getTitle());
		
		usernameTxt.sendKeys("mauro");
		passwordTxt.sendKeys("12345");
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
