package AdvanceTopic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesReadWrite {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Work\\Office\\OCPL\\Learning\\Selenuim\\Selenium WebDriver\\tools\\browser driver 64 bit\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		
		//file write
		File mycookiesFile=new File("C:\\Users\\pc\\Desktop\\cookies\\cookiesinfo.txt");
		
		try {
			
			mycookiesFile.delete();
			mycookiesFile.createNewFile();
			
			FileWriter filewriter =new FileWriter(mycookiesFile);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			
			for(Cookie cookies : driver.manage().getCookies()) {
				bufferwriter.write(cookies.getName()+ ";" + cookies.getValue()+ ";" + cookies.getDomain()+ ";" + 
						cookies.getPath()+ ";" +cookies.getExpiry()+ ";" + cookies.isSecure()+ ";" +cookies.getClass());
				
				bufferwriter.newLine();
			}
			
			bufferwriter.close();
			filewriter.close();
			System.out.println("Cookies Write Operation Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//file read
		File myfilereader=new File("C:\\Users\\pc\\Desktop\\cookies\\cookiesinfo.txt");
		
		try {
			
			FileReader fileReader=new FileReader(myfilereader);
			BufferedReader bufferReader=new BufferedReader(fileReader);
			
			String strline=bufferReader.readLine();
			
			while(strline !=null) {
				
				StringTokenizer token=new StringTokenizer(strline,";");
				while (token.hasMoreTokens()) {
					String name= token.nextToken();
					String value= token.nextToken();
					String domain= token.nextToken();
					String path= token.nextToken();
					Date expiry=null;
					
					String val;
					if(!(val=token.nextToken()).equals("null")) {
						
						String desiredDate="Sun Aug 21 23:59:59 IST 2021";
						DateFormat df=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
						expiry=df.parse(desiredDate);
					}
					Boolean isSecure=new Boolean(token.nextToken()).booleanValue();
					Cookie newcookie=new Cookie(name, value, domain, path, expiry, isSecure);
					System.out.println(newcookie);
					driver.manage().addCookie(newcookie);
					driver.manage().getCookies();
					System.out.println("Cookies Read Operation Done");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		
	}

}
