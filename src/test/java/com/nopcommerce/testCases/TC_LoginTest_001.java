package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is Opened");  //  TO display logger message
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("UserName Provided");  // logger message
		lp.setPassword(password);
		
		logger.info("Password Provided");
		
		lp.clickLogin();
		logger.info("Login is Clicked");   // logger message
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed");  // logger message  
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");  // Logger message
		}
		
	}
	

	
	
	
	
	

}
