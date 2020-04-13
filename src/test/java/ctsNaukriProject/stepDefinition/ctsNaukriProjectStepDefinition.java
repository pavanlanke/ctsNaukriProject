package ctsNaukriProject.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import  ctsNaukriProject.libraries.Screenshot;

import ctsNaukriProject.libraries.BrowserFactory;
import ctsNaukriProject.libraries.ConfigReader;
import ctsNaukriProject.libraries.ExcelDataConfig;
import ctsNaukriProject.pages.*;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @author Bhavani_Harika
 * @author Pavan_Lanke
 * @author Hari_Krishna
 * Class created for writing test cases
 */
public class ctsNaukriProjectStepDefinition {
	WebDriver driver;
	ConfigReader set;
	ITestResult result;
	ExcelDataConfig config;
	ctsNaukriProjectHomePage page2;
	ctsNaukriProjectLoginWithPageFactory loginpage;
	Logger logger=Logger.getLogger("LogDemo");
	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport.html");
	ExtentTest ext_Rprt = report.startTest("NaukriProjectReport");
	/**
	 * Method to open website in Browser
	 */

	@Given("^Open chrome and start application$")
	public void open_chrome_and_start_application() throws Throwable {

		PropertyConfigurator.configure("Log4j.properties");


		BrowserFactory browserfactory=new BrowserFactory();


		set=new ConfigReader();

		driver=browserfactory.startBrowser("chrome",set.getApplicationURL());
		logger.info("Chrome Driver Opened and navigated to Url");
		ext_Rprt.log(LogStatus.PASS,"Browser opened and navigate URL");

	}
	/**
	 * Method for closing all popups 
	 */
	@When("^closing popUps and click login$")
	public void closing_popUps_and_click_login() throws Throwable {
		loginpage=PageFactory.initElements(driver,ctsNaukriProjectLoginWithPageFactory.class);

		loginpage.ClickLogin();
		ext_Rprt.log(LogStatus.PASS,"Clicking Login Button");
		logger.info("Successfully clicks on Login button");

		loginpage.ClosePopUps();
		ext_Rprt.log(LogStatus.PASS,"closed All PopUps");
		logger.info("Successfuly closed all PopUps");

	}
	/**
	 * Method to pass credentials from ExcelSheet 
	 */
	@When("^I enter valid (\\d+)$")
	public void i_enter_valid(String usernameNumber) throws Throwable {
		ExcelDataConfig config=new ExcelDataConfig(set.getExcelExcess());
		Object[][] data=config.passData();
		String username="";
		String password="";

		if(null!= usernameNumber ) {
			int userCount = Integer.parseInt(usernameNumber.trim());

			username = (String )data[userCount-1][0];
			password = (String )data[userCount-1][1];	
		}

		loginpage.typeUserNameAndPassword(username, password);
		ext_Rprt.log(LogStatus.PASS,"Reads Data From ExcelSheet");
		logger.info("Successfully Read Data From Excel Sheet");

	}
	/**
	 * Method to click loginbutton for login to website
	 */
	@When("^user should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
		loginpage.clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertEquals("https://www.naukri.com/", driver.getCurrentUrl());
		ext_Rprt.log(LogStatus.PASS, "Authentication sucessfully");
		logger.info("Successfully login to Naukri Website");



	}
	/**
	 * Method to click logoutbutton for logout using mouse hover Actions
	 */
	@When("^user should be able to log out$")
	public void user_should_be_able_to_log_out() throws Throwable {
		page2=PageFactory.initElements(driver, ctsNaukriProjectHomePage.class);
		Thread.sleep(5000);
		page2.mouseAction(driver);
		ext_Rprt.log(LogStatus.PASS, "Successfully Logout");
		logger.info("Successfully Logout");


	}
	/**
	 * Method to close close the Browser
	 */

	@Then("^application should be closed$")
	public void application_should_be_closed() throws Throwable {
		driver.quit();
		ext_Rprt.log(LogStatus.PASS, "Successfully quits The Browser");
		report.endTest(ext_Rprt);
		report.flush();
		logger.info("successfully close the Browser");



	}
	/**
	 * Method to pass credentials from feature
	 */

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String username, String password) throws Throwable {
		loginpage=PageFactory.initElements(driver, ctsNaukriProjectLoginWithPageFactory.class);

		loginpage.ClickLogin();
		ext_Rprt.log(LogStatus.PASS,"Clicking Login Button");
		logger.info("successfully clicks on Login button");
		loginpage.ClosePopUps();
		ext_Rprt.log(LogStatus.PASS,"closed All PopUps");
		logger.info("Successfuly closed all PopUps");
		loginpage.typeUserNameAndPassword(username, password);
		ext_Rprt.log(LogStatus.PASS,"Reads initialized data from feature");
		logger.info("successfully Read Data initialized in feature");
	}


	/**
	 * Method to search an element in home page and print text using getText 
	 */
	@When("^Search field in home page$")
	public void search_field_in_home_page() throws Throwable {

		page2=PageFactory.initElements(driver, ctsNaukriProjectHomePage.class);
		Thread.sleep(5000);
		page2.text();
		ext_Rprt.log(LogStatus.PASS,"get text using getTextMethod");
		logger.info("successfully get text from Home Page");


	}
	/**
	 * Method to click logoutbutton for logout using mouse hover Actions
	 */

	@When("^user should able to logout using mousehover$")
	public void user_should_able_to_logout_using_mousehover() throws Throwable {
		Thread.sleep(5000);
		page2.mouseAction(driver);	
		ext_Rprt.log(LogStatus.PASS,"Successfilly Logout");
		logger.info("Successfully Logout");
	}

	/**
	 * Method for passing values to search box
	 */
	@When("^user pass the v alues to Search$")
	public void user_pass_the_v_alues_to_Search() throws Throwable {
		page2=PageFactory.initElements(driver, ctsNaukriProjectHomePage.class);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		page2.TypeSkillAndLocality("TestEngineer", "Vijayawada");
		ext_Rprt.log(LogStatus.PASS,"sends Data to Search box");
		logger.info("Successfuly sends Data to Search box");

	}
	/**
	 * Method for taking screenshot of search box after passing values
	 */

	@When("^taking Screenshot$")
	public void taking_Screenshot() throws Throwable {
		Screenshot screenshot=new Screenshot();
		screenshot.getScreenshot(driver);
		ext_Rprt.log(LogStatus.PASS,"screenshot taken");
		logger.info("Successfully take Screenshot");
		page2.clickSearch();

	}
	/**
	 * Method to pass Invalid credentials from ExcelSheet
	 */


	@When("^I enter Invalid (\\d+)$")
	public void i_enter_Invalid(String usernameNumber) throws Throwable {
		ExcelDataConfig config=new ExcelDataConfig(set.getExcelExcess());
		Object[][] data=config.passData();
		String username="";
		String password="";

		if(null!= usernameNumber ) {
			int userCount = Integer.parseInt(usernameNumber.trim());

			username = (String )data[userCount-1][0];
			password = (String )data[userCount-1][1];	
		}

		loginpage.typeUserNameAndPassword(username, password);

		logger.info("Passed Invalid Credintials");

	}
	/**
	 * Method to click loginbutton for login to website
	 */
	@When("^user should not able to login$")
	public void user_should_not_able_to_login() throws Throwable {

		loginpage.clickOnLoginButton();
		ext_Rprt.log(LogStatus.FAIL,"Login Failed");
		logger.info("Login Failed");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	/**
	 * Method for taking screenshot after login failed
	 */
	@When("^taking screenshot$")
	public void taking_screenshot() throws Throwable {
		Screenshot screenshot=new Screenshot();
		screenshot.getScreenshot(driver);
		logger.info("Successfully takes screenshot");

	}

}
