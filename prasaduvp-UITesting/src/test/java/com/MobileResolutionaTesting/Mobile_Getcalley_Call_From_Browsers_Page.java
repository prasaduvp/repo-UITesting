package com.MobileResolutionaTesting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Mobile_Getcalley_Call_From_Browsers_Page {




		public static void main(String[] args) throws Exception {
			// Initialize WebDriver for Chrome
			WebDriver chromeDriver = new ChromeDriver();

			// Initialize WebDriver for Firefox
			WebDriver firefoxDriver = new FirefoxDriver();

			// List of resolutions
			String[] resolutions = {"360x640", "414x896", "375x667"};

			// List of browsers
			WebDriver[] drivers = {chromeDriver, firefoxDriver};

			// Base URL of the website
			String baseUrl = "https://www.getcalley.com/calley-call-from-browser/";

			// Get current date and time
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
			Date date = new Date();
			String dateTime = formatter.format(date);

			// Iterate through resolutions and browsers
			for (String resolution : resolutions) {
				for (WebDriver driver : drivers) {
					// Set resolution
					String[] dimension = resolution.split("x");
					int width = Integer.parseInt(dimension[0]);
					int height = Integer.parseInt(dimension[1]);
					driver.manage().window().setSize(new Dimension(width, height));

					// Open each page and take screenshot
					String folderPath = "C:/Users/vara prasad/eclipse-workspace/web/MobileResolutionsScreenshots/Mobile_Getcalley_call_From_Browsers_Page_Screenshots/Resolutions_screenshots/" + driver.getClass().getSimpleName() + "/" + resolution;
					new File(folderPath).mkdirs(); // Create folder if not exists

					driver.get(baseUrl);
					// Take screenshot
					File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					// Save screenshot
					FileUtils.copyFile(screenshotFile, new File(folderPath + "/Screenshot-" + dateTime + ".png"));
				}
			}

			// Close browsers
			chromeDriver.quit();
			firefoxDriver.quit();
		}

	}
	


