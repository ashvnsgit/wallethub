package TestCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sun.tools.sjavac.Log;

import PageObject_WalletHub.FBLOgin;
import WalletHub.Assignment.Base;


public class TC_01_FbLogin extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());

	
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriver Driver;
	@Test(priority=1)
	public void NavigateFB() throws Exception
	{
		//test=extent.createTest("Login to Fb");
		driver=browserinitialize();
		log.info("Driver is open");
		driver.get(FbUrl);
		log.info("Fb Account Login page opened");
		FBLOgin fb= new FBLOgin(driver);
		//*-------User Is Providing Value in user name field--------*//
		fb.provideusername().sendKeys(FbUsernabme);
		log.info("User proivded username");
		//*-------User Is Providing Value in Password field--------*//
		fb.providepassword().sendKeys(FbPAss);
		log.info("User provided password");
		//*-------User Is Clicking on Login Button--------*//
		fb.loginfb().click();
		log.info("User Clicked on LoginButton");
		log.debug("Driver is waiting for home page to be loaded");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Memories']"))));
		
		
		String title=driver.getTitle();
		log.info(title);
		Assert.assertEquals("Facebook", title);
		log.info("Hello World");
		
		
	

		}
	
	
	

}
