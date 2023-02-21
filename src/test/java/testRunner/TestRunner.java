package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( 
					features={"src/test/resources/Features/Login.feature"},		//when you want run specific file
					//features={"src/test/resources/Features"},				//for all of the files in a folder
					//features={"src/test/resources/Features/Login.feature", "src/test/resources/Features/LoginDDT.feature"},		//selected files from a folder
					glue={"stepDefinitions", "hooks"},    //package name,
					dryRun=false,
					monochrome=true,
					plugin= {"pretty","html:reports/cucumber.html",		//generates reports in reports folder
							"json:reports/JSONReports/report.json",
						//	"pretty","html:target/cucumber.html",		//generates reports in target folder
						//	"json:target/JSONReports/report.json",
							}
					
					
				)
public class TestRunner{


}
