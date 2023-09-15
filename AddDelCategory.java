package freelanceApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Helper.Utility;
import Seleniumday1.webelementscommand;

public class AddDelCategory {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
    // Storing parent window handle
		String parentHandle=driver.getWindowHandle();
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Manage')]"))).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Manage Categories')]")).click();
	
		//Storing all window handles
		Set<String>allHandles=driver.getWindowHandles();
	List<String> allWindowsInList = new ArrayList<String>(allHandles);


		//Switching to child handle
		
		driver.switchTo().window(allWindowsInList.get(1));
		
		List<WebElement> noCategory=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//button[@class='action-btn delete-btn']"));
	System.out.println(noCategory.size());
				
driver.findElement(By.xpath("//div[@class='manage-btns']//button[contains(normalize-space(),'Add New Category')]")).click();

		Thread.sleep(3000);
		
		Alert alt=driver.switchTo().alert();
		
		alt.sendKeys("API");
		
		alt.accept();
		Thread.sleep(5000);
		List<WebElement> UpdatednoCategory=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//button[@class='action-btn delete-btn']"));
		System.out.println(UpdatednoCategory.size());
		
		if(UpdatednoCategory.size()>noCategory.size())
		{
			
			System.out.println("category Added");
		}
		else
		{
			System.out.println("Category not added");
		}
		
		Thread.sleep(2000);
List<WebElement> element = 	driver.findElements(By.xpath("(//button[contains(text(),'Delete')])"));

   WebElement ele = element.get((element.size()-1));

   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].scrollIntoView();", ele);
   Thread.sleep(2000);
   ele.click();
   Thread.sleep(2000);
  Alert delAlt= driver.switchTo().alert();
 
  delAlt.accept();
   
	UpdatednoCategory=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
	
	
	
	if(UpdatednoCategory.size()<noCategory.size())
	{
		
	System.out.println("Category successfully Deleted");
	}
	
	else {
		System.out.println("Pls check again , category is not Deleted");
	}
	
	}

}
