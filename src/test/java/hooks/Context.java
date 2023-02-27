package hooks;

import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;

public class Context {

	private WebDriver driver;
	private HomePage homepage;
	private SearchPage sp;
	
	private MyAccountPage myAcc;
	private LoginPage lp;
	
	private WebDriverWait wait;
	private ResourceBundle rb;
	private String br;
	//private String appurl;
	private Logger logger;

//	public String getAppurl() {
//		return appurl;
//	}
//
//	public void setAppurl(String appurl) {
//		this.appurl = appurl;
//	}

	public ResourceBundle getRb() {
		return rb;
	}

	public void setRb(ResourceBundle rb) {
		this.rb = rb;
	}

	public String getBr() {
		return br;
	}

	public void setBr(String br) {
		this.br = br;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomepage() {
		return homepage;
	}

	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}

	public SearchPage getSp() {
		return sp;
	}

	public void setSp(SearchPage sp) {
		this.sp = sp;
	}

	public MyAccountPage getMyAcc() {
		return myAcc;
	}

	public void setMyAcc(MyAccountPage myAcc) {
		this.myAcc = myAcc;
	}

	public LoginPage getLp() {
		return lp;
	}

	public void setLp(LoginPage lp) {
		this.lp = lp;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
}
