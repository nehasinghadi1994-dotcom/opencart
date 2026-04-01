package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {
	
	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
   
	public void setPass(String pass) {
		txtPass.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}
