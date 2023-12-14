package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		
		System.setProperty("webdriver.gecko.driver", "firefox");

		
		
		return new FirefoxDriver();
	}

}
