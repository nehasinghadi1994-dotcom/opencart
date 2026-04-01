package testCases;


	

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import pageObjects.HomePage;
	import pageObjects.loginPage;
	import pageObjects.myAccountPage;
import testBase.baseClass;
import utilities.DataProviders;

	public class TC003_dataDrivenTest extends baseClass {
		
		@Test(dataProvider="loginData", dataProviderClass=DataProviders.class, groups="DataDriven")
		public void verify_login(String email, String pass, String exp) throws InterruptedException {
			
			try {
			
			HomePage hp=new HomePage(driver);
		    hp.clickMyAccount();
		    hp.clickLogin();
		    
		    loginPage lp=new loginPage(driver);
		    lp.setEmail(email);
		    lp.setPass(pass);
			lp.clickLogin();
			lp.clickLogout();
			
			myAccountPage map=new myAccountPage(driver);
			boolean targetPage=map.IsMyAccountPageExists();
			
			/* Data is valid-login success-test pass-logout
			  Data is valid-login failed-test fail
			 
			Data is invalid-login success-test fail- logout
			Data is invalid-login failed-test pass  */
			
			
			
			
			if(exp.equalsIgnoreCase("valid")) {
				if(targetPage==true) {
					
					lp.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
		}
			if(exp.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
				 lp.clickLogout();
				 Assert.assertTrue(false);
				}
				else {
					Assert.fail();
				}
			}
			}
			catch(Exception e) {
				Assert.fail();
			}
			Thread.sleep(2000);
		
		
		

	}

}
