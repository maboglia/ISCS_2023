package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://127.0.0.1:5500/ISCS_2023/negozio/");
		
		//by id
		WebElement titolo = driver.findElement(By.id("titolo"));
		System.out.println("Il titolo è: " + titolo.getText());
		
		
		driver.quit();
		//driver.close();
	}

}
