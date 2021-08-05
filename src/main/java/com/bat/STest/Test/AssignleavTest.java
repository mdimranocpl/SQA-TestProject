package com.bat.STest.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bat.STest.Utils.DriverManager;
import com.bat.STest.Utils.UrlTextUtils;
import com.bat.STest.Utils.XpathUtils;

public class AssignleavTest {

	private WebDriver driver = null;
	
	@Test
	public void assignleaveButtonAndPageUrlVeryfi() {
		
		driver = DriverManager.driver;
		
		//verify assignLeave Button is available or not
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModiule.assignLeaveButton)));

		//click on assign leave button
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.assignLeaveButton)).click();
		
		//assign leave page URL verify
		Assert.assertEquals(driver.getCurrentUrl(), UrlTextUtils.Url.assignLeavePageUrl);
	}

	@Test(dependsOnMethods = "assignleaveButtonAndPageUrlVeryfi")
	public void assignleaveTest() {

			System.out.println("I am executed!");

	}
}
