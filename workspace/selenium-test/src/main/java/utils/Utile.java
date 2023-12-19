package utils;

import java.io.File;
import java.nio.file.CopyOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverSingleton;

public class Utile {

	
	public static boolean printScreen() {
		
		File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("schermate/prova_screenshot.png"));
			return true;
		} catch (Exception e) {
			System.err.println("Cattura non riuscita: " + e.getMessage());
			return false;
		}
	}
	
}
