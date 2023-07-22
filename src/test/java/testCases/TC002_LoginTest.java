package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;


//This is my login Test
public class TC002_LoginTest extends BaseClass{
	
	@Test
	
	public void Test_Login()
	{
		logger.info("Starting TC002_LoginTest....");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		MyAccountPage macc =new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished TC002_LoginTest");
	}
	

}
	
	







