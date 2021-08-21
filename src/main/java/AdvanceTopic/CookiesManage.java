package AdvanceTopic;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesManage {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://ajkerdeal.com/");
		
		//capture all cookies in web application
		Set<Cookie> cookies= driver.manage().getCookies();
		
		//Getting total size of the cookies
		System.out.println("Size:"+cookies.size());
		
		//Getting information of each cookies
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName()+"="+cookie.getValue());
		}
		
		//Getting a spechefic cookie information
		//System.out.println(driver.manage().getCookieNamed("").getValue());
		
		//Adding new cookies
		Cookie newcookie=new Cookie("testcookie", "cookieValu123");
		driver.manage().addCookie(newcookie);
		cookies= driver.manage().getCookies();
		System.out.println("Size:"+cookies.size());
		
		//Deleting cookie
		driver.manage().deleteCookie(newcookie);
		cookies= driver.manage().getCookies();
		System.out.println("Size:"+cookies.size());
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		cookies= driver.manage().getCookies();
		System.out.println("Size:"+cookies.size());
		
		
		
		

	}

}
