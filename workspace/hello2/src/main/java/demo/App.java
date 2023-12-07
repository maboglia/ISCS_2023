package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//setto la propr di sistema
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");

		List<WebElement> titoliH3 = driver.findElements(By.tagName("h3"));
		
		for (WebElement webElement : titoliH3) {
			System.out.println(webElement.getText());
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
