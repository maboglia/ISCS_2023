package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

	private static DriverSingleton instance;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		creaIstanza(driver);
	}

	private WebDriver creaIstanza(String strategia) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.scegliStrategia(strategia);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static DriverSingleton getInstance(String driver) {
		
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		
		return instance;
	}
	
	public static void quitDriver() {
		instance = null;
		driver.quit();
	}
	
}
