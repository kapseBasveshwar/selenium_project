package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OmayoCreateBlogPage {
	//Create Blog page related locators
		WebDriver driver;
		WebElement CreateBlogLink;
		public OmayoCreateBlogPage(WebDriver driver) {
			this.driver =driver;
			
		}
		public WebElement getCreateBlogLink() {
			setCreateBlogLink();
			return CreateBlogLink;
		}
		public void setCreateBlogLink() {
			CreateBlogLink = driver.findElement(By.xpath("//a[text()='Create your blog']"));
		}
}
