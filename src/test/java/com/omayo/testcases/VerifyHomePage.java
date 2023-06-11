package com.omayo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoHomePage;

public class VerifyHomePage {
	  WebDriver driver;
		OmayoHomePage omayoHomePage;
		SoftAssert softAssert;
	  
	  @BeforeMethod
	  public void setup() throws IOException {
			this.driver=Utility.getWebDriver();
			driver.get(Utility.getProperty("url"));
			driver.manage().window().maximize();
			omayoHomePage=new OmayoHomePage(driver);
			 softAssert =new SoftAssert();
		}
	  @Test
	  public void verifyUserAbleToSelectOptionsFromDropdown() throws IOException {
		  //hard assertion.............
		/*  assertEquals(omayoHomePage.getHomePageTitle(),"omayo (QAFox.com)");
		 
		  assertTrue(omayoHomePage.getHomePageTitle().endsWith("omayo (QAFox.com)"));
		  
		  assertNotEquals(omayoHomePage.getHomePageTitle(),"omayo (QAFox.com)");
		  
		  System.out.println("After assertion failure");
		  
		  assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));
		  */
		  
		  //Soft assertion
		  softAssert.assertEquals(omayoHomePage.getHomePageTitle(),"omayo (QAFox.com)");
			 
		  softAssert.assertTrue(omayoHomePage.getHomePageTitle().endsWith("omayo (QAFox.com)"));
		  
		 // softAssert.assertNotEquals(omayoHomePage.getHomePageTitle(),"omayo (QAFox.com)");
		  
		  System.out.println("After assertion failure");
		  
		  softAssert.assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));
		  //verify page url
		  softAssert.assertEquals(omayoHomePage.getHomePageUrl(), "https://omayo.blogspot.com/");
		  
		  assertEquals(omayoHomePage.getPageOneLink().getText(),"Page One");
		  
		  softAssert.assertFalse(omayoHomePage.getMaleRadioButton().isSelected());
		 
		  softAssert.assertAll();
	  }
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException {
		  if(result.getStatus()==ITestResult.FAILURE) {
			  Utility.takesSrceenshot(driver,result.getName());
		  }
		  driver.quit();
	  }
}
