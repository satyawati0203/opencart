	package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneno(String phone)
	{
		txtPhone.sendKeys(phone);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void confirmPassword(String pwd)
	{
		confirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacypolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		//Sol1
		
		btnContinue.click();
	}
		
		//Sol2
		/*btnContinue.submit();
		
		//Sol3
		Actions act = new Actions(driver);
		act.moveToElement(btnContinue).click().perform();
		
		//Sol4
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",btnContinue);
		
		//sol5
		btnContinue.sendKeys(Keys.RETURN);
		
		//sol6
		
		//WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			*/
		
     	public String getConfirmationMsg()
		{
			try
			{
				return(msgConfirmation.getText());
			}catch(Exception e)
			{
				return(e.getMessage());
			}
		
		
		
	}
}

