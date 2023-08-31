package travelapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

public class LoginToApp {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get("https://travel.agileway.net/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String tittle = driver.getTitle();
		System.out.println("Tittle is "+tittle); // capturing the tittle
		
		boolean check = tittle.contains("Travel");
		 System.out.println("Tittle contains travel :"+ check); // to check if tittle contains Travel
		
		String urlstr = driver.getCurrentUrl();
		
		System.out.println("Current Url is= "+urlstr); // capturing the url
		
		if(urlstr.endsWith("login"))
		{
			System.out.println("Yes , url ends with Login"); // to check if url endswith login
		}
		
		 driver.findElement(By.name("commit")).click(); // locating sign in button
		 
		 String loginerr_str = driver.findElement(By.xpath("//div[contains(text(),'Invalid email or password')]")).getText();
		 
		 if(loginerr_str.contains("Invalid email or password")) // condition to check if login without credentials
		 {
			 System.out.println("Login without credentials- Test pass");
		 }
		
		driver.findElement(By.id("username")).sendKeys("agileway"); // entering username
		
		
		driver.findElement(By.id("password")).sendKeys("testwise"); // entering password
		
boolean rememberme_status=driver.findElement(By.name("remember_me")).isEnabled();

System.out.println("Rememeber is enabled"+rememberme_status);

		 driver.findElement(By.name("commit")).click() ;

		 
		 String loginmsg_str = driver.findElement(By.xpath("//div[contains(text(),'Signed in!')]")).getText(); // Capturing sign in successful text
		 
		 if(loginmsg_str.contains("Signed in"))
		 {
			 System.out.println("Login Successful");
		 }
				
		 
		// Booking for trip type one way
		 
		 driver.findElement(By.xpath("//input[contains(@value,'oneway')]")).click();
		 
		 Select origin = new Select (driver.findElement(By.xpath("//select[@name='fromPort']")));
		 origin.selectByVisibleText("San Francisco");
		 
		 Select departure = new Select (driver.findElement(By.xpath("//select[@name='toPort']")));
		 departure.selectByVisibleText("New York");
		 
		 Select departdate = new Select(driver.findElement(By.id("departDay")));
		 departdate.selectByIndex(6);
		 
		 Select departmonth = new Select(driver.findElement(By.id("departMonth")));
		 departmonth.selectByVisibleText("August 2023");
		 
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click(); // selecting  flight
		 
		 driver.findElement(By.xpath("//input[@value='Continue']")).click(); 
		 
		 driver.findElement(By.name("passengerFirstName")).sendKeys("Ritika");
		 driver.findElement(By.name("passengerLastName")).sendKeys("Sharma");
		 
		 driver.findElement(By.xpath("//input[@value='Next']")).click();
		 
		 driver.findElement(By.xpath("//input[@value='visa']")).click();
		 

		 driver.findElement(By.name("card_number")).sendKeys("4539147480881557");
		 
	Select expirymonth = new Select(driver.findElement(By.name("expiry_month")));
	expirymonth.selectByIndex(11);
	Select expiryyear = new Select(driver.findElement(By.name("expiry_year")));
	expiryyear.selectByValue("2025");
	
	driver.findElement(By.xpath("//input[@value='Pay now']")).click();
	
String bookingstatus=driver.findElement(By.xpath("//div[@id='confirmation']//h2")).getText();
if(bookingstatus.contains("Confirmation"))
	
{
	System.out.println("Booking successfully done");
}
	}

}
