package Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Wait {
public static WebDriver driver;
	
	public void waitImplicit(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

}
