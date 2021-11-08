package Academy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingpage;
import pageObjects.loginPage;
import resources.base;

public class homepage extends base{
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	
	@BeforeMethod
	public void initialize() throws Exception
	{
		driver=initializedriver();
		log.info("The Driver is initilize");
		driver.get(prop.getProperty("URL"));
		log.info("Route to Home Page");
		
	}

	@Test(dataProvider="getdata")
	public void basepagenavigation(String Username,String Password) throws Exception
	{
	
		loginPage lp=new loginPage(driver);
		lp.signinlink().click();
		lp.getemailid().sendKeys(Username);
		log.info("Usernme Provided");
		lp.getpassword().sendKeys(Password);
		log.info("Password Given");
		lp.getLogIn().click();
		log.error("User unable to login due to incorrect username and password");
		}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
//Row stand for how many different data type test should run
		//column stands for how many values per each test
		
		Object[][] data =new Object[2][2];
		
		data[0][0]="Ashish31394@gmail.com";
		data[0][1]="Ashish123344";
	    data[1][0]="NAHGSJS@gmail.com";
		data[1][1]="ABHS31231"; 
		
		
		return data;
		
		
	}
	
	
	
}
