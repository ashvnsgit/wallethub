package resources;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializedriver() throws Exception
	{
		//need to run for all type of browser i.e chrome,IE,firefox
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=System.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			//execute in chrome
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			
			driver=new ChromeDriver(options);
		}
		else if (browserName.equals("firefox"))
		{
			//execute in firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\Documents\\chromedriver\\chromedriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Hp\\Documents\\chromedriver\\chromedriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	
	
		
	
	}
	
	public String takescreenshot(String testcasename,WebDriver driver) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String Destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(Destinationfile));
		return Destinationfile;
	
		
	}

}
