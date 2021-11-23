package WalletHub.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {

public WebDriver driver;
	public Properties prop;
	public String WalleUrl,Username,password,TextField,FbUrl,FbUsernabme,FbPAss,Reviewwallet;
	
	public WebDriver browserinitialize() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\DataProperties\\data.properties");
		prop.load(fis);
		String browser=prop.getProperty("Browser");
		 WalleUrl=prop.getProperty("WalletUrl");
		 Username=prop.getProperty("UserWallet");
		 password=prop.getProperty("PassWallet");
		 TextField=prop.getProperty("TextField");
		 FbUrl=prop.getProperty("url");
		 FbUsernabme=prop.getProperty("Username");
		 FbPAss=prop.getProperty("Password");
		 Reviewwallet=prop.getProperty("Reviewwallet");
		
		
		System.out.println(browser);
		if(browser.equals("Chrome"))
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notification");
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\DataProperties\\chromedriver_latest.exe");
			driver=new ChromeDriver(option);
			
		}
		if(browser.equals("FireFox"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\DataProperties\\chromedriver.exe");
			//driver=new ChromeDriver();
			System.out.println("Firefox browser opening");
		}
		if(browser.equals("IE"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\DataProperties\\chromedriver.exe");
			//driver=new ChromeDriver();
			System.out.println("IE browser opening");
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
	}
	
	public String  takescreenshot(WebDriver driver,String Testcasename) throws IOException
	{
		//TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("user.dir")+"\\Screenshot\\"+Testcasename+".png";
		FileUtils.copyFile(srcfile, new File(Destination));
		return Destination;
		
		}

	
	@AfterSuite
	public void teardown()
	{
		//driver.quit();
	}
}
