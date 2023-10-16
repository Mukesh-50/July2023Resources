package freelanceApp;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Helper.Utility;

public class AddCourse {
	@Parameters("Browser")
@Test
	public void addCourse()
	{
		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		Utility.waitForElement(driver.findElement(By.xpath("(//button[@class='cartBtn'])")), 5);
		
		//Fetch the no of courses Displayed
		
		List <WebElement> noCourses=driver.findElements(By.xpath("//div[@class='course-card row']"));
		int size_noCourses=noCourses.size();
		Assert.assertNotEquals(size_noCourses, 0);
		
		//Fetch the Price of the courses
		
		List<WebElement>prices = driver.findElements(By.xpath("//span[@id='cardChip']//b"));
				
		System.out.println("Prices of both courses are as following (Integer):");
		
		int courseCountPrice=0;
		for (int i=0;i<prices.size();i++)
		{
			int intPrice=Integer.parseInt(prices.get(i).getText().substring(1));
			System.out.println(intPrice);
			//finding sum of course 1 an course 2
			courseCountPrice=courseCountPrice+Integer.parseInt(prices.get(i).getText().substring(1));


	}
		
		//Click on add to cart for course 1 and course 2
		
				List<WebElement>addToCart = driver.findElements(By.xpath("//button[normalize-space()='Add to Cart']"));
				
				
				for (int i=0;i<addToCart.size();i++)
				{
					addToCart.get(i).click();
					
				}				

		   //  Verify cart count should be 2
				
				driver.findElement(By.xpath("//button[@class='cartBtn']")).click();
				String cartCourseCount=driver.findElement(By.xpath("//span[@class='count']")).getText();
				int count = Integer.parseInt(cartCourseCount);
			  Assert.assertEquals(count, 2);

			

		// Verify total price should be sum of course 1 price and course 2 price
				String totalPriceString=driver.findElement(By.xpath("//h3[contains(text(),'Total Price:')]")).getText();
				int totalPriceint=Integer.parseInt(totalPriceString.substring(14));
				System.out.println(totalPriceint);
				Assert.assertEquals(totalPriceint,courseCountPrice);
	//Click enroll now
				
				driver.findElement(By.xpath("//button[normalize-space()='Enroll Now']")).click();					
							
 //   Enter address and number and click on Buy
				
				driver.findElement(By.xpath("//div//textarea[@name='address']")).sendKeys("Chandigarh");
				
				driver.findElement(By.xpath("//div//input[@id='phone']")).sendKeys("9915737075");
				
				
				
				WebElement enrollNow=driver.findElement(By.xpath("//button[@class='action-btn']"));
				
				if(enrollNow.isEnabled()&&enrollNow.isDisplayed())
				{
					enrollNow.click();
				}
				else
				{
					System.out.println("Enroll Now not enabled, not displayed");
				}
			

		  // Verify order id should not null
				
				String orderId=driver.findElement(By.xpath("//div//h4[@class='uniqueId']//b")).getText();
				
				Assert.assertNotEquals(orderId, null);
						     
					
				driver.close();

}}

