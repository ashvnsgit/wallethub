package PageObject_WalletHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBLOgin {
	
	public WebDriver driver;
	
	public FBLOgin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By Username=By.xpath("//*[@id=\"email\"]");
	private By password=By.xpath("//*[@id=\"pass\"]");
	private By loginbuttn=By.xpath("//*[@name=\"login\"]");
	
	public WebElement provideusername()
	{
		return driver.findElement(Username);
	}
	public WebElement providepassword()
	{
		return driver.findElement(password);
	}
	public WebElement loginfb()
	{
		return driver.findElement(loginbuttn);
	}

}
