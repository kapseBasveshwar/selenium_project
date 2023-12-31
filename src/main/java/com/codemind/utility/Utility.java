package com.codemind.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
 
	static WebDriver driver;
	public static WebDriver getWebDriver() throws IOException {
		System.setProperty("webdriver.ChromeDriver", Utility.getProperty("driverPath"));
	       
         driver =new ChromeDriver();
		return driver;
}
	public static String getProperty(String key) throws IOException {
		File file=new File("src/test/resources/testData.properties");
		FileInputStream fileInputStream=new FileInputStream(file);
		
		Properties properties=new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}
	public static void switchToFrame(WebDriver driver, WebElement frameLocator) {
		driver.switchTo().frame(frameLocator);
	}
	public static void switchBackToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public  static void waitForElementToBeAvailble(WebDriver driver, long duration,String elm) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elm)));
	}
	
	
	public  static void takesSrceenshot(WebDriver driver,String name) throws IOException {
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File file= takesScreenshot.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(file,new File("src/test/resources/Screenshots/"+name+".png"));
		
		
	}
}
