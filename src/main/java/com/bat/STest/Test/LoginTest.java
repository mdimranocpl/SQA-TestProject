package com.bat.STest.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bat.STest.Utils.DriverManager;
import com.bat.STest.Utils.UrlTextUtils;
import com.bat.STest.Utils.XpathUtils;

public class LoginTest {

	private WebDriver driver = null;
	
	@Test
	public void loginTestTitleVerify() {
		
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.Url.baseUrl);
		
		//home page title verify
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.Text.homePageTitle);
	}

	@Test(dependsOnMethods = "loginTestTitleVerify")
	public void logintest() {
		driver.findElement(By.name(XpathUtils.LoginModiule.admin)).sendKeys("Admin");
		driver.findElement(By.xpath(XpathUtils.LoginModiule.password)).sendKeys("admin123");
		driver.findElement(By.id(XpathUtils.LoginModiule.submit)).click();
	}
}
