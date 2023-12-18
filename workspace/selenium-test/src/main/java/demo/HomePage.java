package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverSingleton;
import utils.Costanti;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "body > h1")
	WebElement titoloPagina;
	
	@FindBy(xpath = "/html/body/div/main/section/div/div/p[2]/a[1]")
	WebElement btnMainAction;
	
	
	public WebElement getBtnMainAction() {
		return btnMainAction;
	}

	public WebElement getTitoloPagina() {
		return titoloPagina;
	}




	public void setTitoloPagina(WebElement titoloPagina) {
		this.titoloPagina = titoloPagina;
	}




	public static void main(String[] args) {
		
//		WebDriver driver = new ChromeDriver();
		DriverSingleton.getInstance(Costanti.CHROME);

		WebDriver driver = DriverSingleton.getDriver();
		
		//setto la propr di sistema
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://github.com/maboglia/Fondamenti/blob/master/022_DOM.md");
		driver.get(Costanti.HOME_PAGE);
		
		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		
		System.out.println("E' il titolo che ti aspettavi? " + expectedTitle.equals(actualTitle));
		
		driver.quit();
		
	}

}
