package com.tests;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import DriverSetup.DriverSetup;
import GoogleSignIn.GoogleSignIn;
import KeywordDriven.KeywordDriven;
import Main.PopularUsedCars;
import Main.UpcomingBikes;
import Main.Wait;
import Main.WritingExcelFile;
import Main.WritingPropertiesFile;

public class TestNG {
	public static WebDriver driver;
	public static String Url= "https://www.zigwheels.com";
	public static Scanner sc=new Scanner(System.in);
	public static Wait wait = new Wait();
	
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest test;
	@Test
	public static void getDriver() throws Exception {
		
		test = report.createTest("Identify New Bikes");
		test.log(Status.INFO, "Opening the Browser");
		
    	//Browser Choices
		
    	String ChromeDriver_WindowsOS=KeywordDriven.getChromeWindows();
		@SuppressWarnings("unused")
		String FirefoxDriver_WindowsOS=KeywordDriven.getFirefoxWindows();
	
	
		
		//Enter your browser choice in between the inverted Commas
		driver=DriverSetup.invokeDriver(ChromeDriver_WindowsOS);
		test.log(Status.PASS, "\\lib\\chromedriver.exe");
	}


	
	@Test(dependsOnMethods = "getDriver")	
	public static void getGoogleSignIn() throws Exception {
		test.log(Status.INFO, "Opening the Google Sign-in Form");
		
		GoogleSignIn.googleSignIn(driver);
		
		String emailInvalid=KeywordDriven.getInvalidEmail();
		String passwordInvalid=KeywordDriven.getInvalidPassword();
		
	
		GoogleSignIn.fillLoginForm(emailInvalid,passwordInvalid, driver);
		test.log(Status.PASS, "Error Message Captured");
		
	
		test.log(Status.INFO, "Opening the Site : Zigwheels.com");
		driver.manage().window().maximize();
		driver.get(Url);
		driver.navigate().to(Url);
		test.log(Status.PASS, "Zigwheels.com opened successfully");
	}
	
	@Test(dependsOnMethods = "getGoogleSignIn")
	public static void getPopularUsedCars() throws Exception {
		test.log(Status.INFO, "Getting popular used cars in Chennai");
		ArrayList<String> cars = PopularUsedCars.popularUsedCars(driver);
		//Writing them in a file
		WritingPropertiesFile.writingfile(cars, "Used-Cars");
		test.log(Status.PASS, "Popular Used Cars Successful");
	}
	@Test(dependsOnMethods = "getPopularUsedCars")
	public static void getUpcomingBikes() throws Exception {
		test.log(Status.INFO, "Getting upcoming Honda Bikes");
		ArrayList<String> bikes = UpcomingBikes.findingUpcomingBikes(driver);
		//Writing them
		WritingExcelFile.writeExcel(bikes);
		test.log(Status.PASS, "Upcoming Bikes Successful");
		
		
	}
	
	
	@Test(dependsOnMethods = "getUpcomingBikes")
	public static void closeApplication(){
		
		test.log(Status.INFO, "Closing the browser");
		driver.close();
		driver.quit();
		report.flush();
		test.log(Status.PASS, "Closed browser successfully");
	}
}
