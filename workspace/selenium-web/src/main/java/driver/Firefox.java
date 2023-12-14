package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		
		return new FirefoxDriver();
	}

}
