package Main;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import KeywordDriven.KeywordDriven;

public class UpcomingBikes {
	public static Wait wait=new Wait();
	public static String viewMoreString = KeywordDriven.viewMoreBikes();
	public static String bikeModel = KeywordDriven.viewBikeModels();
	public static String LinkTextNewBikes=KeywordDriven.getLinkTextNewBikes();
	public static String upcomingHondaWebpage=KeywordDriven.getUpcomingHondaWebpage();
	
	public static void clickOnUpcomingBikes(WebDriver driver) throws Exception {
			    //Navigating to the New Bikes Section.
				Actions act = new Actions(driver);
				//Extracting the upcoming new bikes
				WebElement new_bikes=driver.findElement(By.linkText(LinkTextNewBikes));
				act.moveToElement(new_bikes).perform();
				//Clicking the Upcoming bikes Section
				wait.waitImplicit(driver);
				driver.findElement(By.linkText("Upcoming Bikes")).click();
	}
	public static void selectHondaModels(WebDriver driver) {
		
		wait.waitImplicit(driver);
		//Navigating to the Upcoming Honda Bikes page
		driver.navigate().to(upcomingHondaWebpage);
		wait.waitImplicit(driver);
		//Clicking View More bikes
		driver.findElement(By.xpath(viewMoreString)).click();		
	}
	public static ArrayList<String> getHondaBikesUnder4Lacs(WebDriver driver) throws Exception {
				//Storing the information of all the Upcoming Honda Bikes
				wait.waitImplicit(driver);
				String bikeModels =driver.findElement(By.xpath(bikeModel)).getText();
				
				//Storing the info in an ArrayList
				wait.waitImplicit(driver);
				ArrayList<String> bikeModelsElements = new ArrayList<String>();
				Collections.addAll(bikeModelsElements,bikeModels.split("\n"));
				
				//Sorting the information according to names,dates and prices
				ArrayList<String> NameList = new ArrayList<String>();
				ArrayList<String> DateList = new ArrayList<String>();
				ArrayList<String> PriceList =new ArrayList<String>();
				String[] arr = null;
				for(int i = 0 ; i < bikeModelsElements.size(); i++){
					String s = bikeModelsElements.get(i);
					if(s.contains("Honda")){
						NameList.add(s);
					}
					if(s.contains("Rs. ")){
						arr = s.split(" ");
						PriceList.add(arr[1]);
					}
					if(s.contains("Exp. Launch")){
						DateList.add(s);
					}
				}
				
				wait.waitImplicit(driver);
				ArrayList<String> upcomingBikes = new ArrayList<String>();
				for(int i=0; i<NameList.size();i++){
					String temp = NameList.get(i);
					double price = Double.parseDouble(PriceList.get(i));
					String info=temp+"  "+PriceList.get(i)+" Lakh  "+DateList.get(i);
					if(info.contains(temp)){
						if(Double.compare(price, 4d)<0){
							upcomingBikes.add(info);
						}
					}
				}
				
				String upcomingBikesManufacturer=KeywordDriven.getBikeManufacturerName();
				//Printing them
				System.out.println("PART 3:");
				System.out.println("Upcoming "+upcomingBikesManufacturer+" Bikes Below 4 Lakhs are as follows:");
				for(int i = 0 ; i < upcomingBikes.size(); i++){
					System.out.println(upcomingBikes.get(i));
				}
				return upcomingBikes;
				
	}
	public static ArrayList<String> findingUpcomingBikes(WebDriver driver) throws Exception{		
		clickOnUpcomingBikes(driver);
		selectHondaModels(driver);
		ArrayList<String> upcomingBikes=getHondaBikesUnder4Lacs(driver);
		return upcomingBikes;
		
	}

}
