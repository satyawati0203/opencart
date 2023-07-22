package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

import pageObject.HomePage;
import pageObject.AccountRegistrationPage;



public class TC001_AccountRegistrationTest extends BaseClass{
	
	//In any test case 3 section we have to create
	//1. entry (Setup method)
	//2. test
	//3. exit (tear down method)
	
	@Test
	public void test_account_Registration()
	{
		
		logger.info("***********Starting  TC001_AccountRegistrationTest  ********");
		logger.debug("Generating debug logs");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my Account link");
		
		hp.clickRegister();
		logger.info("Clicked on Registration link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setemail(randomString()+"@gmail.com");
		regpage.setPhoneno(randomNumber());
		String pwd = randomAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.confirmPassword(pwd);
		regpage.setPrivacypolicy();
		regpage.clickContinue();
		
		logger.info("Clicked on continue button");
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***********Finished  TC001_AccountRegistrationTest  ********");
		
		
		
	}

}
