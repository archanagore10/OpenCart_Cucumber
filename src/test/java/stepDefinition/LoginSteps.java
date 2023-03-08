package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


import hooks.DriverInstance;
import hooks.MyHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utils.ExcelReader;
  
public class LoginSteps extends DriverInstance{

	
	//WebDriver driver=MyHooks.driver;
	
	@Given("user is on Home page")
	public void user_is_on_Home_page() {
	
		homepage=new HomePage(driver);
	}
		
	
	@When("user clicks on Login after navigating to My Account menu")
	public void user_clicks_on_login_after_navigating_to_my_account_menu() 
	{
		
	  homepage=new HomePage(driver);
	   homepage.clickMyAccount();
	   logger.info("clicked on my account");
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
	   homepage.clickLoginLink();
	   logger.info("clicked on login");    
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String pwd) {
		
		
		loginpage=new LoginPage(driver);
		loginpage.setEmail(email);
	   logger.info(" Username entered");
	   
	   loginpage.setPassword(pwd);
	   logger.info(" password entered");
	}

	
	//data driven step
	@When("user enters email and password from excel {string} and {int}")
	public void user_enters_email_and_password_from_excel_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		loginpage=new LoginPage(driver);
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData(".\\testData\\opencartlogindata.xlsx", sheetName);		//path of excel testdata file
			
		String username = testData.get(rowNumber).get("username");
		String password = testData.get(rowNumber).get("password");
		
		
		loginpage.setEmail(username);
		loginpage.setPassword(password);
	    
	}
	
	@When("click on login button")
	public void click_on_login_button() {
	   
		loginpage.clickLoginButton();
		logger.info("clicked on Login button");
	}

	@Then("user navigates to My Account page")
	public void user_navigates_to_my_account_page() {
	   
		myacc=new MyAccountPage(driver);
		if(myacc.visibilityOf_myAccountLabel())
		{
			logger.info("login successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("login unsuccessful");
			Assert.assertTrue(false);
		}
		
		myacc.clickLogOutLin();
				
	}

	@Then("user should not navigate to My Account page")
	public void user_should_not_navigate_to_my_account_page() {
		
		myacc=new MyAccountPage(driver);
		
		if(myacc.visibility_Of_logout())
		{
			Assert.assertTrue(false);
		}
		
		else 
		{
			Assert.assertTrue(true);
		}
		//driver.quit();
		
		
	}
}


