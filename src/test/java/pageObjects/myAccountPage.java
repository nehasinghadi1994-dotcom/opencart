package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends basePage {

	public myAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	public boolean IsMyAccountPageExists() {
		
		try{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
 

}
