package com.bat.STest.Utils;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGReporting implements ITestListener {

	private WebDriver driver = null;

	public void onStart(ITestContext result) {
		System.out.println("-------------------------------------------------");
		System.out.println("Test execution has been started : " + result.getName());
		System.out.println("-------------------------------------------------");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test has been started : " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has been successfull : " + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test has been started : " + result.getName());
		
		//for screenshot
		driver=DriverManager.driver;
		Random random = new Random();  
		int filenum = random.nextInt(1000); 
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desfile=new File("C:\\Users\\pc\\Desktop\\selenium-screenshort\\SeleniumScreenshort"+filenum+".png");
		try {
		FileHandler.copy(srcfile,desfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot of failed page has been taken");
		//for screenshot
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has been skipped : " + result.getName());
	}
	
	public void onFinish(ITestContext result) {
		System.out.println("-------------------------------------------------");
		System.out.println("Test execution has been finished : " + result.getName());
		System.out.println("-------------------------------------------------");
	}

}
