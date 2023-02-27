package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{

	public AccountCreatedPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement text;
	
//	@FindBy(linkText="Logout")
//	WebElement logout;

	public boolean verifyAccountCreatedMessage()
	{
		text.isDisplayed();
		try
		{
		return text.isDisplayed();
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	
	/*
	 * public void clickLogout() { logout.click(); }
	 */
}
