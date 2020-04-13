package ctsNaukriProject.Runner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


/**
 * @author Bhavani_Harika
 * @author Pavan_Lanke
 * @author Hari_Krishna
 * Class created to Run valiLogin feature
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="features",
tags= {"@validLogin"},
glue= {"ctsNaukriProject.stepDefinition"},
plugin= {"html:target/cucumber-html.report"})

public class ctsNaukriProjectRunner {
	private TestNGCucumberRunner testRunner;



	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(ctsNaukriProjectRunner.class);			
	}

	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}

	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}

	@AfterClass
	public void tearDown() throws InterruptedException
	{		
		testRunner.finish();


	}

}