package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
					features={".//Features/Login.feature"},		//when you want run specific file
					//features={".//Features//"},				//for all of the files in a folder
					//features={".//Features/Login.feature", ".//Feature/LoginDDT.feature"},		//selected files from a folder
					glue="stepDefinitions",		//package name
					dryRun=false,
					monochrome=false
					
				)
public class TestRunner {

}
