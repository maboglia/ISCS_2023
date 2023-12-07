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
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get("http://localhost:8080/selenium-web/index.jsp");
		
		WebElement bottone = driver.findElement(By.id("btn"));
		WebElement input = driver.findElement(By.id("testo"));
		input.sendKeys("prova");
		bottone.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert fintoAlert = driver.switchTo().alert();
		
		
		fintoAlert.sendKeys("bene");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fintoAlert.accept();
//		if (fintoAlert.getText().equals("fung")) {
//		} else {
//			fintoAlert.dismiss();
//		}
		
//		List<WebElement> titoliH2 = driver.findElements(By.tagName("h2"));
//		
//		for (WebElement webElement : titoliH2) {
//			System.out.println(webElement.getText());
//		}
//		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
