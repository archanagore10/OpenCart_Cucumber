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
	WebElement login_btn;
	
	
	public void setUsername(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		login_btn.click();
	}
	
	
}
