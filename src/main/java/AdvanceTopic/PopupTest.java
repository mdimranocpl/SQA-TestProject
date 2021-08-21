package AdvanceTopic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class PopupTest {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> iteration= windows.iterator();
		
		while (iteration.hasNext()) {
			
			String secondWindow=iteration.next();
			if(!mainWindow.equalsIgnoreCase(secondWindow)) {
				driver.switchTo().window(secondWindow);
				driver.findElement(By.name("emailid")).sendKeys("test@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
				System.out.println("Popup page has been handeled");
			}
			
			driver.switchTo().window(mainWindow);
			System.out.println("Back to main window");
			
		}
		


	}

}
