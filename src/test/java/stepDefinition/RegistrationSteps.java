package stepDefinition;

import java.util.List;

import org.testng.Assert;

import hooks.DriverInstance;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationSteps extends DriverInstance{
	
	@When("user clicks on rgister after navigationg to My Account menu")
	public void user_clicks_on_rgister_after_navigationg_to_my_account_menu(){
	   
		homepage=new HomePage(driver);
		
		homepage.clickMyAccount();
		homepage.clickRegisterButton();
	    
	}

	@When("user enters following user details")
	public void user_enters_following_user_details(DataTable userData) throws InterruptedException{
	   
		registerPage=new RegistrationPage(driver);
		
		List<List<String>> data=userData.asLists();
		for(List<String> e :data)
		{
			Thread.sleep(1000);
			registerPage.setFirstName(e.get(0));
			registerPage.setLastName(e.get(1));
		}
	    
	}

	@When("user accepts privacy policy")
	public void user_accepts_privacy_policy() {
	   
		registerPage=new RegistrationPage(driver);
		registerPage.AcceptPrivacyPolicy();
	}

	@When("clicks on continue button")
	public void clicks_on_continue_button() {
	   
		registerPage=new RegistrationPage(driver);
		registerPage.clickContinueButton();;
	    
	}

	@Then("Registration should be successful")
	public void registration_should_be_successful() {
	   
	    accPage=new AccountCreatedPage(driver);
	   if(accPage.verifyAccountCreatedMessage())
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	   
	  // accPage.clickLogout();
	}

}
