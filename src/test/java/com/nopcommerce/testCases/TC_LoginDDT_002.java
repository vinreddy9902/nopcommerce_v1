package com.nopcommerce.testCases;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginData(String user, String pwd) throws InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User provided"); // logger message
		
		lp.setPassword(pwd);
		logger.info("Password provided"); // logger message
		
		lp.clickLogin();
		logger.info("Login in Clicked"); // logger message
		
		Thread.sleep(2000);
		

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
					
		} else {
			
			Assert.assertTrue(false);
			logger.info("Login Failed"); // logger message
			
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/Copy of LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		return logindata;
		
	}
	

}
