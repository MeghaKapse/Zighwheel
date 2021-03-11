package Main;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import KeywordDriven.KeywordDriven;

public class PopularUsedCars {

	static Wait wait = new Wait(); 
	public static String linkTextUsedCars=KeywordDriven.getUsedCarsLinkText(); 
	public static String findUsedCarsButtonString= KeywordDriven.getFindUsedCars();
	public static String getChennai = KeywordDriven.getChennai();
	public static String allCars = KeywordDriven.getUsedCars();
	

	public static void findUsedCarsLinkText(WebDriver driver) {
		Actions act = new Actions(driver);
		WebElement used_cars=driver.findElement(By.linkText(linkTextUsedCars));
		act.moveToElement(used_cars).perform();
		wait.waitImplicit(driver);
		driver.findElement(By.xpath(findUsedCarsButtonString)).click();
	}

	public static void SelectLocation(WebDriver driver) {
		wait.waitImplicit(driver);
		driver.findElement(By.xpath(getChennai)).click();
	}
	
	public static ArrayList<String> printModels(WebDriver driver) throws Exception {
		
		
		String locationPopularUsedCars=KeywordDriven.getLocationName();

		wait.waitImplicit(driver);
		String models_list=driver.findElement(By.xpath(allCars)).getText();
		ArrayList<String> models=new ArrayList<String>();
		Collections.addAll(models, models_list.split("\n"));
		
	
		System.out.println("PART 2:");
		System.out.println("Popular Models of Used Cars in "+locationPopularUsedCars+" are:-");
		for(int i =0; i< models.size(); i++){
			System.out.println((i+1)+" "+models.get(i));
		}
		return models;
	}
	

	public static ArrayList<String> popularUsedCars(WebDriver driver) throws Exception{
		
		findUsedCarsLinkText(driver);
		SelectLocation(driver);
		ArrayList<String> models=printModels(driver);
		return models;
	}
}
