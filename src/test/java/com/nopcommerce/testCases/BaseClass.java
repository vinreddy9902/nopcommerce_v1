package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.nopcommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig(); // TO get variables from read config class
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	

	@BeforeClass
	public void setUp()
	{
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 logger = Logger.getLogger("TC_LoginTest_001.class"); // it will initiate logger object
		 PropertyConfigurator.configure("Log4j.properties");
		 
		
	}
	

	   public void tearDown()
	   {
		   driver.quit();
	   }
	   
	   

		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	
		public static String randomestring() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}

		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}

		
		
	

}
