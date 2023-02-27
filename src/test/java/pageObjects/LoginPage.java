package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	public void setEmail(String mail)
	{
		
		email.clear();
		email.sendKeys(mail);
	}
	
	public void setPassword(String pass)
	{
		
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
}
