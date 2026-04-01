package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends basePage {
	
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement mobile;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement conpass;

    @FindBy(xpath="//input[@name='agree']")
    WebElement confirm;
    
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btncontinue;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
    public void setFirstName(String fname) {
    	txtFirstname.sendKeys(fname);
    }
    
    public void setLastName(String Lname) {
    	txtLastname.sendKeys(Lname);
    }
    
    public void setEmail(String email) {
    Email.sendKeys(email);
    }
    
    public void setmobile(String moblie) {
    	mobile.sendKeys(moblie);
    }
    public void setPassword(String pwd) {
    	password.sendKeys(pwd);
    }
    
    public void setconpass(String conpwd) {
    	conpass.sendKeys(conpwd);
    }
    public void clickAgree() {
    	confirm.click();
    }
    
    public void clickContinue() {
    	btncontinue.click();;
    }
    
    public String getConfirmationMsg() {
    	try {
    		return (msgConfirmation.getText());
    	}
    	catch(Exception e) {
    		return(e.getMessage());
    	}
    	}
    

}