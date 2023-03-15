package hooks;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks extends DriverInstance {

//	@Before(order=1)		//to test order of execution
//	public void beforeScenario(Scenario scenario)
//	{
//		System.out.println("running before setup method");
//	}

	@Before
	public void setup() throws IOException {
		logger = LogManager.getLogger(this.getClass());

//		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
//				 p=new Properties();
//				 p.load(file);
//				 br=p.getProperty("browser");

		rb = ResourceBundle.getBundle("config");
		br = rb.getString("browser"); // browser is from config file

		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (br.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println("browser is: " + br);

		// url is from config file
		// appurl=p.getProperty("appURL");
		appurl = rb.getString("appURL");
		driver.get(appurl);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status===>" + scenario.getStatus()); // to get the status of the scenario-pass or
																			// fail

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		driver.quit();
	}

	// optional part. takes screenshot before and after each step
//	@BeforeStep
//	public void beforeStep(Scenario scenario)
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshot, "image/png",scenario.getName());
//	}
//	
//	@AfterStep
//	public void afterStep(Scenario scenario)
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshot, "image/png",scenario.getName());
//	}

}
