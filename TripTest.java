package TripWeb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TripTest {
	public WebDriver driver;

	@BeforeMethod
	public void setBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:/Users/audrie/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test(priority=1)
	public void giveHotelname()
	{ 
		driver.get("https://www.tripadvisor.in/");
		TripPage1 t1=new TripPage1(driver);
	
		// System.out.print("Enter Hotel name and click first one");
		t1.sendHotelName("Club Mahindra"); //and click it
	
		 //System.out.print("Scroll down to find WriteReview button");
	      t1.scrollDown();	      
	   
	    //  System.out.print("Move to new Tab");	
	      t1.clickReview();
	  
	    //  System.out.print("Enter Review Section");
	     t1.hoverbubble();
	}
	
		
	@AfterMethod
	public void exitApplication()
	{
		driver.quit();
	}

}
