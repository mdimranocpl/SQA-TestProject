package com.bat.STest.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.STest.Utils.DriverManager;
import com.bat.STest.Utils.TestNGReporting;
import com.bat.STest.Utils.UrlTextUtils;
import com.bat.STest.Utils.XpathUtils;

@Listeners(TestNGReporting.class)
public class AssignleavTest {

	private WebDriver driver = null;

	@Test
	public void assignleaveButtonAndPageUrlVeryfi() {

		driver = DriverManager.driver;

		// verify assignLeave Button is available or not
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModiule.assignLeaveButton)));
		

		// click on assign leave button
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.assignLeaveButton)).click();

		// assign leave page URL verify
		Assert.assertEquals(driver.getCurrentUrl(), UrlTextUtils.Url.assignLeavePageUrl);
		
	}


	@Test(dependsOnMethods = "assignleaveButtonAndPageUrlVeryfi")
	public void assignleaveTest() {

		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.employee_name)).sendKeys("David Morris");

		// driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.leave_type)).click();
		Select leave_type = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.leave_type)));
		leave_type.selectByVisibleText("US - Personal");
		
		//form date
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date)).clear();
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date)).sendKeys("2021-02-05");
		
		//to date
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.to_date)).clear();
		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.to_date)).sendKeys("2021-08-01");

	
		
		// form date part start
				//driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date)).click();
						// year
						//driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date_year)).click();
						//Select from_date_year = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date_year)));
						//from_date_year.selectByVisibleText("2021");

						// month
						//driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date_month)).click();
						//Select from_date_month = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.from_date_month)));
						//from_date_month.selectByVisibleText("Jun");
						
						//day
//						WebElement dateWidget = driver.findElement(By.xpath("ui-datepicker-calendar"));
//						List<WebElement> all_day_form_date = (List<WebElement>) dateWidget.findElement(By.tagName("td"));
//						
//						for(WebElement day_form_date: all_day_form_date) {
//							
//							if(day_form_date.getText().equals("30")) {
//								day_form_date.findElement(By.linkText("30")).click();
//								break;
//							}
//						}
						
				//form date part end
		
				
				
		
		//to date part start

		
		//to date part end
		

		Select duration = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.duration)));
		duration.selectByVisibleText("Full Day");

		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.comment)).sendKeys("No");

		driver.findElement(By.xpath(XpathUtils.AssignLeaveModiule.assign_button)).click();
		

	}
}
