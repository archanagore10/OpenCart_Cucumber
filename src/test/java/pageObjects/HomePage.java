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

	@FindBy(xpath="//ul[@class='list-inline']/li[2]/a")
	WebElement myAccount;
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	//@FindBy(xpath="//div[@id='search']/input")
	@FindBy(name="search")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	WebElement searchButton;
	
	@FindBy(linkText = "Register")
	WebElement registerButton;
	
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickLoginLink()
	{
		loginLink.click();
	}
	
	public void SearchProduct(String product)
	{
		searchBox.clear();
		searchBox.sendKeys(product);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void clickRegisterButton()
	{
		try {
		registerButton.click();
		}catch(Exception e)
		{}
	}
	
}
