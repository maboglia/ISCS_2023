package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagazzinoPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		//setto la propr di sistema
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get("http://localhost:8080/selenium-web/magazzino");
		
		
		System.out.println(driver.getTitle());
		
		List<WebElement> intestazioni = driver.findElements(By.xpath("/html/body/div/table/thead/tr"));
		List<WebElement> righeTabella = driver.findElements(By.xpath("/html/body/div/table/tbody/tr"));
		
		for (WebElement riga : righeTabella) {
			System.out.println(riga.getText());
		}
		
		((JavascriptExecutor) driver).executeScript("alert('funge')", "ciao");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
