package AdvanceTopic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("53920");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		
		//Switch to alert
		Alert alert = driver.switchTo().alert();
		
		//Take action
		alert.accept();
		//alert.dismiss();
		
		//Verify message
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
		
		//To send some data to alert box
		//driver.switchTo().alert().sendKeys("TestText");

	}

}
