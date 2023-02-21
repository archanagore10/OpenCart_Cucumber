package hooks;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks extends DriverInstance{
	
	@Before
	public void setup() throws IOException
	{
		logger=LogManager.getLogger(this.getClass()); 
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
		appurl=rb.getString("appURL");
		//FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		// p=new Properties();
		// p.load(file);
		// br=p.getProperty("browser");
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

}
