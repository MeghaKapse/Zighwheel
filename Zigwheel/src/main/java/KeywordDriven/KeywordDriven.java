package KeywordDriven;

import ExcelUtils.ExcelUtils;

public class KeywordDriven {
	public static String getInvalidEmail() throws Exception {
		
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String emailInvalid=data[0];
		return emailInvalid;
	}
	public static String getInvalidPassword() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String passwordInvalid = data[1];
		return passwordInvalid;
	}
	public static String getLocationName() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String locationPopularUsedCars = data[2];
		return locationPopularUsedCars;
	}
	public static String getBikeManufacturerName() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String upcomingBikesManufacturer=data[3];
		return upcomingBikesManufacturer;
	}
	public static String getChromeWindows() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String ChromeDriver_WindowsOS=data[4];
		return ChromeDriver_WindowsOS;
	}
	public static String getFirefoxWindows() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String FirefoxDriver_WindowsOS=data[5];
		return FirefoxDriver_WindowsOS;
	}
	public static String getOperaWindows() throws Exception {
		String[] data= ExcelUtils.readExcelData("Sheet1");
		String OperaDriver_WindowsOS=data[6];
		return OperaDriver_WindowsOS;
	}
	
	public static String getGoogleURL() {
		String GoogleURL="https://www.google.com";
		return GoogleURL;
	}
	public static String getSignInButton() {
		String signInButton="//*[@id='gb_70']";
		return signInButton;
	}
	public static String getEmailId() {
		String emailTextField="//*[@id='identifierId']";
		return emailTextField;
	}
	public static String getEmailNextButton() {
		String emailNextButton="//*[@id='identifierNext']/div/button/div[2]";
		return emailNextButton;
	}
	public static String getPassword() {
		String passwordTextField="//*[@id='password']/div[1]/div/div[1]/input";
		return passwordTextField;
	}
	public static String getPasswordNextButton() {
		String passwordNextButton="//*[@id='passwordNext']/div/button/div[2]";
		return passwordNextButton;
	}
	
	public static String getErrorString() {
		String errorMessage="//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div";
		return errorMessage;
	}
	public static String getUsedCarsLinkText() {
		 String linkTextUsedCars = "Used Cars";
		 return linkTextUsedCars;
	}
	public static String getFindUsedCars() {
		String findUsedCarsButtonString="//*[@id='headerNewNavWrap']/div[2]/ul/li[5]/ul/li/div[1]/ul/li[1]/a";
		return findUsedCarsButtonString;
	}
	public static String getChennai() {
		String chennaiString = "//*[@id='popularCityList']/li[7]/a";
		return chennaiString;
	}
	public static String getUsedCars() {
		String carString = "//body/div[11]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[4]";
		return carString;
	}
	
	//Upcoming New Bikes
	public static String getLinkTextNewBikes() {
		String LinkTextNewBikes="New Bikes";
		return LinkTextNewBikes;
	}
	public static String getUpcomingHondaWebpage() {
		String upcomingHondaWebpage="https://www.zigwheels.com/upcoming-Honda-bikes";
		return upcomingHondaWebpage;
	}
	public static String viewMoreBikes() {
		 String viewMoreString = "//*[@id='carModels']/ul/li[16]/span";
		 return viewMoreString;
	}
	public static String viewBikeModels() {
		String carModel = "//*[@id='carModels']/ul";
		return carModel;
	}

}
