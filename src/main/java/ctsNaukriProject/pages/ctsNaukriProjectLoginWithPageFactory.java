package ctsNaukriProject.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Hari_Krishna
 * @author Pavan_Lanke
 * @author Bhavani_Harika
 * Class created for Login page using pageFactory
 */
public class ctsNaukriProjectLoginWithPageFactory {
	WebDriver driver;

	@FindBy(how=How.CSS,using="div.headGNBWrap.initial.fixed div.headGNB.cloneCont.wrap ul.midSec.menu:nth-child(2) li:nth-child(7) a:nth-child(1) > div.mTxt")
	@CacheLookup
	WebElement Login;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/input[1]")
	@CacheLookup
	WebElement Username;

	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter your password']")
	@CacheLookup
	WebElement password;

	@FindBy(how=How.CSS,using="div.naukri-drawer.right.open div.drawer-wrapper div.login-layer form.form div:nth-child(5) > button.btn-primary.loginButton")
	@CacheLookup
	WebElement submit_button;
    /**
     * Method to declare driver
     */
	public ctsNaukriProjectLoginWithPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	 /**
     * Method to click Login Button
     */
	public void ClickLogin() {
		Login.click();
	}
	 /**
     * Method to pass crediantials
     */
	public void typeUserNameAndPassword(String userid,String pass) {
		Username.sendKeys(userid);
		password.sendKeys(pass);
	}
	 /**
     * Method to click Login Button
     */
	public void clickOnLoginButton() {
		submit_button.click();
	}
	 /**
     * Method to close all popups
     */
	public void ClosePopUps() {
		String mainWindow=driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}
}