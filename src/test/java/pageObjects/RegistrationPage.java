package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	//WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="telephone")
	WebElement phoneNumber;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueButton;
	
	public void setFirstName(String fname)
	{
		firstName.clear();
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		firstName.clear();
		firstName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		firstName.clear();
		firstName.sendKeys(mail);
	}
	
	public void setTelephone(String phone)
	{
		firstName.clear();
		firstName.sendKeys(phone);
	}
	
	public void setPassword(String pass)
	{
		firstName.clear();
		firstName.sendKeys(pass);
	}
	
	public void setConfirmPassword(String cpass)
	{
		firstName.clear();
		firstName.sendKeys(cpass);
	}
	
	public void AcceptPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}

}
