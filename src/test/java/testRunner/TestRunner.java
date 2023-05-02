package testRunner;

import org.testng.annotations.DataProvider;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(glue={"stepDefinition","hooks"},
				
				monochrome=true,
				//features= {"src/test/resources/Features/Login.feature"},
				features= {"src/test/resources/Features"},// "src/test/resources/Features/Login.feature"},
				//features="@target/rerun.txt",		//runs failures only
				
				dryRun=!true,	//when dryrun=true shows only implemented steps. no print statements
				//snippets = SnippetType.CAMELCASE,	//shows snippets without underscore
				
				tags="@one",		//do not use curly braces. shows type mismatch error.
				plugin= {"pretty","html:CucumberReports.html",	//without pretty only print statements are seen in console
						
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						
						"json:Reports/jsonReports.json",
						"junit:Reports/JunitReports.xml",	// to capture failures
						"rerun:target/rerun.txt"
						}
				
					)
//public class TestRunner {
	
public class TestRunner extends AbstractTestNGCucumberTests{
	
//	 @Override								//these 4 stmts are for parallel execution using testNG
//	    @DataProvider(parallel = true)			//make parallel= true when want to run parallely
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//}
}
   