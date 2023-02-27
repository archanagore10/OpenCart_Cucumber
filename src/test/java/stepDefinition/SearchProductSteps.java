package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import hooks.Context;
import hooks.DriverInstance;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchProductSteps extends DriverInstance{

	@When("user search a {string}")
	public void user_search_a(String pname) throws InterruptedException {
		
		homepage=new HomePage(driver);
		
		Thread.sleep(1000);
		homepage.SearchProduct(pname);
		homepage.clickSearchButton();
		
		
	}

	@When("clicks on the {string}")
	public void clicks_on_the(String pname){
		
		sp=new SearchPage(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]//img")));
		sp.searchAProduct(pname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]//img")));
		sp.clickOnSearchedProduct(pname);
	}
	
	@When("adds it to the cart")
	public void adds_it_to_the_cart() throws InterruptedException {
	  
		sp=new SearchPage(driver);
		
		Thread.sleep(1000);
		sp.addToCart();
	}

	@Then("add to cart is successful")
	public void add_to_cart_is_successful() {
	  
		sp=new SearchPage(driver);
//		WebElement actual_msg=driver.findElement(By.xpath("//div[text()='Success: You have added ']"));
//		
//		String act_msg=actual_msg.getText();
//		System.out.println("actual message: "+act_msg);
		//sp.verifySuccessMsg();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Success: You have added ']")));
	   if(sp.verifySuccessMsg())
	   {
		   System.out.println("success message:"+sp.verifySuccessMsg());
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   System.out.println("success message:"+sp.verifySuccessMsg());
		   Assert.assertTrue(false);
	   }
	 //  driver.quit();
	}
}
