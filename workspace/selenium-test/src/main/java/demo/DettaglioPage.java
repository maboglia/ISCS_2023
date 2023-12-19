package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverSingleton;

public class DettaglioPage {
	private WebDriver driver;
	
	public DettaglioPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/h1")
	private WebElement titoloPagina;
	
	public WebElement getTitoloPagina() {
		return titoloPagina;
	}
	
	
}
