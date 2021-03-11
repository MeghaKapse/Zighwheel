package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSetup {
	public static WebDriver driver;
	
	public static WebDriver invokeDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("ChromeDriver_windowOS")) {
			String chromeDriverPath = "\\Drivers\\chromedriver.exe";
			String path=System.getProperty("user.dir");
			
			System.setProperty("WebDriver.chrome.driver", "\\C:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("FirefoxDriver_windowsOS")) {
			String firefoxDriverPath="\\Drivers\\geckodriver.exe";
			String path=System.getProperty("user.dir");
			
			System.setProperty("WebDriver.chrome.driver", "\\C:\\geckodriver.exe");
			driver=new FirefoxDriver();
		
		}
		else if(browserName.equalsIgnoreCase("OperaDriver_windowsOS")) {
			String firefoxDriverPath="\\Drivers\\operadriver.exe";
			String path=System.getProperty("user.dir");
			
			System.setProperty("WebDriver.chrome.driver", "\\C:\\operadriver.exe");
			driver =new OperaDriver();
		
	}
		
return driver;
}
}
