package freelanceApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Helper.Utility;

public class AddDelCourse {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Manage')]"))).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Manage Courses']")).click();
		
		List<WebElement> noCourses=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
		
		driver.findElement(By.xpath("//button[normalize-space()='Add New Course']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("thumbnail")).sendKeys("C://Users//HP//Desktop//download.jpg");
		driver.findElement(By.name("name")).sendKeys("API Testing");
		Thread.sleep(2000);
		driver.findElement(By.id("description")).sendKeys("Postman"); 
		driver.findElement(By.name("instructorName")).sendKeys("Ritika");
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("10000");
				driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, September 30th, 2023']")).click();
		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, October 18th, 2023']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Select Category']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Automation Testing']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(2000);
		List<WebElement> updatedNoCourses=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
		
		System.out.println(updatedNoCourses.size());
		System.out.println(noCourses.size());
		if(updatedNoCourses.size()>noCourses.size())
		{
			
		System.out.println("Course successfully added");
		}
		
		else {
			System.out.println("Pls check again , course is not added");
		}
		
		int rowCount=updatedNoCourses.size();
		
	
		
		WebElement deleteBtn=driver.findElement(By.xpath("(//button[contains(text(),'Delete')])[last()]"));
		
		deleteBtn.click();
		Thread.sleep(2000);
		updatedNoCourses=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
		
		if(updatedNoCourses.size()==noCourses.size())
		{
			
		System.out.println("Course successfully Deleted");
		}
		
		else {
			System.out.println("Pls check again , course is not Deleted");
		}
	}

	
}
