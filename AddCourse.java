package freelanceApp;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helper.Utility;

public class AddCourse {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		Utility.waitForElement(driver.findElement(By.xpath("(//button[@class='cartBtn'])")), 5);
		
		//Fetch the no of courses Displayed
		
		List <WebElement> noCourses=driver.findElements(By.xpath("//div[@class='course-card row']"));
		if(noCourses.size()>0) {
			System.out.println("LOG:INFO - Validation 1 Passed:: No Of courses are:: "+noCourses.size());
			
		}else
		{
			System.out.println("LOG:INFO - Courses Not listed :: Validation 1 Failed ");
		}
		
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
				if(count==2)
				{
					System.out.println("Cart has 2 items");
				}
				else
				{
					System.out.println("Cart does not have 2 items, check again!");
				}
				

				//Click enroll now
				
				driver.findElement(By.xpath("//button[normalize-space()='Enroll Now']")).click();

		// Verify total price should be sum of course 1 price and course 2 price
				String totalPriceString=driver.findElement(By.xpath("//h3[contains(text(),'Total Price:')]")).getText();
				int totalPriceint=Integer.parseInt(totalPriceString.substring(14));
				System.out.println(totalPriceint);
				
				
							
				if (totalPriceint==courseCountPrice)	
				{
					System.out.println("Total price from cart is equal to sum of course 1 price and course 2 price");
				}
				else
				{
					System.out.println("Total price from cart is not equal to sum of course 1 price and course 2 price");
				}
				
		 //   Enter address and number and click on Buy
				
				driver.findElement(By.xpath("//div//textarea[@name='thumbnail']")).sendKeys("Chandigarh");
				
				driver.findElement(By.xpath("//div//input[@id='name']")).sendKeys("9915737075");
				
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
				if(orderId==null)
				{
					System.out.println("Order Id is null, you have not been enrolled");
				}
				  // 10- Print order id on console
				else
				{
					System.out.println("You are enrolled , your order id is "+orderId);
				}
			     
					
				driver.close();

}}

