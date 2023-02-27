package hooks;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;

public class DriverInstance {
	
	protected static Logger logger;
	protected static WebDriver driver;
	public static HomePage homepage;
	public static SearchPage sp;
	public static RegistrationPage registerPage;
	public static AccountCreatedPage accPage;
	
	public static MyAccountPage myacc;
	public static LoginPage loginpage;
	
	public static ResourceBundle rb;
	public static String br;
	public static String appurl;
	public static WebDriverWait wait;
}
