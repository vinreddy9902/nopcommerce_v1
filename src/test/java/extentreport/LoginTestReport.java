package extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestReport {
	
	static WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	
	@Test
	
	public void loginTest()
	{
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		// Enter user name
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				
				// Enter Password
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				
				// click on login
				driver.findElement(By.name("login-button")).click();
				Assert.assertEquals(driver.getTitle(),"Swag Labs");
				
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		 driver.close();
	}
	
	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException

	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File source= ts.getScreenshotAs(OutputType.FILE); // This will capture screenshot 
			File target= new File(System.getProperty("user.dir") +"/Screenshot/" +result.getName() +".png");
			FileUtils.copyFile(source, target);
			System.out.println("screenshot captured");
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
