package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws IOException
	{
		
       driver.get(baseURL);
       driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided"); // logger message
		
		lp.setPassword(password);
		logger.info("password is provided"); // logger message
		
		lp.clickLogin();
		
		logger.info("providing customer details...."); // logger message
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		logger.info("clicked on customermenu...."); // logger message
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		logger.info("Clicked on Addnew...."); // logger message
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
		logger.info("providing email...."); // logger message
				
		addcust.setPassword("test123");
		logger.info("providing Password...."); // logger message
		

		addcust.setFirstName("Vinod");
		logger.info("providing First name...."); // logger message
		
		addcust.setLastName("Reddy");
		logger.info("providing Last name...."); // logger message
		
		addcust.setGender("Male");
		logger.info("Clicked on gender...."); // logger message
		
		addcust.setDob("7/05/1985"); // Format : DD/MM/YYYY
		logger.info("providing Date of birth...."); // logger message
		addcust.setCompanyName("busyQA");
		logger.info("providing company name...."); // logger message
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
		logger.info("providing customer roles....");
				
		addcust.setManagerOfVendor("Vendor 2");  // Selection of Vendors 
		logger.info("providing Vendor information....");
		
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		
		logger.info("validation started...."); // logger message
		
		//String message=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true) ;
			logger.info("Test case passed...."); // logger message
		}
		else
		{
			captureScreen(driver,"addNewCustomer"); // logger message
			Assert.assertTrue(false);
		}
				
	}
				
		
}

