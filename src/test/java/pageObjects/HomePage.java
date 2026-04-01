package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends basePage {
	 
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkmyaccount;
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
    WebElement linkregister;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	public void clickMyAccount() {
		linkmyaccount.click();
	}
	
	public void clickRegister() {
		linkregister.click();
	}
	

  public void clickLogin() {
	  linkLogin.click();
  }

}
