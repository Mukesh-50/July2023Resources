package freelanceApp;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Helper.Utility;

public class AddDelCategory {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Manage')]"))).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Manage Categories')]")).click();
		
		List<WebElement> noCategory=driver.findElements(By.xpath("//table[@class='courses-table table table-borderless']//input"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(normalize-space(),'Add New Category')]")).click();
		Thread.sleep(3000);
		
		Alert alt=driver.switchTo().alert();
		
		alt.sendKeys("API");
		
		alt.accept();
		
		
	}

}
