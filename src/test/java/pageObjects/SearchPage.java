package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	// @FindBy(xpath="//*[@class='caption']/h4/a") //with <a> tag
	@FindBy(xpath = "//*[@id='content']/div[3]//img") // with img tag
	// @FindBy(xpath="//div[@class='caption']/h4/a")
	// @FindBy(xpath="//div/a[contains(@href, 'product_id')]")
	List<WebElement> searchedProduct;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addtocart;

	// @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	@FindBy(xpath = "//div[text()='Success: You have added ']")
	WebElement successMsg;

	// checking if searched product is available
	public boolean searchAProduct(String productName) {
		boolean flag = false;
		for (WebElement product : searchedProduct) {
			
			 //if(product.getText().contains(productName))	//not working
			//if(product.getText().equalsIgnoreCase(productName))		//not working
			if (product.getAttribute("title").equalsIgnoreCase(productName)) 
				 
			 {
				flag = true;
				break;
			}
		}
		return flag;
	}

	// clicking on a product
	public void clickOnSearchedProduct(String productName) {
		try { // try catch block is to handle StaleReferenceElementException
			
			for (WebElement product : searchedProduct) {
				
				 //if(product.getText().contains(productName))		//not working
				//if(product.getText().equalsIgnoreCase(productName))		//not working
				if (product.getAttribute("title").equalsIgnoreCase(productName))
				{
					product.click();
				}
			}
		} catch (Exception e) {
		}
	}

	public void addToCart() {

		addtocart.click();

	}

	public boolean verifySuccessMsg() {
		successMsg.isDisplayed();

		try {
			return successMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
}
