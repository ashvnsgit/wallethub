package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {

	public WebDriver driver;
	
	By singnin=By.xpath("//*[text()='Login']");
	By title=By.xpath("//*[@class='text-center']/h2");
	

	public landingpage(WebDriver driver) {
		this.driver=driver;
	// TODO Auto-generated constructor stub
}

	public WebElement getlogin() {
		// TODO Auto-generated method stub
		 return driver.findElement(singnin);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	
	
}
