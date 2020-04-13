package ctsNaukriProject.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author pavan_Lanke
 * BrowserFactory or WebDriverFactory class, which will initialize the requested browser for the test
 */
public class BrowserFactory {
	public WebDriver driver;
	/*
	 *  Method to open the Website in Chrome browser or Firefox Browser
	 */
	public WebDriver startBrowser(String browserName,String url) {
		ConfigReader config=new ConfigReader();
		//To open website in ChromeBrowser
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",config.getchromepath());
			driver=new ChromeDriver();
		}
		//To open the website in FireFoxBrowser
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", config.firefoxpath());
			driver=new FirefoxDriver();
		}
		
		/*
		 * To maximize Browser Window
		 */
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}