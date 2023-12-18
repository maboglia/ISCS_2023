package driver;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface DriverStrategy {
	WebDriver setStrategy();
}
