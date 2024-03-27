package com.WindowsResolutionTesting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Getcalley_calley_pro_features_Page {
	
	public static void main(String[] args) throws IOException, Exception {
		WebDriver chromeDriver = new ChromeDriver();
		Dimension[] resolutions = {new Dimension(1920, 1080),new Dimension (1366, 768) ,new Dimension (1536, 864)};
		
		for(Dimension resolution: resolutions) {
			Thread.sleep(2000);
			chromeDriver.manage().window().setSize(resolution);
			chromeDriver.get("https://www.getcalley.com/calley-pro-features/");
			Thread.sleep(3000);
			File screenshotFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
			try {
				
				SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMdd_HHmmss");
				Date d= new Date();
				
				String date_time=dateformat.format(d);
				Thread.sleep(3000);
				String filepath = "C:/Users/vara prasad/eclipse-workspace/web/Getcalley_Pro_Features_screenshots/ChromeDriverScreenshots/Resolutions_Screenshot" + resolution.getWidth()+ "x" + resolution.getHeight() +date_time+ ".png";
				FileUtils.copyFile(screenshotFile, new File(filepath));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		chromeDriver.quit();
		

		
		WebDriver firefoxDriver = new FirefoxDriver();
		Dimension[] resolutionss = {new Dimension(1920, 1080),new Dimension (1366, 768) ,new Dimension (1536, 864)};
		
		for(Dimension resolution: resolutionss) {
			Thread.sleep(2000);
			firefoxDriver.manage().window().setSize(resolution);
			firefoxDriver.get("https://www.getcalley.com/calley-pro-features/");
			Thread.sleep(3000);
			File screenshotFile = ((TakesScreenshot)firefoxDriver).getScreenshotAs(OutputType.FILE);
			try {
				SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMdd_HHmmss");
				Date d= new Date();
				
				String date_time=dateformat.format(d);
				
				Thread.sleep(3000);
				String filepath = "C:/Users/vara prasad/eclipse-workspace/web/Getcalley_Pro_Features_screenshots/FirefoxDriverScreenshots/Resolutions_Screenshot" + resolution.getWidth()+ "x" + resolution.getHeight() +date_time+ ".png";
				FileUtils.copyFile(screenshotFile, new File(filepath));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		firefoxDriver.quit();

		

	}

}
