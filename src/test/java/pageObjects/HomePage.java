package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText="My Account")
	WebElement myaccount;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	public void clickMyAccount()
	{
		myaccount.click();
	}
		
	public void clickLogin()
	{
		login.click();
	}
	
	
	
	
	
	

}
