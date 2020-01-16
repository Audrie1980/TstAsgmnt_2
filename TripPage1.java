package TripWeb;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripPage1 {
WebDriver driver;

//WebElement signOut= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li._54ni navSubmenu _6398 _64kz __MenuItem") ));
    By srchbtn=By.cssSelector("span.ui_icon.search.brand-global-nav-action-search-Search__icon--2DVjd");
	By srchbox=By.id("mainSearch");
	By frst_elmnt_li= By.cssSelector("ul.resultContainer.local>li:first-of-type");
    By writeReview= By.cssSelector(".ui_button.primary");
    By checkmark=By.cssSelector("div.question.rating.bigRating.labelAndInput.required.complete");
   // By bubble=By.xpath("//span[@id='bubble_rating']");
    By bubble=By.xpath("//span[@class='ui_bubble_rating.fl.bubble_50']");
    By titRev=By.name("ReviewTitle");
    By txtRev=By.name("ReviewText");
    
	TripPage1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void sendHotelName(String name) 
	{  
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		WebElement src=driver.findElement(srchbtn); //enter hotel name
		js.executeScript("arguments[0].click();", src);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
		
		wait.until(ExpectedConditions.elementToBeClickable(srchbox));
		driver.findElement(srchbox).sendKeys(name);
		wait1.until(ExpectedConditions.elementToBeClickable(frst_elmnt_li)); //click first hotel
		driver.findElement(frst_elmnt_li).click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
		
  	}
	
	public void scrollDown()
					{ try {
						Thread.sleep(3000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
		e.printStackTrace();}
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,3720)", "");
		//System.out.println("Scroll suceesss");
	}
	
	public void clickReview() {
	
		driver.findElement(writeReview).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	   	
	}
	
	public void hoverbubble()
	{ try {
		Thread.sleep(3000);
	} catch (InterruptedException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();}
		
	  Actions action= new Actions(driver);
		action.moveToElement((WebElement) bubble).perform();
		driver.findElement(titRev).sendKeys("My title");
		driver.findElement(txtRev).sendKeys("My Text");
		
	}


}
