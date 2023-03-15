package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import hooks.DriverInstance;
import hooks.MyHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchProductSteps extends DriverInstance {
	
	
	//WebDriver driver=MyHooks.driver;
	
	@When("user search a {string}")
	public void user_search_a(String pname) throws InterruptedException {

		homepage = new HomePage(driver);

		Thread.sleep(1000);
		logger.info("searching a product");
		homepage.SearchProduct(pname);
		
		logger.info("clicking on search button");
		homepage.clickSearchButton();

	}

	@When("clicks on the {string}")
	public void clicks_on_the(String pname) throws InterruptedException {

		sp = new SearchPage(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]//img")));

		sp.searchAProduct(pname);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]//img")));
		
		logger.info("clicking on a searched  product");
		sp.clickOnSearchedProduct(pname);
	}

	@When("adds it to the cart")
	public void adds_it_to_the_cart() {

		sp = new SearchPage(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button-cart']")));
		logger.info("clicking on add to cart button");
		sp.addToCart();
	}

	@Then("add to cart is successful")
	public void add_to_cart_is_successful() {

		sp = new SearchPage(driver);
//		WebElement actual_msg=driver.findElement(By.xpath("//div[text()='Success: You have added ']"));
//		
//		String act_msg=actual_msg.getText();
//		System.out.println("actual message: "+act_msg);
		// sp.verifySuccessMsg();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Success: You have added ']")));
		if (sp.verifySuccessMsg()) {
			System.out.println("success message:" + sp.verifySuccessMsg());
			
			logger.info("add to cart successful");
			Assert.assertTrue(true);
		} else {
			System.out.println("success message:" + sp.verifySuccessMsg());
			
			logger.info("add to cart unsuccessful");
			Assert.assertTrue(false);
		}
		// driver.quit();
	}
}
