package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import utilities.DataProviders;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password, String res)
	{
		
		logger.info("Starting TC003_DataDriverTest");
		try
		{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		
		if(res.equalsIgnoreCase("Valid"))
				{
			 		if(targetpage==true)
			 		{
			 			macc.clickLogout();
			 			Assert.assertTrue(true);		
			 		}
			 		else
			 		{
			 			Assert.assertTrue(false);
			 		}
				}
		else if(res.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else if(targetpage==false)
			{
				Assert.assertTrue(true);
			}
		}
	
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("Finishing TC003_LoginDataDriven");
}
}
