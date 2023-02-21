package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class steps extends DriverInstance{
	
	@Given("user launch browser and opens URL")
	public void user_launch_browser_and_opens_URL() {
		
		if(br.equals("chrome"))
        {
           driver=new ChromeDriver();
        }
        else if (br.equals("firefox")) 
        {
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge"))
        {
            driver = new EdgeDriver();
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(appurl);
		
		logger.info("opened URL");
		
		driver.manage().window().maximize();
	    
	}

//	@Given("opens URL")
//	public void opens_URL {
//		
//		driver.get(appurl);
//		logger.info("opened URL");
//		driver.manage().window().maximize();
//	}

			
	@When("user clicks on Login after navigating to My Account menu")
	public void user_clicks_on_login_after_navigating_to_my_account_menu() {
	   
		homepage=new HomePage(driver);
		
		homepage.clickMyAccount();
		logger.info("clicked on my account");
		
		homepage.clickLogin();
		logger.info("clicked on login");
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		
		loginpage=new LoginPage(driver);
		
		loginpage.setUsername(username);
		logger.info("passed Username");
		
		loginpage.setPassword(password);
		logger.info("passed password");
	   
	}

	@When("click on login button")
	public void click_on_login_button() {
		
		loginpage.clickLoginButton();
		logger.info("clicked on Login button");
	}

	@Then("user navigates to My Account page")
	public void user_navigates_to_my_account_page() {
	   
		myacc=new MyAccountPage(driver);
		
		if(myacc.validate_MyAccount_label())
		{
			logger.info("login successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("login unsuccessful");
			Assert.assertTrue(false);
		}
	}
}
