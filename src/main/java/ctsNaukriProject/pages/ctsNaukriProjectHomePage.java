package ctsNaukriProject.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Pavan_Lanke
 * @author Hari_Krishna
 * @author Bhavani_Harika
 * Class created to Automate on Home Page
 */
public class ctsNaukriProjectHomePage {
	WebDriver driver;

	@FindBy(how=How.ID,using="qsb-keyskill-sugg")
	WebElement Skill;
	@FindBy(how=How.ID,using="qsb-location-sugg")
	@CacheLookup
	WebElement Locality;
	@FindBy(how=How.XPATH,using="//button[@class='col search l2 btn btn-mid']")
	@CacheLookup
	WebElement Search;
	By myNaukri=By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/ul[2]/li[2]/a[1]/div[2]");
	By select=By.linkText("Logout");
	@FindBy(how=How.XPATH,using="//div[@class='mTxt'][contains(text(),'Services')]")
	@CacheLookup
	WebElement Line;

	public void mouseAction(WebDriver driver) {

		Actions mouse=new Actions(driver);
		WebElement mousehover=driver.findElement( myNaukri);
		mouse.moveToElement(mousehover).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(select).click();
		mouse.moveToElement(mousehover).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		driver.close();
	}
	/**
	 * Method to get Text From home Page
	 */
	public void text() {
		String line=Line.getText();
		System.out.println(line);

	}	
	/**
	 * Method to pass values to Search box
	 */
	public void TypeSkillAndLocality(String desg,String area) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		Skill.sendKeys(desg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Locality.sendKeys(area);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	}
	/**
	 * Method to click Search Button
	 */

	public void clickSearch() {

		Search.click();
	}
}

