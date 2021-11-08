package Academy;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.landingpage;
import pageObjects.loginPage;
import resources.base;

public class webpagetitle extends base{
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver=initializedriver();
		//driver.get("http://www.qaclickacademy.com");
		String address=prop.getProperty("URL");
		driver.get(address);
	}

	@Test()
	public void titlevalidation() throws Exception
	{
		
		landingpage l=new landingpage(driver);
		String Title=l.gettitle().getText();
		//System.out.println(Title);
		
	Assert.assertEquals(Title, "FEATURED COURSES");
	Log.info("Succesfull Validated the title");
	
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
		
	}
	
