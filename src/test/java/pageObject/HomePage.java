package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 

{
	
	 public HomePage(WebDriver driver) 
	{
		super(driver);  //invoking parent class constructor using child class
	}
	
	//Elements
	
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")  //Added in step 6
	WebElement linkLogin;
	
	//Action Methods
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();		
	}
	
	public void clickLogin()
	{
		linkLogin.click();   //Added in step 6
	}
	
	

}
