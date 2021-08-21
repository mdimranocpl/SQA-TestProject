package AdvanceTopic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demo.guru99.com/test/yahoo.html");
		
		//when ssl cirtificate not install
//		driver.findElement(By.id("details-button")).click();
//		driver.findElement(By.id("proceed-link")).click();
		
		//***install wget software, then try***//
		
		WebElement downloadbtn= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/a"));
		String sourceurl=downloadbtn.getAttribute("href");
		
		String wgetCommand="cmd /c C:\\\\Wget\\\\wget.exe -P D: --no-check-certificate "+sourceurl;
		
		try {
			Process execution= Runtime.getRuntime().exec(wgetCommand);
			System.out.println("File downloaded.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
