package com.bat.STest.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bat.STest.DTO.LoginDTO;
import com.bat.STest.DataProvider.LoginDataProvider;
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

	@Test(dependsOnMethods = "loginTestTitleVerify",dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void logintest(List<LoginDTO> logindata) {
		for(LoginDTO login:logindata) {
			
			driver.findElement(By.name(XpathUtils.LoginModiule.admin)).sendKeys(login.getUsername());
			driver.findElement(By.xpath(XpathUtils.LoginModiule.password)).sendKeys(login.getPassword());
			driver.findElement(By.id(XpathUtils.LoginModiule.submit)).click();
		}
	}
}
