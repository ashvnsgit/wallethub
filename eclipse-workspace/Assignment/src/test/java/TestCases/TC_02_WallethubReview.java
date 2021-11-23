package TestCases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject_WalletHub.wallethubpage;
import WalletHub.Assignment.Base;

public class TC_02_WallethubReview extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());

	WebDriver driver;
	wallethubpage nav;
	
	@Test(priority=1)
	public void naviagteurl() throws Exception
	{
		driver=browserinitialize();
		driver.manage().deleteAllCookies();
		log.info("Browswer is opening");
		driver.get(WalleUrl);
		log.info("WalletHub Url opened");
	    nav=new wallethubpage(driver);
		nav.logininiti().click();
		nav.wallletemail().sendKeys(Username);
		log.info("User name provided");
		nav.wallletpass().sendKeys(password);
		log.info("Password entered");
		nav.LOGIN().click();
		log.info("User clicked on login button");
		WebElement link=nav.InsuranseLink();
		try{
			nav.InsuranseLink().click();
		}
		catch(StaleElementReferenceException e)
		{
			link.click();
		}
		
		}
	@Test(priority=2)
	public void ReviewPage() throws Exception
	{
		
		WebElement star=nav.forthstar();
		nav.ReviewPage().click();
		Actions action=new Actions(driver);
		action.moveToElement(star).perform();
		Thread.sleep(3000);
		
		log.info("Clicked on fourth star");
		
		star.click();
		nav.dropdown().click();
		WebElement dropdownvalues=nav.dropvalue();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(dropdownvalues));
		dropdownvalues.click();
		//
		log.info("User provided value in free text fields");
		nav.freetext().sendKeys(TextField);
		nav.Submit().click();
		log.info("clicked on submit button");
		//WebElement  mousehover=driver.findElement(By.cssSelector("div[class='brgm-button brgm-user brgm-list-box'] span[class='brgm-list-title']"));
				
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1/span[contains(text(),'Your')]/a[contains(text(),'has been posted')]"))));
		
		//navigating to profile page to see if posted review exist
		driver.navigate().to(Reviewwallet);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains(bodyText), "Review is not showing in profile/review page, Failing Test!");
		log.info("Posted review is showing in profile/review page, Passing Test!");
		
}
	

}
