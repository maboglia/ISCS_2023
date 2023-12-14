package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("useAutomationExtension", false);

		return new ChromeDriver();
	}

}
