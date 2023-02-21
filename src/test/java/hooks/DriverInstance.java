package hooks;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class DriverInstance {
	
	protected static WebDriver driver;
	protected static Logger logger;
	//protected static Properties p;
	protected static ResourceBundle rb;
	public static String br;
	public static HomePage homepage;
	public static LoginPage loginpage;
	public static MyAccountPage myacc;
	public static String appurl;
}
