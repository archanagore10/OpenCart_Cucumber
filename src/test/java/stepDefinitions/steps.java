package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class steps {
	
	WebDriver driver;
	Logger logger;
	Properties p;
	//ResourceBundle rb;
	public String br;
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myacc;
	
	@Before
	public void setup() throws IOException
	{
		logger=LogManager.getLogger(this.getClass()); 
		//rb=ResourceBundle.getBundle("config");
		//br=rb.getString("browser");
		
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 p=new Properties();
		 p.load(file);
		 br=p.getProperty("browser");
		 System.out.println("browser is"+br);
		 
	}
	
	@After
	public void tearDown(Scenario scenario) 
	{
		System.out.println("Scenario status===>"+scenario.getStatus());	//to get the status of the scenario-pass or fail
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png",scenario.getName());
			
		}
		
		driver.quit();
	}
	
	@Given("user launch browser")
	public void user_launch_browser() {
		
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
	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
		
		driver.get(url);
		logger.info("opened URL");
		driver.manage().window().maximize();
	}

	//@When("user navigate to My Account menu")
	//public void user_navigate_to_my_account_menu() {
		
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
