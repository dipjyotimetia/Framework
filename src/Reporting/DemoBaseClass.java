package Reporting;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoBaseClass {
	static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			driver = new FirefoxDriver();

		}

		return driver;

	}

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 */

	public static void takeSnapShot(WebDriver webdriver,String filepath)
			throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(filepath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
