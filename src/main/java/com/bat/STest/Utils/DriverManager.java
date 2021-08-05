package com.bat.STest.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverManager {

	static {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
	}

	public static WebDriver driver = new ChromeDriver();

	DriverManager() {

	}
}
