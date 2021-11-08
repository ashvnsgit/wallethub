package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	
	public WebDriver driver;
	By singnin=By.xpath("//*[text()='Login']");
	By emailid=By.xpath("//*[@name='email']");
	By password=By.xpath("//*[@id='user_password']");
	By LogIn=By.xpath("//*[@value='Log In']");
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement signinlink()
	{
		return driver.findElement(singnin);
	}
	public WebElement getemailid()
	{
		return driver.findElement(emailid);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
		
	}

	public WebElement getLogIn()
	{
		return driver.findElement(LogIn);
		
	}
}
