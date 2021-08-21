package AdvanceTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demo.guru99.com/test/upload/");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\pc\\Desktop\\selenium-screenshort\\Screenshort.png");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/ul/li/center/span/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/ul/li/div[1]/button")).click();

	}

}
