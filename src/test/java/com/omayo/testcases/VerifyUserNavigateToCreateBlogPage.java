package com.omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoCreateBlogPage;
import com.omayo.pages.OmayoHomePage;

public class VerifyUserNavigateToCreateBlogPage {
	 WebDriver driver;
		OmayoHomePage omayoHomePage;
		OmayoCreateBlogPage omayoCreateBlogPage;
	  @BeforeMethod
	  public void setup() throws IOException {
			this.driver=Utility.getWebDriver();
			driver.get(Utility.getProperty("url"));
			driver.manage().window().maximize();
			omayoHomePage=new OmayoHomePage(driver);
			 omayoCreateBlogPage= new OmayoCreateBlogPage(driver);
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		}
	  @Test
	  public void verifyUserAbleToSelectOptionsFromDropdown() {
		  Utility.switchToFrame(driver,omayoHomePage.getFrame1());
		  omayoHomePage.getCreateBlog().click();
		  Utility.switchBackToDefaultContent(driver);
		  Utility.waitForElementToBeAvailble(driver, 60, "//a[text()='Create your blog']");
		  omayoCreateBlogPage.getCreateBlogLink().click();
	  }
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
}
	  }
