package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div/h2[1]")
	WebElement myAccountLabel;

	@FindBy(linkText="Logout")
	WebElement logOutlink;
	
	public boolean visibilityOf_myAccountLabel()
	{
		try {
		return(myAccountLabel.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogOutLin()
	{
		logOutlink.click();
	}
	
	public boolean visibility_Of_logout()
	{
		//logOutlink.isDisplayed();
		try
		{
		 logOutlink.isDisplayed();
		}
		catch(Exception e)
		{}
		return false;
	}
}
