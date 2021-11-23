package PageObject_WalletHub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wallethubpage {
	public WebDriver driver;
	
	public wallethubpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By logininiti=By.xpath("//*[@class='brgm-button brgm-signup brgm-signup-login']");
	private By wallletemail=By.xpath("//*[@name='em']");
	private By wallletpass=By.xpath("//*[@name='pw']");
	private By LOGIN=By.xpath("//*[@class='btns']/button[2]");
	private By InsuranseLink=By.xpath("//*[text()='Test Insurance Company']");
	private By ReviewPage=By.xpath("//*[@class=\"nav-txt\" and text()='Reviews']");
	private By forthstar=By.xpath("(//*[name()='svg'][@class='rvs-star-svg'])[14]");
	private By dropdown=By.xpath("//*[@role=\"button\"]/ancestor::ng-dropdown[@class='wrev-drp']");
	private By dropvalue=By.xpath("//*[@class='dropdown second opened']/ul/li[2]");
	private By freetext=By.xpath("//*[@class='android']/child::textarea");
	private By Submit=By.xpath("//*[text()='Submit']");
	private By profilehover=By.xpath("//*[@class='brgm-button brgm-user brgm-list-box']/span");
	private By profile=By.xpath("//*[text()='Profile']");
	
	public WebElement logininiti()
	{
		
		return driver.findElement(logininiti);
	}
	public WebElement wallletemail()
	{
		
		return driver.findElement(wallletemail);
	}
	public WebElement wallletpass()
	{
		
		return driver.findElement(wallletpass);
	}
	public WebElement LOGIN()
	{
		
		return driver.findElement(LOGIN);
	}
	public WebElement InsuranseLink()
	{
		
		return driver.findElement(InsuranseLink);
	}
	public WebElement ReviewPage()
	{
		
		return driver.findElement(ReviewPage);
	}
	public WebElement forthstar()
	{
		
		return driver.findElement(forthstar);
	}
	public WebElement dropdown()
	{
		
		return driver.findElement(dropdown);
	}
	public WebElement dropvalue()
	{
		
		return driver.findElement(dropvalue);
	}
	public WebElement freetext()
	{
		
		return driver.findElement(freetext);
	}
	public WebElement Submit()
	{
		
		return driver.findElement(Submit);
	}
	public WebElement profilehover()
	{
		
		return driver.findElement(profilehover);
	}
	public WebElement profile()
	{
		
		return driver.findElement(profile);
	}



}
