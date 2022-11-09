package day20sept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		// open URL
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		WebElement ddown=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]/select[1]"));
		
		
		// Create select class object 
		Select select=new Select(ddown);
		System.out.println(select.getOptions().size());
		
		// Extract all options from drop down and print them 
		List<WebElement>options=select.getOptions();
		
		for(WebElement e:options)
		{
			System.out.println(e.getText());
			
		}
		
		// To select options from drop down
		select.selectByIndex(50);
		
		Thread.sleep(3000);
		select.selectByValue("CAN");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
