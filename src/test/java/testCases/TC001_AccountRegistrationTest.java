package testCases;






import org.testng.Assert;


import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.baseClass;

public class TC001_AccountRegistrationTest extends baseClass{
 
@Test(groups={"Regression","Master"})
public void verify_account_registration() {
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	
	AccountRegisterationPage arp=new AccountRegisterationPage(driver);
	arp.setFirstName(randomString().toUpperCase());
	arp.setLastName(randomString().toLowerCase());
	
	arp.setEmail(randomString()+"@gmail.com");
	arp.setmobile(randomNumber());
	
	String password=randomAlphaNumberic();
	arp.setPassword(password);
	arp.setconpass(password);
	
	arp.clickAgree();
	arp.clickContinue();
	
	String confmsg=arp.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
}
}