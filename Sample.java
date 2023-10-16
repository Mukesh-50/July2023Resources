package freelanceApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helper.Utility;

public class Sample {

	public static void main(String[] args) {

		WebDriver driver =Utility.startbrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();

	}

}
