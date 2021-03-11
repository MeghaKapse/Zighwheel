package Main;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;


import DriverSetup.DriverSetup;
import GoogleSignIn.GoogleSignIn;
import KeywordDriven.KeywordDriven;

public class Main {
	public static String Url= "https://www.zigwheels.com";
	public static Scanner sc=new Scanner(System.in);
	public static Wait wait = new Wait();
	public static WebDriver driver;
	
	 public static void getDriver() throws Exception {

	    	
			String ChromeDriver_WindowsOS=KeywordDriven.getChromeWindows();
			String FirefoxDriver_WindowsOS=KeywordDriven.getFirefoxWindows();
			String OperaDriver_WindowsOS=KeywordDriven.getOperaWindows();
			
		
			driver=DriverSetup.invokeDriver(ChromeDriver_WindowsOS);
	    }
	 public static void navigation(WebDriver driver){
			driver.manage().window().maximize();
			driver.get(Url);
			driver.navigate().to(Url);
		}
	 public static void getGoogleSignIn() throws Exception {
			
			GoogleSignIn.googleSignIn(driver);
			
			
			String emailInvalid=KeywordDriven.getInvalidEmail();
			String passwordInvalid=KeywordDriven.getInvalidPassword();
			
					
			GoogleSignIn.fillLoginForm(emailInvalid,passwordInvalid, driver);
			
		}
	 public static void getPopularUsedCars() throws Exception {
			ArrayList<String> cars = PopularUsedCars.popularUsedCars(driver);
			
			WritingPropertiesFile.writingfile(cars, "Used-Cars");
		}
		
		public static void getUpcomingBikes() throws Exception {
			ArrayList<String> bikes = UpcomingBikes.findingUpcomingBikes(driver);
			//Writing them
			WritingExcelFile.writeExcel(bikes);
		}
		//Closing the Driver
		public static void closeApplication(WebDriver driver){
			driver.close();
			driver.quit();
		}
		
		public static void main(String[] args) throws Exception{
	
		    getDriver();
			
		    
			getGoogleSignIn();
		
			navigation(driver);
			
			
			getPopularUsedCars();
						
			
			getUpcomingBikes();
			
			
			closeApplication(driver);
	     } 
	
}
