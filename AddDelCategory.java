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
		
		//Mouse Hover using Actions Class
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Manage')]"))).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Manage Categories')]")).click();
	
		//Storing all window handles
		Set<String>allHandles=driver.getWindowHandles();
	    List<String> allWindowsInList = new ArrayList<String>(allHandles);


		//Switching to child handle
		
		driver.switchTo().window(allWindowsInList.get(1));
		
		//Storing number of categories
		List<WebElement> noCategory=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//button[@class='action-btn delete-btn']"));
	    System.out.println(noCategory.size()); // printing the number of categories
				
	    //Adding new category
	    driver.findElement(By.xpath("//div[@class='manage-btns']//button[contains(normalize-space(),'Add New Category')]")).click();

		Thread.sleep(3000);
		
		// handling alert 
		Alert alt=driver.switchTo().alert();
		
		alt.sendKeys("API");
		
		alt.accept(); // accepting alert
		Thread.sleep(5000);
		
		//Storing new category count after adding one.
		List<WebElement> UpdatednoCategory=driver.findElements(By.xpath("//table[@class='category-table table table-borderless']//button[@class='action-btn delete-btn']"));
		System.out.println(UpdatednoCategory.size()); // printing the updated category count
		
		// condition to validate if category is added
		if(UpdatednoCategory.size()>noCategory.size())
		{
			
			System.out.println("category Added");
		}
		else
		{
			System.out.println("Category not added");
		}
		
		Thread.sleep(2000);
		
		// finding all delete buttons in the category table and selecting the last added to delete
     List<WebElement> element = 	driver.findElements(By.xpath("//button[@class='action-btn delete-btn'][normalize-space()='Delete']"));

      WebElement ele = element.get((element.size()-1));

     JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView();", ele);
   Thread.sleep(2000);
   ele.click();
   Thread.sleep(2000);
   
   // validate to delete
    driver.findElement(By.xpath("//button[@class='action-btn'][normalize-space()='Delete']")).click();
   
	UpdatednoCategory=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
	
	
	//Validation to check if category is deleted
	if(UpdatednoCategory.size()<noCategory.size())
	{
		
	System.out.println("Category successfully Deleted");
	}
	
	else {
		System.out.println("Pls check again , category is not Deleted");
	}
	
	}

}
