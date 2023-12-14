package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		

		return new ChromeDriver();
	}

}
