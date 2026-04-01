package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.baseClass;

public class TC002_LoginTest extends baseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		HomePage hp=new HomePage(driver);
	    hp.clickMyAccount();
	    hp.clickLogin();
	    
	    loginPage lp=new loginPage(driver);
	    lp.setEmail(p.getProperty("email"));
	    lp.setPass(p.getProperty("password"));
		lp.clickLogin();
		lp.clickLogout();
		
		myAccountPage map=new myAccountPage(driver);
		boolean targetPage=map.IsMyAccountPageExists();
		
		Assert.assertEquals(targetPage,true,"Login failed");
	}
	
	
	

}
