package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import java.util.ResourceBundle;  //loading properties file

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.apache.commons.io.*;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb ;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		rb = ResourceBundle.getBundle("config");// Reading data from properties file
		logger = LogManager.getLogger(this.getClass());//log4j
		
		if (br.equalsIgnoreCase("Chrome"))
		{
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			logger.info("Launching Edge Browser");
			driver = new EdgeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));  // local app url
		
		//driver.get("https://demo.opencart.com/index.php");   // remote App URL
		logger.info("Launching the browser");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("Closing the Application");
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return(generatedString+generatedNumber);
	}
	
	public String captureScreen(String tname) throws IOException
	{	
		Date dt = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestamp = sp.format(dt);
		
		TakesScreenshot  takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "\\Screenshots\\"+ tname +"_"+ timestamp+".png";
		
		try
		{
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

	

}