package GoogleSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import KeywordDriven.KeywordDriven;
import Main.Wait;

public class GoogleSignIn {

	public static Wait wait=new Wait();
	
	public static String GoogleURL = KeywordDriven.getGoogleURL();
	public static String signInButton = KeywordDriven.getSignInButton();
	public static String emailTextField = KeywordDriven.getEmailId();
	public static String emailNextButton = KeywordDriven.getEmailNextButton();
	public static String passwordTextField = KeywordDriven.getPassword();
	public static String passwordNextButton = KeywordDriven.getPasswordNextButton();
	public static String errorMessage= KeywordDriven.getErrorString();
	
	
	public static void googleSignIn(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get(GoogleURL);
		driver.findElement(By.xpath(signInButton)).click();
	}
	
	public static void fillLoginForm(String email,String pass,WebDriver driver) {
		driver.findElement(By.xpath(emailTextField)).sendKeys(email);
		wait.waitImplicit(driver);
		driver.findElement(By.xpath(emailNextButton)).click();
		wait.waitImplicit(driver);
		if(validateEmail(email)) {
			driver.findElement(By.xpath(passwordTextField)).sendKeys(pass);
			driver.findElement(By.xpath(passwordNextButton)).click();
		}
		else
			getErrorMessage(driver);
	}
	public static void getErrorMessage(WebDriver driver) {
		System.out.println("PART 1:");
		System.out.println("Google Sign-In Error Message");
		wait.waitImplicit(driver);
		String error_msg=driver.findElement(By.xpath(errorMessage)).getText();
		wait.waitImplicit(driver);
		System.out.println(error_msg);
	}
	
	public static boolean validateEmail(String email) {
		int atTheRatepos=email.indexOf('@');
		int dotpos=email.indexOf('.');
		if(atTheRatepos<1 || dotpos<atTheRatepos+2 || dotpos+2>=email.length()) {
			return false;
		}
		else 
			return true;
	}
	
}
