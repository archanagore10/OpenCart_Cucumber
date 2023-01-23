package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(xpath="//div[@id='content']/h2[1]")
	WebElement myacc_label;
	
	public boolean validate_MyAccount_label()
	{
		try
		{
			return myacc_label.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}		
	}
}
